package ru.sibek.carssier;

/**
 * Created by Developer on 22.04.2014.
 */
    public class ObjectDrawerItem {
        public int icon;
        public int[] icons;
        public String name;

        // Constructor.
        public ObjectDrawerItem(int icon, String name, int[] icons) {
            this.icon = icon;
            this.icons = icons;
            this.name = name;
        }
    }
