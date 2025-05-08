package library;

import datastructures.lists.CustomLinkedList;

public class Member {
    private String memberId;
    private String name;
    private CustomLinkedList<Transaction> transactions ;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.transactions = new CustomLinkedList<>();
        // TODO: Initialize your data structure here
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction getLastTransaction() throws NoSuchFieldException {
        if (transactions.isEmpty()){
            return null ;
        }
        return transactions.getLast();
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
