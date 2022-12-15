package feupL15G01.model.menu;

import java.util.Arrays;
import java.util.List;

public class Win {
    private final List<String> entries;
    private int currentEntry = 0;

    public Win() {
        this.entries = Arrays.asList("Back to main menu", "Exit");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedBackToMainMenu() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}

