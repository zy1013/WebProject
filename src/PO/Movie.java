package PO;

public class Movie {
	int mid;
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getNumber_likes() {
		return number_likes;
	}
	public void setNumber_likes(String number_likes) {
		this.number_likes = number_likes;
	}
	String title;//标题  
	String director; //导演
	String actor1name;//1
	String actor2name;//2
	String actor3name;//3
	String genre;//分类
	String tag;//标签
	String gross;//票房
	String link;//链接
	String duration;//时长
	String language;//语言
	String rank;//分级
	String budget;//成本
	String year;//时间
	String score;//评分
	String ratio;//比例?
	String number_likes;//
	public String getTitle() {
		String temp = title;
		temp=title.replace("Â", "");
		return temp;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor1name() {
		return actor1name;
	}
	public void setActor1name(String actor1name) {
		this.actor1name = actor1name;
	}
	public String getActor2name() {
		return actor2name;
	}
	public void setActor2name(String actor2name) {
		this.actor2name = actor2name;
	}
	public String getActor3name() {
		return actor3name;
	}
	public void setActor3name(String actor3name) {
		this.actor3name = actor3name;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getGross() {
		return gross;
	}
	public void setGross(String gross) {
		this.gross = gross;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getRatio() {
		return ratio;
	}
	public void setRatio(String ratio) {
		this.ratio = ratio;
	}

}
