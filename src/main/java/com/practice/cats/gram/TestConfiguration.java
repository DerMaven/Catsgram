package com.practice.cats.gram;

import com.practice.cats.gram.model.Post;
import com.practice.cats.gram.model.User;
import com.practice.cats.gram.service.PostService;
import com.practice.cats.gram.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class TestConfiguration {

    @Bean
    public CommandLineRunner initializeData(UserService userService, PostService postService) {
        return args -> {
            User u1 = new User("barsik_fan@mail.ru", "BarsikLover", LocalDate.of(1995, 5, 12));
            User u2 = new User("cat_lady99@gmail.com", "MeowQueen", LocalDate.of(1999, 11, 23));
            User u3 = new User("kot_v_sapogah@yandex.ru", "PussInBoots", LocalDate.of(1988, 2, 5));
            User u4 = new User("fluffy_tail@rambler.ru", "FluffyCloud", LocalDate.of(2001, 8, 14));
            User u5 = new User("purr_master@gmail.com", "PurrSonic", LocalDate.of(1993, 3, 30));
            User u6 = new User("whisker_king@mail.ru", "MrWhiskers", LocalDate.of(1990, 7, 19));
            User u7 = new User("murka_club@yandex.ru", "MurkaTheCat", LocalDate.of(1996, 12, 1));
            User u8 = new User("paws_and_claws@gmail.com", "TigerPaw", LocalDate.of(2004, 4, 25));
            User u9 = new User("catnip_dealer@mail.ru", "MintCat", LocalDate.of(1992, 10, 10));
            User u10 = new User("sleepy_kitten@rambler.ru", "SleepyHead", LocalDate.of(2000, 1, 15));
            User u11 = new User("ginger_boy@gmail.com", "RedGarfield", LocalDate.of(1997, 6, 8));
            User u12 = new User("black_cat_luck@yandex.ru", "LuckyNoir", LocalDate.of(1985, 9, 17));
            User u13 = new User("tail_wagger@mail.ru", "TailChaser", LocalDate.of(2003, 11, 3));
            User u14 = new User("meow_mix@gmail.com", "CatDJ", LocalDate.of(1994, 5, 29));
            User u15 = new User("fluffy_paws@yandex.ru", "SoftPaws", LocalDate.of(1991, 8, 22));
            User u16 = new User("cheshire_smile@mail.ru", "Cheshire", LocalDate.of(1989, 4, 1));
            User u17 = new User("hunting_cat@gmail.com", "HunterX", LocalDate.of(1998, 12, 12));
            User u18 = new User("couch_potato@rambler.ru", "LazyLoaf", LocalDate.of(2002, 7, 7));
            User u19 = new User("stray_friend@yandex.ru", "StreetCatAlly", LocalDate.of(1996, 3, 16));
            User u20 = new User("royal_kitty@gmail.com", "PrincessMeow", LocalDate.of(2005, 10, 5));

            userService.create(u1); userService.create(u2); userService.create(u3); userService.create(u4);
            userService.create(u5); userService.create(u6); userService.create(u7); userService.create(u8);
            userService.create(u9); userService.create(u10); userService.create(u11); userService.create(u12);
            userService.create(u13); userService.create(u14); userService.create(u15); userService.create(u16);
            userService.create(u17); userService.create(u18); userService.create(u19); userService.create(u20);

            postService.create(new Post(1L, "barsik_fan@mail.ru", "Мой Барсик опять занял мое кресло.", "https://catsgram.com/img/1.jpg"));
            postService.create(new Post(2L, "cat_lady99@gmail.com", "Утренние потягушки! Мы уже проснулись.", "https://catsgram.com/img/2.jpg"));
            postService.create(new Post(3L, "kot_v_sapogah@yandex.ru", "Купил коту новую коробку. Игнорирует дорогой домик.", "https://catsgram.com/img/3.jpg"));
            postService.create(new Post(4L, "fluffy_tail@rambler.ru", "Взгляд, полный осуждения, потому что миска видна наполовину.", "https://catsgram.com/img/4.jpg"));
            postService.create(new Post(5L, "purr_master@gmail.com", "Включил кошачье мурлыканье на колонке. Он в шоке.", "https://catsgram.com/img/5.jpg"));
            postService.create(new Post(6L, "whisker_king@mail.ru", "Поймал мышь! Ну, точнее, мой тапок.", "https://catsgram.com/img/6.jpg"));
            postService.create(new Post(7L, "murka_club@yandex.ru", "Настоящая леди греется на солнышке.", "https://catsgram.com/img/7.jpg"));
            postService.create(new Post(8L, "paws_and_claws@gmail.com", "Кусь за тыгыдык в три часа ночи.", "https://catsgram.com/img/8.jpg"));
            postService.create(new Post(9L, "catnip_dealer@mail.ru", "Мятные шарики — лучшее изобретение человечества.", "https://catsgram.com/img/9.jpg"));
            postService.create(new Post(10L, "sleepy_kitten@rambler.ru", "Спит без задних лап после тяжелого дня ничегонеделания.", "https://catsgram.com/img/10.jpg"));
            postService.create(new Post(11L, "ginger_boy@gmail.com", "Рыжие коты приносят удачу и требуют много еды.", "https://catsgram.com/img/11.jpg"));
            postService.create(new Post(12L, "black_cat_luck@yandex.ru", "Черные коты прекрасны, а суеверия — прошлый век.", "https://catsgram.com/img/12.jpg"));
            postService.create(new Post(13L, "tail_wagger@mail.ru", "Когда пытаешься поймать собственный хвост.", "https://catsgram.com/img/13.jpg"));
            postService.create(new Post(14L, "meow_mix@gmail.com", "Наш новый трек: громкое мяу в пустоту коридора.", "https://catsgram.com/img/14.jpg"));
            postService.create(new Post(15L, "fluffy_paws@yandex.ru", "Погладь кота. Кот плохой не посоветует.", "https://catsgram.com/img/15.jpg"));
            postService.create(new Post(16L, "cheshire_smile@mail.ru", "Улыбочку! Завтра выходные.", "https://catsgram.com/img/16.jpg"));
            postService.create(new Post(17L, "hunting_cat@gmail.com", "Выслеживаю муху. Операция 'Перехват'.", "https://catsgram.com/img/17.jpg"));
            postService.create(new Post(18L, "couch_potato@rambler.ru", "Идеальная форма кошачьего хлебушка.", "https://catsgram.com/img/18.jpg"));
            postService.create(new Post(19L, "stray_friend@yandex.ru", "Покормил уличного бродягу, теперь он живет на моем коврике.", "https://catsgram.com/img/19.jpg"));
            postService.create(new Post(20L, "royal_kitty@gmail.com", "Принцесса изволит кушать только паштет премиум-класса.", "https://catsgram.com/img/20.jpg"));

            int postsCount = postService.findAll(100, 0, "desc").size();

            System.out.println("=== Тестовые данные успешно загружены! Всего пользователей: "
                    + userService.findAll().size() + ", постов: " + postsCount + " ===");
        };
    }
}