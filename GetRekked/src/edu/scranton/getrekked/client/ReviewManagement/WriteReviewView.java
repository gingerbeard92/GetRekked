package edu.scranton.getrekked.client.ReviewManagement;

import java.lang.Integer;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;

import edu.scranton.getrekked.shared.BookReview;
import edu.scranton.getrekked.shared.GameReview;
import edu.scranton.getrekked.shared.MovieReview;


public class WriteReviewView implements WriteReviewPresenter.View{
	private DecoratorPanel mainPanel = null;
	private WriteReviewPresenter dispatcher;
	private FlexTable reviewTable = new FlexTable();
	private TextBox reviewBox;
	private TextBox rankingBox;
	private BookReview bookReview;
	private MovieReview movieReview;
	private GameReview gameReview;
	
	public WriteReviewView(WriteReviewPresenter presenter){
		  this.dispatcher = presenter;
	      mainPanel = new DecoratorPanel();
	      HorizontalPanel menuPanel = new HorizontalPanel();
	      Button reviewButton = new Button("Save");
	      Button cancelButton = new Button("Cancel");
	      menuPanel.add(reviewButton);
	      menuPanel.add(cancelButton);
	      reviewButton.addClickHandler(new ReviewButtonClickHandler());
	      cancelButton.addClickHandler(new ClickHandler() {
	         public void onClick(ClickEvent event) {
	            dispatcher.cancelOperation();
	         }
	      });
	      
	      reviewTable = new FlexTable();
	      reviewBox = new TextBox();
	      reviewBox.setVisibleLength(250);
	      rankingBox = new TextBox();
	      if(bookReview != null){
	    	  reviewTable.setWidget(0, 0, new Label("Review for ISBN: "+bookReview.getIsbn()));
	      }
	      else if(movieReview != null){
	    	  reviewTable.setWidget(0, 0, new Label("Review for "+movieReview.getTitle()+" ("+movieReview.getRelease_date()+")"));
	      }
	      else{ //gameReview != null
	    	  reviewTable.setWidget(0, 0, new Label("Review for Barcode: "+gameReview.getBarcode()));
	      }  
	      reviewTable.setWidget(1, 0, new Label("Write review: "));
	      reviewTable.setWidget(1, 1, reviewBox);
	      reviewTable.setWidget(2, 0, new Label("Rank (0-5): "));
	      reviewTable.setWidget(2, 1, rankingBox);
	}
	
	public void display() {
	      resetInputBoxes();
	      RootPanel.get().clear();
	      RootPanel.get().add(mainPanel);
	}
	
	private void resetInputBoxes() {
	      reviewBox.setText("");   
	}
	
	public void setPresenter(WriteReviewPresenter presenter) {
	      this.dispatcher = presenter;
	}
	
	public void setBookData(BookReview review){
		bookReview = review;
	}
	
	public void setMovieData(MovieReview review){
		movieReview = review;
	}
	
	public void setGameData(GameReview review){
		gameReview = review;
	}
	private class ReviewButtonClickHandler implements ClickHandler {
	      public void onClick(ClickEvent event) {
	         String review = reviewBox.getText();
	         String ranking = rankingBox.getText();
	         dispatcher.writeReview(review, Integer.getInteger(ranking));
	      }
	}
}