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
        super.onCreated(item);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void onRenamed(Item item, String oldName, String newName) {
        super.onRenamed(item, oldName, newName);    //To change body of overridden methods use File | Settings | File Templates.
    }

    @Override
    public void onDeleted(Item item) {
        super.onDeleted(item);    //To change body of overridden methods use File | Settings | File Templates.
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
