import java.util.Stack;
import java.util.Scanner;

public class BrowserHistory {
    private Stack<String> history = new Stack<>();

    public void browse(String url) {
        history.push(url);
        System.out.println("Browsing: " + url);
    }

    public void back() {
        if (history.isEmpty()) {
            System.out.println("History kosong. Tidak bisa kembali.");
            return;
        }

        String removed = history.pop();
        System.out.println("Kembali dari: " + removed);

        if (!history.isEmpty()) {
            System.out.println("Sekarang berada di: " + history.peek());
        } else {
            System.out.println("Tidak ada history tersisa.");
        }
    }

    public void view() {
        if (history.isEmpty()) {
            System.out.println("History kosong.");
            return;
        }

        System.out.println("\n=== Browser History (Terbaru ke Terlama) ===");
        for (int i = history.size() - 1; i >= 0; i--) {
            System.out.println(history.get(i));
        }
        System.out.println("===========================================\n");
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Browse");
            System.out.println("2. Back");
            System.out.println("3. View History");
            System.out.println("4. Exit");
            System.out.print("Pilih: ");

            int pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan URL: ");
                    String url = input.nextLine();
                    browser.browse(url);
                    break;

                case 2:
                    browser.back();
                    break;

                case 3:
                    browser.view();
                    break;

                case 4:
                    System.out.println("Program selesai.");
                    return;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
