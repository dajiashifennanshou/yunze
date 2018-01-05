package cn.gl.lib.impl;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import cn.gl.lib.utils.BaseUtils;

public class TextWatcherBkgVariable implements TextWatcher {
	private EditText content;
	private boolean filterCn, bkgVariable;
	private int count, start;

	public TextWatcherBkgVariable(EditText content) {
		this(content, false, true);
	}

	public TextWatcherBkgVariable(EditText content, boolean filterCn) {
		this(content, filterCn, false);
	}
	
	public TextWatcherBkgVariable(EditText content, boolean filterCn, boolean bkgVariable) {
		this.content = content;
		this.filterCn = filterCn;
		this.bkgVariable = bkgVariable;
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		int len = s.length();
		BaseUtils.logh("", "afterTextChanged len: " + len + "  " + s.toString() + " isCN(s.toString()): " + isCN(s.toString()));
		if(filterCn && !isCN(s.toString())) {
			s.replace(start, start + count, "");
			return ;
		}
		if(!bkgVariable) {
			return ;
		}
		if(0 != len) {
			if(!content.isSelected()) {
				content.setSelected(true);
			}
		} else {
			if(content.isSelected()) {
				content.setSelected(false);
			}
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		BaseUtils.logh("", "beforeTextChanged s: " + s + " start: " + start + " count: " + count + " after: " + after);
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		BaseUtils.logh("", "onTextChanged s: " + s + " filterCn: " + filterCn + " count: " + count + " start: " + start + " before: " + before);
		if(filterCn) {
			this.count = count;
			this.start = start; 
		}
	}
	
	private boolean isCN(String str){
		char[] cs = str.toCharArray();
		for(char c : cs) {
			Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
			if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
					|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
					|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
					|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
				continue;
			} else {
				return false;
			}
			
		}
		// 过滤中文标点符号
		String[] symbl = new String[] {"。", "，", "、", "；", "：", "？", "！",
				"……", "…", "“", "”", "\"", "——", "《", "》", "（", "）", "[", "]", "{", "}"};
		for(String s : symbl) {
			if(str.contains(s)) {
				return false;
			}
		}
		return true;

    }
}
