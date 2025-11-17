#include <iostream>
#include "stack.h"
using namespace std;

int main() {
    Stack history;
    int pilihan;
    string url;

    while (true) {
        cout << "\nMenu Browser History:" << endl;
        cout << "1. Browse (Kunjungi Website)" << endl;
        cout << "2. Back (Kembali ke halaman sebelumnya)" << endl;
        cout << "3. View History" << endl;
        cout << "4. Exit" << endl;
        cout << "Pilih: ";
        cin >> pilihan;

        switch (pilihan) {
            case 1:
                cout << "Masukkan URL: ";
                cin >> url;
                history.push(url);
                cout << "Browsing: " << url << endl;
                break;

            case 2:
                if (history.isEmpty()) {
                    cout << "History kosong, tidak bisa kembali." << endl;
                } else {
                    cout << "Kembali dari: " << history.top() << endl;
                    history.pop();
                    if (!history.isEmpty())
                        cout << "Sekarang di: " << history.top() << endl;
                    else
                        cout << "Tidak ada history tersisa." << endl;
                }
                break;

            case 3:
                cout << "\n=== Browser History (Terbaru ke Terlama) ===" << endl;
                history.display();
                break;

            case 4:
                return 0;

            default:
                cout << "Pilihan tidak valid." << endl;
        }
    }

    return 0;
}
