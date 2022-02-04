/*
     Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until
     there are no such sequences.
     After doing so, return the head of the final linked list.  You may return any such answer.

     Дан связанный список (односторонний), т.е. каждый элемент ссылается на следующий.
     Нужно удалить из списка ноды, сумма которых равна 0.
     После этого верните заголовок окончательного связанного списка.

    (Обратите внимание, что все последовательности в следующем примере представляют собой сериализацию объектов ListNode.)
    Пример 1：
    Вход: голова = [1,2,-3,3,1]
    Выход:[3,1]
    Быстрый ответ [1,2,1]  Это тоже правильно.

    Пример 2：
    Вход: голова = [1,2,3,-3,4]
    Выход:[1,2,4]

    Пример 3：
    Вход: голова = [1,2,3,-3,-2]
    Выход:[1]

    Подсказки:
    В предоставленном вам связанном списке могут быть 1  К 1000  Узлы.
    Для каждого узла в связанном списке значение узла:-1000 <= node.val <= 1000.
 */

import models.ListNode;

import java.util.HashMap;
import java.util.Random;

public class RemoveZeroSum {
    public static void main(String[] args) {

        /*
        ListNode n8 = new ListNode(-7);
        ListNode n7 = new ListNode(4,n8);
        ListNode n6 = new ListNode(3,n7);
        ListNode n5 = new ListNode(2,n6);
        ListNode n4 = new ListNode(-5,n5);
        ListNode n3 = new ListNode(4,n4);
        ListNode n2 = new ListNode(1, n3);
        ListNode n1 = new ListNode(7, n2);
         */

        ListNode head = new ListNode();
        ListNode zero = head;
        int count = 1;

        while ( head != null ) {
            head.setVal( new Random().nextInt(21) - 10 );
            if (count < 100) {
                head.setNext(new ListNode());
                System.out.println(count + " " + head.getVal() + " " + head.getNext() );
            }
            count++;
            head = head.getNext();
        }

        ListNode node = removeZeroSumSublists(zero);
        ListShow(node);

    }

    static public ListNode removeZeroSumSublists(ListNode head) {
        ListNode temp = new ListNode();
        temp.setNext(head);
        HashMap<Integer, ListNode> hashMap = new HashMap<>();
        int pSum = 0;
        hashMap.put(pSum, temp);

        while ( head != null ) {
            pSum += head.getVal();
            System.out.println(head.getVal() + " > " + pSum);
            if (hashMap.containsKey(pSum)) {
                // Удаляем вложения
                ListNode toRemove = hashMap.get(pSum).getNext();
                int sum = pSum;
                while (toRemove != head) {
                    sum += toRemove.getVal();
                    System.out.println(sum);
                    hashMap.remove(sum);
                    toRemove = toRemove.getNext();
                }
                //Обновляем ссылку после удаления
                hashMap.get(pSum).setNext( head.getNext() );

            }else{
                hashMap.put(pSum, head);
            }
            head = head.getNext();
        }
        System.out.println( hashMap );
        return temp.getNext();
    }

    public static void ListShow(ListNode head) {
        while (head != null) {
            System.out.print(" > " + head.getVal() );
            head = head.getNext();
        }
    }

}