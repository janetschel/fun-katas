package diamond;

public class DiamondPrinter {
    public static void printDiamond(char in) {
        if ((int) in < 65 || (int) in > 90) {
            throw new IllegalArgumentException();
        }

        var result = new StringBuilder();

        for (int i = 65; i <= (int) in; i++) {
            result.append("%s\n".formatted(printRow(i, ((int) in) % 65)));
        }

        for (int i = (int) in - 1; i >= 65; i--) {
            result.append("%s\n".formatted(printRow(i, ((int) in) % 65)));
        }

        System.out.println(result);
    }

    private static String printRow(int in, int indent) {
        var row = new StringBuilder();
        var repeat = ".".repeat(Math.max(0, indent - (in % 65)));

        return row.append(repeat)
                .append(Character.toString(in))
                .append(".".repeat(Math.max(0, ((indent + 1 - row.length()) * 2) - 1)))
                .append(in == 65 ? "" : Character.toString(in))
                .append(repeat)
                .toString();
    }
}
