package homeschooltracker.content;

import homeschooltracker.content.taskState.*;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Task {
    public String name;
    public ArrayList<Task> taskArrayList = new ArrayList<>();

    State isNotPreparedState = new IsNotPreparedState(this);
    State currentToPrepareState = new CurrentToPrepareState(this);
    State isPreparedState = new IsPreparedState(this);
    State currentLessonState = new CurrentLessonState(this);
    State isCompletedState = new IsCompletedState(this);
    State isGradedState = new IsGradedState(this);

    State state;

    public void add(Task task) {
        if(taskArrayList.size() == 0) {
            task.setState(currentToPrepareState);
        }
        taskArrayList.add(task);
    }

    public void remove(Task task) {
        throw new UnsupportedOperationException();
    }

    public Task getChild(int position) {
        if(taskArrayList.size() == 0) {
            throw new UnsupportedOperationException();
        }
        return taskArrayList.get(position);
    }

    public String getName() {
        return name;
    }

    void setState(State state) {
        this.state = state;
        setChildrenState(state);
    }

    void setChildrenState(State state) {
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            task.setState(state);
        }
    }

    public boolean isPrepared() {
        return state.isPrepared();
    }

    public Task getCurrentTask() {
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if(task.isCurrent()) {
                return task;
            }
        }
        return null;
    }

    public void setReadyToPrepare() {
        setState(currentToPrepareState);
    };

    public void setPrepared() {
        System.out.println("  setPrepared()!");
        if(getCurrentTask() == null) {
            setState(currentLessonState);
        } else {
            setState(isPreparedState);
        }
    }

    public void setChildPrepared(int position) {
        throw new UnsupportedOperationException();
    }

    public boolean isCurrent() {
        return state.isCurrent();
    }

    public boolean isCompleted() {
        return state.isCompleted();
    }

    public void setCompleted() {
        setState(isCompletedState);
    }

    public boolean isGraded() {
        return state.isGraded();
    }

    public void setGraded() {
        setState(isGradedState);
    }

    public String getStateDescription() {
        return state.getStateDescription();
    }

    public boolean showInParentList() {
        return state.showInParentList();
    };

    public boolean showInStudentList() {
        return state.showInStudentList();
    }

    public String toString() {
        String prepared = " ";
        String completed = " ";
        String graded = " ";
        if (isPrepared()) {
            prepared = "X";
        }
        if (isCompleted()) {
            completed = "X";
        }
        if (isGraded()) {
            graded = "X";
        }
        return ("  [" + prepared + "][" + completed + "][" + graded + "] " + getName());
    }

    public void print() {
        System.out.println(this.toString());
    }

    void printTasks(ArrayList<Task> taskArrayList) {
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            try {
                System.out.println(task.toString());
                task.printParentTasks();
            }
            catch(Exception e) {
                System.out.println("  --> There are no tasks! " + e);
            }
        }
    }

    public void printParentTasks() {
        printTasks(getParentTaskArrayList());
    }

    public void printStudentTasks() {
        printTasks(getStudentTaskArrayList());
    }


    public ArrayList<Task> getTaskArrayList() {
        return taskArrayList;
    }

    public ArrayList<Task> getTasks(ArrayList<Task> taskArrayList) {
        ArrayList<Task> taskList = new ArrayList<>();
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            taskList.add(task);
            taskList.addAll(getTasks(task.getTaskArrayList()));
        }
        return taskList;
    }

    public ArrayList<Task> getParentTasks() {
        return getTasks(getParentTaskArrayList());
    }

    public ArrayList<Task> getParentTaskArrayList() {
        ArrayList<Task> parentTaskArrayList = new ArrayList<>();
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if(task.showInParentList()) {
                parentTaskArrayList.add(task);
            }
        }
        return parentTaskArrayList;
    }

    public ArrayList<Task> getStudentTaskArrayList() {
        ArrayList<Task> studentTaskArrayList = new ArrayList<>();
        Iterator<Task> iterator = taskArrayList.iterator();
        while (iterator.hasNext()) {
            Task task = iterator.next();
            if(task.showInStudentList()) {
                studentTaskArrayList.add(task);
            }
        }
        return studentTaskArrayList;
    }
}
