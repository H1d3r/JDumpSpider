package cn.wanghw.utils;

/**
 * Caps that keep full-heap scans from exhausting the analyzer JVM.
 */
public final class SpiderLimits {
    /** Max characters materialized from a single dump String / char[]. */
    public static final int MAX_STRING_CHARS = 1024 * 1024;
    /** Max characters kept in one spider's result text. */
    public static final int MAX_RESULT_CHARS = 8 * 1024 * 1024;
    /** Max instances visited for one class in a fuzzy scan. */
    public static final int MAX_INSTANCES_PER_CLASS = 200000;
    /** Reject PrimitiveArrayDump.getValues() above this length. */
    public static final int MAX_PRIMITIVE_ARRAY_FALLBACK = 65536;
    /** Max bytes copied from a primitive array (e.g. crypto keys). */
    public static final int MAX_BYTE_ARRAY = 1024 * 1024;
    public static final int MAX_TOSTRING_DEPTH = 8;
    public static final int MAX_SUPERCLASS_HOPS = 64;

    private SpiderLimits() {
    }
}
