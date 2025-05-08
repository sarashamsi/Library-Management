package management;

import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private CustomHashMap<String , Member> members ;

    public MemberManager() {
        this.members = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        members.put(member.getMemberId() , member);
    }

    public Member getMember(String memberId) {
        return members.get(memberId) ;
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        Member member = members.get(memberId);
        if (member != null){
            member.addTransaction(transaction);
        }
    }

    public Transaction getLastTransaction(String memberId) throws NoSuchFieldException {
        Member member = members.get(memberId);
        if (member != null){
            return member.getLastTransaction();
        } else {
            return null;
        }
    }
}
