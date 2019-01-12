package TeamWorkProject;

import java.util.List;

public class Team {

    private String name ;
    private List<String> members ;
    private String creatorName ;

    public Team(String name, List<String> members, String creatorName) {

        this.name = name;
        this.members = members;
        this.creatorName = creatorName;
    }

    public String getName() {
        return name;
    }

    public List<String> getMembers() {
        return members;
    }

    public String getCreatorName() {
        return creatorName;
    }

}
