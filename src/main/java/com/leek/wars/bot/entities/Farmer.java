package com.leek.wars.bot.entities;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Farmer {

	private Long id;
	private String login;
	private Team team;
	private String name;
	private Integer talent;
	private Map<Long, Leek> leeks;
	@JsonProperty("avatar_changed")
	private Integer avatarChanged;
	@JsonProperty("talent_more")
	private Integer talentMore;
	private Integer victories;
	private Integer draws;
	private Integer defeats;
	private BigDecimal ratio;
	private Boolean connected;
	@JsonProperty("last_connection")
	private Long lastConnection;
	@JsonProperty("register_date")
	private Long registerDate;
	@JsonProperty("fight_history")
	private List<Fight> fightHistory;
	private List<TournamentHistoryItem> tournaments;
	private Boolean admin;
	private Boolean moderator;
	private String country;
	private Farmer godfather;
	private List<Farmer> godsons;
	private String color;
	private Integer banned;
	@JsonProperty("won_solo_tournaments")
	private Integer wonSoloTournaments;
	@JsonProperty("won_farmer_tournaments")
	private Integer wonFarmerTournaments;
	@JsonProperty("won_team_tournaments")
	private Integer wonTeamTournaments;
	@JsonProperty("total_level")
	private Integer totalLevel;
	@JsonProperty("leek_count")
	private Integer leekCount;
	@JsonProperty("in_garden")
	private Integer inGarden;
	private Integer fights;
	//TODO github
	@JsonIgnore
	private Object github;
	//TODO website
	@JsonIgnore
	private Object website;
	@JsonProperty("forum_messages")
	private Integer forumMessages;
	@JsonProperty("didactitiel_seen")
	private Integer didactitielSeen;
	private Boolean contributor;
	private Integer trophies;
	private Long habs;
	private Long crystals;
	private List<Weapon> weapons;
	private List<Chip> chips;
	private List<AI> ais;
	private List<Potion> potions;
	private List<Hat> hats;
	private Tournament tournament;
	//TODO candidacy
	@JsonIgnore
	private Object candidacy;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getTalent() {
		return talent;
	}
	public void setTalent(Integer talent) {
		this.talent = talent;
	}
	public Map<Long, Leek> getLeeks() {
		return leeks;
	}
	public void setLeeks(Map<Long, Leek> leeks) {
		this.leeks = leeks;
	}
	public Integer getAvatarChanged() {
		return avatarChanged;
	}
	public void setAvatarChanged(Integer avatarChanged) {
		this.avatarChanged = avatarChanged;
	}
	public Object getGithub() {
		return github;
	}
	public void setGithub(Object github) {
		this.github = github;
	}
	public Object getWebsite() {
		return website;
	}
	public void setWebsite(Object website) {
		this.website = website;
	}
	public Integer getTalentMore() {
		return talentMore;
	}
	public void setTalentMore(Integer talentMore) {
		this.talentMore = talentMore;
	}
	public Integer getVictories() {
		return victories;
	}
	public void setVictories(Integer victories) {
		this.victories = victories;
	}
	public Integer getDraws() {
		return draws;
	}
	public void setDraws(Integer draws) {
		this.draws = draws;
	}
	public Object getCandidacy() {
		return candidacy;
	}
	public void setCandidacy(Object candidacy) {
		this.candidacy = candidacy;
	}
	public Integer getDefeats() {
		return defeats;
	}
	public void setDefeats(Integer defeats) {
		this.defeats = defeats;
	}
	public BigDecimal getRatio() {
		return ratio;
	}
	public void setRatio(BigDecimal ratio) {
		this.ratio = ratio;
	}
	public Boolean getConnected() {
		return connected;
	}
	public void setConnected(Boolean connected) {
		this.connected = connected;
	}
	public Long getLastConnection() {
		return lastConnection;
	}
	public void setLastConnection(Long lastConnection) {
		this.lastConnection = lastConnection;
	}
	public Long getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Long registerDate) {
		this.registerDate = registerDate;
	}
	public List<Fight> getFightHistory() {
		return fightHistory;
	}
	public void setFightHistory(List<Fight> fightHistory) {
		this.fightHistory = fightHistory;
	}
	public List<TournamentHistoryItem> getTournaments() {
		return tournaments;
	}
	public void setTournaments(List<TournamentHistoryItem> tournaments) {
		this.tournaments = tournaments;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public Boolean getModerator() {
		return moderator;
	}
	public void setModerator(Boolean moderator) {
		this.moderator = moderator;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Farmer getGodfather() {
		return godfather;
	}
	public void setGodfather(Farmer godfather) {
		this.godfather = godfather;
	}
	public List<Farmer> getGodsons() {
		return godsons;
	}
	public void setGodsons(List<Farmer> godsons) {
		this.godsons = godsons;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getBanned() {
		return banned;
	}
	public void setBanned(Integer banned) {
		this.banned = banned;
	}
	public Integer getWonSoloTournaments() {
		return wonSoloTournaments;
	}
	public void setWonSoloTournaments(Integer wonSoloTournaments) {
		this.wonSoloTournaments = wonSoloTournaments;
	}
	public Integer getWonFarmerTournaments() {
		return wonFarmerTournaments;
	}
	public void setWonFarmerTournaments(Integer wonFarmerTournaments) {
		this.wonFarmerTournaments = wonFarmerTournaments;
	}
	public Integer getWonTeamTournaments() {
		return wonTeamTournaments;
	}
	public void setWonTeamTournaments(Integer wonTeamTournaments) {
		this.wonTeamTournaments = wonTeamTournaments;
	}
	public Integer getTotalLevel() {
		return totalLevel;
	}
	public void setTotalLevel(Integer totalLevel) {
		this.totalLevel = totalLevel;
	}
	public Integer getLeekCount() {
		return leekCount;
	}
	public void setLeekCount(Integer leekCount) {
		this.leekCount = leekCount;
	}
	public Integer getInGarden() {
		return inGarden;
	}
	public void setInGarden(Integer inGarden) {
		this.inGarden = inGarden;
	}
	public Integer getFights() {
		return fights;
	}
	public void setFights(Integer fights) {
		this.fights = fights;
	}
	public Integer getForumMessages() {
		return forumMessages;
	}
	public void setForumMessages(Integer forumMessages) {
		this.forumMessages = forumMessages;
	}
	public Integer getDidactitielSeen() {
		return didactitielSeen;
	}
	public void setDidactitielSeen(Integer didactitielSeen) {
		this.didactitielSeen = didactitielSeen;
	}
	public Boolean getContributor() {
		return contributor;
	}
	public void setContributor(Boolean contributor) {
		this.contributor = contributor;
	}
	public Integer getTrophies() {
		return trophies;
	}
	public void setTrophies(Integer trophies) {
		this.trophies = trophies;
	}
	public Long getHabs() {
		return habs;
	}
	public void setHabs(Long habs) {
		this.habs = habs;
	}
	public Long getCrystals() {
		return crystals;
	}
	public void setCrystals(Long crystals) {
		this.crystals = crystals;
	}
	public List<Weapon> getWeapons() {
		return weapons;
	}
	public void setWeapons(List<Weapon> weapons) {
		this.weapons = weapons;
	}
	public List<Chip> getChips() {
		return chips;
	}
	public void setChips(List<Chip> chips) {
		this.chips = chips;
	}
	public List<AI> getAis() {
		return ais;
	}
	public void setAis(List<AI> ais) {
		this.ais = ais;
	}
	public List<Potion> getPotions() {
		return potions;
	}
	public void setPotions(List<Potion> potions) {
		this.potions = potions;
	}
	public List<Hat> getHats() {
		return hats;
	}
	public void setHats(List<Hat> hats) {
		this.hats = hats;
	}
	public Tournament getTournament() {
		return tournament;
	}
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
	
	@Override
	public String toString() {
		return "Farmer [id=" + id + ", login=" + login + ", team=" + team + ", name=" + name + ", talent=" + talent
				+ ", leeks=" + leeks + ", avatarChanged=" + avatarChanged + ", talentMore=" + talentMore
				+ ", victories=" + victories + ", draws=" + draws + ", defeats=" + defeats + ", ratio=" + ratio
				+ ", connected=" + connected + ", lastConnection=" + lastConnection + ", registerDate=" + registerDate
				+ ", fightHistory=" + fightHistory + ", tournaments=" + tournaments + ", admin=" + admin
				+ ", moderator=" + moderator + ", country=" + country + ", godfather=" + godfather + ", godsons="
				+ godsons + ", color=" + color + ", banned=" + banned + ", wonSoloTournaments=" + wonSoloTournaments
				+ ", wonFarmerTournaments=" + wonFarmerTournaments + ", wonTeamTournaments=" + wonTeamTournaments
				+ ", totalLevel=" + totalLevel + ", leekCount=" + leekCount + ", inGarden=" + inGarden + ", fights="
				+ fights + ", github=" + github + ", website=" + website + ", forumMessages=" + forumMessages
				+ ", didactitielSeen=" + didactitielSeen + ", contributor=" + contributor + ", trophies=" + trophies
				+ ", habs=" + habs + ", crystals=" + crystals + ", weapons=" + weapons + ", chips=" + chips + ", ais="
				+ ais + ", potions=" + potions + ", hats=" + hats + ", tournament=" + tournament + ", candidacy="
				+ candidacy + "]";
	}
}
