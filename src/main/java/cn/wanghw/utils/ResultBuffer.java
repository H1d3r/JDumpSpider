package cn.wanghw.utils;

/**
 * String builder that stops growing after {@link SpiderLimits#MAX_RESULT_CHARS}.
 */
public class ResultBuffer {
    private final StringBuilder sb = new StringBuilder();
    private boolean truncated;

    public boolean append(String text) {
        if (truncated) {
            return false;
        }
        if (text == null || text.length() == 0) {
            return true;
        }
        if (sb.length() >= SpiderLimits.MAX_RESULT_CHARS) {
            markTruncated();
            return false;
        }
        int room = SpiderLimits.MAX_RESULT_CHARS - sb.length();
        if (text.length() > room) {
            sb.append(text.substring(0, room));
            markTruncated();
            return false;
        }
        sb.append(text);
        return true;
    }

    private void markTruncated() {
        if (!truncated) {
            sb.append("\r\n... truncated\r\n");
            truncated = true;
        }
    }

    public boolean hasRoom() {
        return !truncated;
    }

    public boolean isEmpty() {
        return sb.length() == 0;
    }

    public String toString() {
        return sb.toString();
    }
}
