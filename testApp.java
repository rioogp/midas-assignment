import java.util.Stack;

public class testApp {
    public static void main(String[] args) {
        System.out.println(isValid("()"));       // true
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("(]"));       // false
        System.out.println(isValid("([])"));     // true
    }

    // Metode untuk memvalidasi string input yang memiliki urutan tanda kurung yang benar menggunakan Stack dari Java
    public static boolean isValid(String input) {
        Stack<Character> stack = new Stack<>(); // Membuat stack untuk menyimpan karakter

        // Iterasi setiap karakter dalam string
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i); // Mengambil karakter saat ini

            // Jika karakter adalah tanda kurung buka, masukkan ke dalam stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Jika karakter adalah tanda kurung tutup, periksa kecocokan dengan tanda kurung buka di stack
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false; // Tidak ada pasangan tanda kurung buka, maka tidak valid
                }
                char top = stack.peek(); // Periksa elemen teratas tanpa menghapusnya
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false; // Pasangan tidak cocok, maka tidak valid
                }
                stack.pop(); // Hapus elemen teratas setelah validasi berhasil
            }
        }
        // Jika stack kosong, berarti semua tanda kurung sudah cocok
        return stack.isEmpty();
    }
}
