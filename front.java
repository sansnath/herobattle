package herobattle;

import java.util.*;

public class front {
    public static void main(String[] args) {
        Random random = new Random();
        back attacker;
        back defender;
        double hpAttacker, hpDefender, health, attack, defence, health2, attack2, defence2;
        String hero, name2;
        String winner = "";
        int jumlahRonde = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Permainan adu hero");
        System.out.println(
                "Player 1 masukkan info hero anda \n" + "Untuk bagian angka isi bilangan dari angka 50 - 3000");
        System.out.println("=================");
        System.out.print("Masukkan nama hero\t: ");
        hero = input.nextLine();
        do {
            System.out.println("Nama hero anda \t\t: " + hero + "\n");
            System.out.print("Masukkan health point\t: ");
            health = input.nextDouble();
            System.out.print("Masukkan attack\t\t: ");
            attack = input.nextDouble();
            System.out.print("Masukkan defence\t: ");
            defence = input.nextDouble();

            if (health > 3000 || health < 50 || attack > 3000 || attack < 50 || defence > 3000 || defence < 50) {
                System.out.println("\nMasukkan angka sesuai ketentuan \n");
            }
        } while (health > 3000 || health < 50 || attack > 3000 || attack < 50 || defence > 3000 || defence < 50);
        back hero1 = new back();
        hero1.setNama(hero);
        hero1.setHp(health);
        hero1.setAttack(attack);
        hero1.setDefence(defence);
        input.nextLine();
        System.out.println(
                "\nPlayer 2 masukkan info hero anda \n" + "Untuk bagian angka isi bilangan dari angka 0 - 500");
        System.out.println("=================");
        System.out.print("Masukkan nama hero\t: ");
        name2 = input.nextLine();
        do {
            System.out.println("Nama hero anda \t\t: " + name2 + "\n");
            System.out.print("Masukkan health point\t: ");
            health2 = input.nextDouble();
            System.out.print("Masukkan attack\t\t: ");
            attack2 = input.nextDouble();
            System.out.print("Masukkan defence\t: ");
            defence2 = input.nextDouble();
            if (health2 > 3000 || health2 < 50 || attack2 > 3000 || attack2 < 50 || defence2 > 3000 || defence2 < 50) {
                System.out.println("\nMasukkan angka sesuai ketentuan \n");
            }
        } while (health2 > 3000 || health2 < 50 || attack2 > 3000 || attack2 < 50 || defence2 > 3000 || defence2 < 50);
        back hero2 = new back(name2, health2, attack2, defence2);
        System.out.println("\nYang menyerang pertama adalah.... ");
        int firstAttacker = random.nextInt(2);
        if (firstAttacker == 0) {
            attacker = hero1;
            defender = hero2;
            System.out.println(hero1.getName() + " menyerang pertama kali!");
        } else {
            attacker = hero2;
            defender = hero1;
            System.out.println(hero2.getName() + " menyerang pertama kali!");
        }
        do {
            jumlahRonde += 1;
            hpDefender = defender.getHp() - (attacker.getAttack() - defender.getDefence());
            if (attacker.getAttack() < defender.getDefence()) {
                hpDefender = defender.getHp();
            }
            if (hpDefender < 0) {
                hpDefender = 0;
            }
            defender.setHp(hpDefender);
            System.out.println("==========================================================");
            System.out.println("Ronde " + jumlahRonde);
            System.out.println(attacker.getName() + " Menyerang " + defender.getName());
            System.out.println(attacker.getName() + " Menyerang dengan kekuatan sebesar " + attacker.getAttack());
            System.out.println(defender.getName() + " Memiliki shield sebesar " + defender.getDefence());
            System.out.println("Health dari " + defender.getName() + " tersisa " + hpDefender);
            System.out.println("==========================================================");

            if (defender.getHp() <= 0) {
                winner = attacker.getName();
                break;
            }

            hpAttacker = attacker.getHp() - (defender.getAttack() - attacker.getDefence());
            if (defender.getAttack() < attacker.getDefence()) {
                hpAttacker = attacker.getHp();
            }
            attacker.setHp(hpAttacker);
            if (hpAttacker < 0) {
                hpAttacker = 0;
            }

            System.out.println(defender.getName() + " Menyerang " + attacker.getName());
            System.out.println(defender.getName() + " Menyerang dengan kekuatan sebesar " + defender.getAttack());
            System.out.println(attacker.getName() + " Memiliki shield sebesar " + attacker.getDefence());
            System.out.println("Health dari " + attacker.getName() + " tersisa " + hpAttacker);
            System.out.println("==========================================================");
            if (attacker.getHp() <= 0) {
                winner = defender.getName();
                break;
            }

            if (attacker.getAttack() < defender.getDefence() && defender.getAttack() < attacker.getDefence()) {
                winner = "tidak ada karena dua-duanya tidak mempunyai kekuatan untuk menembus shield lawan";
                break;
            }

        } while (attacker.getHp() > 0 && defender.getHp() > 0);
        System.out.println("Pemenangnya adalah " + winner);
        input.close();
    }
}
