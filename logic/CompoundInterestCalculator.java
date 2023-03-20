package logic;

public class CompoundInterestCalculator {
    public void execute() {
        System.out.println("----------------設定↓----------------");

        double initialInvestment = 500;
        System.out.printf("初期投資額：%.0f万円%n", initialInvestment);

        double annualInterestRate = 6;
        System.out.printf("年利率：%.1f%%%n", annualInterestRate);

        int investmentPeriod = 15;
        System.out.println("投資期間：" + investmentPeriod + "年");

        int reserveAmount = 140; // 月々の積立＋ボーナス
        System.out.println("積立額：" + reserveAmount + "万円/年");

//        double DividendIncreaseRate = 6;
//        System.out.printf("増配率：%.1f%%%n", annualInterestRate); // 全体には適用できないため工夫が必要

        System.out.println("----------------結果↓----------------");

        // 複利計算のための変数を初期化する
        double balance = initialInvestment;
        double interestEarned;
        int year;

        // 年数ごとの残高を計算する
        for (year = 1; year <= investmentPeriod; year++) {
            interestEarned = balance * annualInterestRate / 100;
            balance += interestEarned;
            balance += reserveAmount;
            System.out.printf("%d年目：%.0f万円%n", year, balance);
        }

        // 最終的な残高を表示する
        System.out.printf("投資期間が終了したときの残高は %.0f 万円です。%n", balance);
        double dividendYield = 3;
        System.out.printf("配当利回りを%.0f%%とすると、税引き前配当で%.0f万円受け取れます。%n", dividendYield, balance*(dividendYield/100));
    }
}
