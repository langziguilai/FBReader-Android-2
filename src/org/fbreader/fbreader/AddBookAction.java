package org.fbreader.fbreader;

import org.fbreader.description.BookDescription;
import org.zlibrary.core.dialogs.ZLDialogManager;

class AddBookAction extends FBAction {
	AddBookAction(FBReader fbreader) {
		super(fbreader);
	}

	public boolean isVisible() {
		return fbreader().getMode() != FBReader.ViewMode.FOOTNOTE;
	}

	public void run() {
		FBFileHandler handler = new FBFileHandler();
		if (ZLDialogManager.getInstance().runSelectionDialog("addFileDialog", handler)) {
			BookDescription description = handler.description();
			if (description != null) {
				fbreader().openBook(description);
		//		fbreader().setMode(FBReader.ViewMode.BOOK_TEXT);
				fbreader().refreshWindow();
			}
		}
		/*
		FBFileHandler handler;
		if (ZLDialogManager::instance().selectionDialog(ZLResourceKey("addFileDialog"), handler)) {
			BookDescriptionPtr description = handler.description();
			if (!description.isNull() && fbreader().runBookInfoDialog(description->fileName())) {
				BookList().addFileName(description->fileName());
				fbreader().setMode(FBReader::BOOK_TEXT_MODE);
			}
		}
		*/
	}
}
