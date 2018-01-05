package cn.gl.lib.utils;

import java.io.File;
import java.util.Comparator;

public class FileModifySortComparator implements Comparator<File>{
    @Override
    public int compare(File f0, File f1) {
		if (f0.lastModified() > f1.lastModified()) {
			return 1;
		} else if (f0.lastModified() == f1.lastModified()) {
			return 0;
		} else {
			return -1;
		}
    }
}
