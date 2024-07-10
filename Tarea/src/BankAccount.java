import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BankAccount {
    private List<Transaction> transactions;

    public BankAccount() {
        transactions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // TODO 1: Implementar getTotalBalance utilizando streams y reduce
    public Optional<Double> getTotalBalance() {
        // TODO 1
        return transactions.stream()
                .map(transaction -> transaction.getAmount())
                .reduce((a,b) -> Double.sum(a,b));

    }

    // TODO 2: Implementar getDeposits utilizando streams y filter
    public Optional<List<Transaction>> getDeposits() {
        // TODO 2
        return Optional.of(transactions.stream()
                .filter(transaction -> transaction.getType().equals("deposit"))
                .collect(Collectors.toList()));
    }

    // TODO 3: Implementar getWithdrawals utilizando streams y filter
    public Optional<List<Transaction>> getWithdrawals() {
        // TODO 3
        return Optional.of(transactions.stream()
                .filter(transaction -> transaction.getType().equals("withdrawal"))
                .collect(Collectors.toList()));

    }

    // TODO 4: Implementar filterTransactions utilizando Function y streams
    public Optional<List<Transaction>> filterTransactions(Predicate<Transaction> predicate) {
        // TODO 4
        return Optional.of(transactions.stream()
                .filter(predicate)
                .collect(Collectors.toList()));
    }

    // TODO 5: Implementar getTotalDeposits utilizando getDeposits y mapToDouble
    public Optional<Double> getTotalDeposits() {
        // TODO 5
        return getDeposits()
                .map(deposits -> deposits.stream()
                .mapToDouble(Transaction::getAmount)
                .sum());
    }

    // TODO 6: Implementar getLargestWithdrawal utilizando getWithdrawals y max
    public Optional<Transaction> getLargestWithdrawal() {
        // TODO 6
        return getWithdrawals()
                .flatMap(withdrawals -> withdrawals.stream()
                .max(Comparator.comparingDouble(Transaction::getAmount)));
    }

    // TODO 7: Implementar getTransactionsOnDate utilizando streams y filter
    public Optional<List<Transaction>> getTransactionsOnDate(String date) {
        // TODO 7
        return Optional.of(transactions.stream()
                .filter(transaction -> transaction.getDate().equals(date))
                .collect(Collectors.toList()));

    }

    // TODO 8: Implementar getAverageTransactionAmount utilizando streams y mapToDouble
    public OptionalDouble getAverageTransactionAmount() {
        // TODO 8
        return transactions.stream()
                .mapToDouble(Transaction::getAmount)
                .average();

    }

    // TODO 9: Implementar getTransactionsWithAmountGreaterThan utilizando streams y filter
    public Optional<List<Transaction>> getTransactionsWithAmountGreaterThan(double amount) {
        // TODO 9
        return Optional.of(transactions.stream()
                .filter(transaction -> transaction.getAmount() > amount)
                .collect(Collectors.toList()));

    }

    // TODO 10: Implementar transfer utilizando addTransaction
    public static void transfer(BankAccount sourceAccount, BankAccount targetAccount, double amount) {
        // TODO 10
        sourceAccount.addTransaction(new Transaction(-amount, "withdrawal", "2024-05-13")); // Asume la fecha actual
        targetAccount.addTransaction(new Transaction(amount, "deposit", "2024-05-13"));

    }

    // TODO 11: Implementar getTotalWithdrawals utilizando getWithdrawals y mapToDouble
    public Optional<Double> getTotalWithdrawals() {
        // TODO 11
        return getWithdrawals()
                .map(withdrawals -> withdrawals.stream()
                .mapToDouble(Transaction::getAmount)
                .sum());

    }

    // TODO 12: Implementar getTransactionsSummary utilizando streams, map y collect
    public Map<String, Double> getTransactionsSummary() {
        // TODO 12
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType, Collectors.summingDouble(Transaction::getAmount)));
    }
}
