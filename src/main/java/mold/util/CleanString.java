package mold.util;


public class CleanString {
    public static String cleanHaringInspectorCodesOfBadCharacters(String inspectorCode) {
        inspectorCode =
                inspectorCode
                        .toUpperCase()
                        .replaceAll("Å", "A")
                        .replaceAll("\\.", "")
                        .replaceAll("/", "")
                        .replaceAll(" ", "")
                        .trim();
        return inspectorCode;
    }
}
