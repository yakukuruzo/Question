package com.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import static com.example.UberInterview2019Questions.*;

public class UberInterview2019QuestionsTest {

    @Test
    public void testIsValidSudoku() {

        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }

    @Test
    public void testFlattenIterator() {
        List<Character> list1 = Arrays.asList('5', '3', '.', '.', '7', '.', '.', '.', '.');
        List<Character> list2 = Arrays.asList('6', '.', '.', '1', '9', '5', '.', '.', '.');
        List<Character> list3 = Arrays.asList('.', '9', '8', '.', '.', '.', '.', '6', '.');

        FlatteningIterator<Character> flatteningIterator
                = new FlatteningIterator<>(Arrays.asList(list1, list2, list3));

        while(flatteningIterator.hasNext()) {
            System.out.print(flatteningIterator.next() + ",");
        }
    }

    @Test
    public void testNumberAwareStringComparator() {
        List<String> values = Arrays.asList("dazzle2", "dazzle10", "dazzle1", "dazzle2.7", "dazzle2.10", "2", "10", "1", "EctoMorph6", "EctoMorph62", "EctoMorph7");
        System.out.println(values.stream().sorted(new NumberAwareStringComparator()).collect(Collectors.joining(" ")));

        System.out.println(values.stream().sorted(new AlphanumComparator()).collect(Collectors.joining(" ")));

    }

    @Test
    public void testLRUCache() {
        LRUCache<Integer, String> lruCache = new LRUCache<>(5);

        lruCache.add(1, "First");
        lruCache.add(2, "Second");
        lruCache.add(3, "Third");
        lruCache.add(4, "Fourth");
        lruCache.add(5, "Fifth");
        lruCache.add(6, "Sixth");
        lruCache.add(7, "Seventh");
        lruCache.add(4, "Fourth");
        lruCache.get(3);
    }

    @Test
    public void testSerDeserTree() {
        /* Serialize and deserialize a general tree
*                         A
                       /  |   \
*                    B    C     D
                    / \        / | \ \
*                  E   F      I  G  H  J
*                  |
*                  K
     */

        TreeSerDeser.Node node0 = new TreeSerDeser.Node('A');
        TreeSerDeser.Node node1 = new TreeSerDeser.Node('B');
        TreeSerDeser.Node node2 = new TreeSerDeser.Node('C');
        TreeSerDeser.Node node3 = new TreeSerDeser.Node('D');
        TreeSerDeser.Node node4 = new TreeSerDeser.Node('E');
        TreeSerDeser.Node node5 = new TreeSerDeser.Node('F');
        TreeSerDeser.Node node6 = new TreeSerDeser.Node('G');
        TreeSerDeser.Node node7 = new TreeSerDeser.Node('H');
        TreeSerDeser.Node node8 = new TreeSerDeser.Node('I');
        TreeSerDeser.Node node9 = new TreeSerDeser.Node('J');
        TreeSerDeser.Node node10 = new TreeSerDeser.Node('K');
        node0.children.addAll(Arrays.asList(node1, node2, node3));
        node1.children.addAll(Arrays.asList(node4, node5));
        node3.children.addAll(Arrays.asList(node6, node7, node8, node9));
        node4.children.add(node10);

        String result = TreeSerDeser.serializeTree(node0);
        System.out.println(result);
        TreeSerDeser.Node root = TreeSerDeser.deserializeTree(result);
        System.out.println(TreeSerDeser.serializeTree(root));

        StringBuffer sb = new StringBuffer();
        TreeSerDeser.serializeTreeRecursively(node0, sb);
        System.out.println(sb.toString());

        TreeSerDeser.Counter counter = new TreeSerDeser.Counter();
        root = TreeSerDeser.deserializeTreeRecursively(sb.toString(), counter);
        sb = new StringBuffer();
        TreeSerDeser.serializeTreeRecursively(root, sb);
        System.out.println(sb.toString());
    }

    @Test
    public void testSerDeserBinaryTree() {
        TreeNode node0 = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        node0.left = node1; node0.right = node2; node2.left = node3; node2.right = node4;
        String result = Codec.serialize(node0);
        System.out.println(result);

        TreeNode root = Codec.deserialize(result);
        result = Codec.serialize(root);
        System.out.println(result);

    }

    @Test
    public void testFrequencySorter() {

        int[] array = { 4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5 };
        // 2 2 2 2 1 1 3 3 4 4 5 6 7

        System.out.println(sortByFrequencies(array));
    }

    @Test
    public void testKthSmallest() {
        int arr[] = new int[]{12, 3, 5, 7, 4, 19, 26, 1, 0, 2, 6};
        int k = 5;
        System.out.print( "K'th smallest element is " +
                kthSmallest(arr, 0, arr.length - 1, k) );
    }

    @Test
    public void testGetKMostFrequentLogs() {

        List<String> result = getKMostFrequentLogs(
                new String[] {"yahoo", "google", "facebook", "amazon", "cnn", "twitch", "uber", "yahoo", "google", "yahoo",
                        "yahoo","yahoo","yahoo","yahoo","yahoo", "amazon","amazon","amazon","amazon", "microsoft",
                        "microsoft","microsoft","microsoft","microsoft","microsoft", "facebook","facebook","facebook", "facebook","facebook"}, 5);
        System.out.println(result);
    }
}