package theme5gc.task3;

import java.io.InputStream;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

public class Main {

    // пример использования soft reference
    // большое изображение каждый раз грузить накладно, поэтому лучше его кэшировать в память
    // но как только память будет кончаться, его удалит GC
    private static final String IMAGE_NAME = "bigImage.jpg";
    private SoftReference<InputStream> defaultImageRef;

    public InputStream loadImage() {
        InputStream defaultImage = defaultImageRef.get();
        if (defaultImage == null) {
            defaultImage = this.getClass().getResourceAsStream(IMAGE_NAME);
            defaultImageRef = new SoftReference(defaultImage);
        }
        return defaultImage;
    }

    // пример использования weak reference
    // аналог String.intern(value)
    private static Map<String, WeakReference<String>> stringPool = new WeakHashMap<>();

    public String getFromPool(String value) {
        WeakReference<String> stringRef = stringPool.get(value);
        if (stringRef == null || stringRef.get() == null ) {
            stringRef = new WeakReference<>(value);
            stringPool.put(value, stringRef);
        }
        return stringRef.get();
    }

    public static void main(String[] args) {
        // strong reference
        // обычная ссылка
        StringBuilder builder = new StringBuilder();

        // soft reference on builder
        // после обнуления ссылки builder, останется мягкая ссылка на объект StringBuilder в куче
        // при угрозе OutOfMemory, такие ссылки будут удалены
        SoftReference<StringBuilder> softBuilder = new SoftReference(builder);

        // GC для работы с weak и phantom references использует очередь для удаления ReferenceQueue
        ReferenceQueue queue = new ReferenceQueue();

        // weak reference
        // после обнуления ссылки builder, останется слабая ссылка на объект StringBuilder в куче
        // такие ссылки будут удалены при следующем проходе GC
        WeakReference weakRef = new WeakReference(builder, queue);

        // phantom reference
        // GC пометил ссылку на удаление, но метод finalize ещё не был вызван
        // используется для того чтобы GC вызвал у этой ссылки finalize, когда дойдёт до неё
        PhantomReference<StringBuilder> phantomRef = new PhantomReference(builder, queue);
    }
}
