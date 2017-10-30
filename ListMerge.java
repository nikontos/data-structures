public class ListMerge {

        private class Node {
            int item;   // integer item in {1..N}
            int size;   // set size if this node is representative
            Node next;  // next node in list
            Node rep;   // representative node, head of the list

            Node(int item) {
                this.item = item;
                this.size = 1;
                this.next = null;
                this.rep = this;
            }
        }

        private Node[] ItemNode; // provides access to list nodes
        private int N;           // number of items
        private int setCount;    // number of sets

        // make singleton set {v}
        Node makeSet(int v) {
            Node x = new Node(v);
            return x;
        }

        // initialize data structure
        public ListUnionFind(int N) {
            this.N = N;
            this.setCount = N;
            ItemNode =  new Node[N+1];     // array of references to list nodes
            for (int v = 1; v <= N; v++) {
                ItemNode[v] = makeSet(v);  // initialize N singleton sets
            }
        }

        int find(int v) {
            return ItemNode[v].rep.item;
        }

        Node findRep(int v){
            return this.ItemNode[v].rep;
        }

        /** This is the merge method
         *  It choses to traverse throught the smaller (size) list
         *  Makes each rep of the small list point to the head of the big list
         *  BigListHead.next points to small list Head
         *  Last node of the SmallList.next should point to the BigListHead.next ( original )
         * @param v a node of a list, or a single node
         * @param u same as above.
         */
        void unite(int v, int u) {
            //if (find(v) == find(u)) return;
            Node p = findRep(v);
            Node q = findRep(u);
            Node bigListHead;
            Node current;
            if (q == p )    return ;

            if (p.size <= q.size){      // chose the shortest list to traverse
                bigListHead = q;
                current = p;
            }
            else{
                bigListHead = p;
                current = q;
            }

            while(current.next != null){
                if (current.rep == bigListHead) return;
                current.rep = bigListHead;
                current = current.next; // used to traverse the list
            }
            bigListHead.size =+ current.size;
            current.size = 1;
            current.next = bigListHead.next;
            bigListHead.next = current;
        }
}
