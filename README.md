# Horror Countdown (Forge 1.16.5)

Sau 72000 tick (~3 ngày Minecraft) kể từ lúc thế giới được tạo, mod sẽ:
- Gửi dòng chữ đỏ đậm "YOU ARE NO LONGER SAFE" tới mọi người chơi
- Phát âm thanh `horror_sting` (file gốc do bạn cung cấp) cho mọi người chơi

## Build tự động qua GitHub Actions
1. Tạo repo GitHub mới, đẩy toàn bộ nội dung thư mục này lên (root repo phải chứa `build.gradle` trực tiếp).
2. Vào tab **Actions** trên GitHub → workflow "Build Mod" sẽ tự chạy.
3. Khi chạy xong (khoảng 3-6 phút), vào workflow run → phần **Artifacts** → tải `horrormod-jar` về.
4. Giải nén, lấy file `.jar` bên trong.

## Cài vào PojavLauncher
1. Trong PojavLauncher, cài phiên bản Minecraft 1.16.5 kèm Forge 36.2.39 (qua mục Version/Install).
2. Copy file `.jar` vừa build vào thư mục `.minecraft/mods/`.
3. Tạo world mới và chờ (hoặc dùng lệnh `/time set` để test nhanh, đổi COUNTDOWN_TICKS trong code nếu muốn test ngắn hơn).
