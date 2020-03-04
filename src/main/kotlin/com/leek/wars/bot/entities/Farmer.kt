package com.leek.wars.bot.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

class Farmer {
    var id: Long? = null
    var login: String? = null
    var team: Team? = null
    var name: String? = null
    var talent: Int? = null
    var leeks: Map<Long, Leek>? = null
    @JsonProperty("avatar_changed")
    var avatarChanged: Int? = null
    @JsonProperty("talent_more")
    var talentMore: Int? = null
    var victories: Int? = null
    var draws: Int? = null
    var defeats: Int? = null
    var ratio: BigDecimal? = null
    var connected: Boolean? = null
    @JsonProperty("last_connection")
    var lastConnection: Long? = null
    @JsonProperty("register_date")
    var registerDate: Long? = null
    @JsonProperty("fight_history")
    var fightHistory: List<Fight>? = null
    var tournaments: List<TournamentHistoryItem>? = null
    var admin: Boolean? = null
    var moderator: Boolean? = null
    var country: String? = null
    var godfather: Farmer? = null
    var godsons: List<Farmer>? = null
    var color: String? = null
    var banned: Int? = null
    @JsonProperty("won_solo_tournaments")
    var wonSoloTournaments: Int? = null
    @JsonProperty("won_farmer_tournaments")
    var wonFarmerTournaments: Int? = null
    @JsonProperty("won_team_tournaments")
    var wonTeamTournaments: Int? = null
    @JsonProperty("total_level")
    var totalLevel: Int? = null
    @JsonProperty("leek_count")
    var leekCount: Int? = null
    @JsonProperty("in_garden")
    var inGarden: Int? = null
    var fights: Int? = null
    @JsonIgnore
    var github: Any? = null
    @JsonIgnore
    var website: Any? = null
    @JsonProperty("forum_messages")
    var forumMessages: Int? = null
    @JsonProperty("didactitiel_seen")
    var didactitielSeen: Int? = null
    var contributor: Boolean? = null
    var trophies: Int? = null
    var habs: Long? = null
    var crystals: Long? = null
    var weapons: List<Weapon>? = null
    var chips: List<Chip>? = null
    var ais: List<AI>? = null
    var potions: List<Potion>? = null
    var hats: List<Hat>? = null
    var tournament: Tournament? = null
    @JsonIgnore
    var candidacy: Any? = null

}