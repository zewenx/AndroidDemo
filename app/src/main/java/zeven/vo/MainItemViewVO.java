package zeven.vo;

/**
 * Created by zeven on 15/10/30.
 */
public class MainItemViewVO extends BaseVO{
    String name;
    String function;
    Class className;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public Class getClassName() {
        return className;
    }

    public void setClassName(Class className) {
        this.className = className;
    }
}
