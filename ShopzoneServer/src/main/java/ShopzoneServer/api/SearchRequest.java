package ShopzoneServer.api;

import java.io.Serializable;

public class SearchRequest implements Serializable {

	private static final long serialVersionUID = -8445943548965154778L;

	private String searchinput;

	public SearchRequest() {
		super();
	}

	public SearchRequest(String searchinput) {
		this.setSearchinput(searchinput);

	}

	public String getSearchinput() {
		return this.searchinput;
	}

	public void setSearchinput(String searchinput) {
		this.searchinput = searchinput;
	}


}
