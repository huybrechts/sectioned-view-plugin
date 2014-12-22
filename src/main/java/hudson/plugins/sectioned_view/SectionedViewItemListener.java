package hudson.plugins.sectioned_view;

import hudson.model.Hudson;
import hudson.model.Item;
import hudson.model.View;
import hudson.Extension;
import hudson.model.listeners.ItemListener;

@Extension
public class SectionedViewItemListener extends ItemListener {

    @Override
    public void onCreated(Item item) {
        clearCaches();
    }

    @Override
    public void onRenamed(Item item, String oldName, String newName) {
        clearCaches();
    }

    @Override
    public void onDeleted(Item item) {
        clearCaches();
    }

    private void clearCaches() {
        for (View view: Hudson.getInstance().getViews()) {
            if (view instanceof SectionedView) {
                for (SectionedViewSection section: ((SectionedView) view).getSections()) {
                    section.clearCache();
                }

            }
        }
    }

}
