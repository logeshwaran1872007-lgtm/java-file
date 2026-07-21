Public class throne inheritance
import java.util.*;

class ThroneInheritance {
    // Map to establish the family tree: Parent Name -> List of Children Names
    private Map<String, List<String>> familyTree;
    // Set to keep track of dead family members
    private Set<String> deadSet;
    private String king;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.deadSet = new HashSet<>();
        // Initialize the king's entry in the family tree
        this.familyTree.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        familyTree.putIfAbsent(parentName, new ArrayList<>());
        familyTree.get(parentName).add(childName);
        familyTree.putIfAbsent(childName, new ArrayList<>());
    }

    public void death(String name) {
        deadSet.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String currentPerson, List<String> order) {
        if (!deadSet.contains(currentPerson)) {
            order.add(currentPerson);
        }
        
        // Traverse through all children in chronological order
        List<String> children = familyTree.get(currentPerson);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_4 = obj.getInheritanceOrder();
 */