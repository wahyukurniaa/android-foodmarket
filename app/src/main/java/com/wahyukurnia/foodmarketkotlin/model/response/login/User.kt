package com.wahyukurnia.foodmarketkotlin.model.response.login

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @Expose
    @SerializedName("address")
    val address: String,
    @Expose
    @SerializedName("city")
    val city: String,
    @Expose
    @SerializedName("created_at")
    val created_at: Int,
    @Expose
    @SerializedName("current_team_id")
    val current_team_id: Int,
    @Expose
    @SerializedName("email")
    val email: String,
    @Expose
    @SerializedName("email_verified_at")
    val email_verified_at: Any,
    @Expose
    @SerializedName("houseNumber")
    val houseNumber: String,
    @Expose
    @SerializedName("id")
    val id: Int,
    @Expose
    @SerializedName("name")
    val name: String,
    @Expose
    @SerializedName("phoneNumber")
    val phoneNumber: String,
    @Expose
    @SerializedName("profile_photo_path")
    val profile_photo_path: Any,
    @Expose
    @SerializedName("profile_photo_url")
    val profile_photo_url: String,
    @Expose
    @SerializedName("roles")
    val roles: String,
    @Expose
    @SerializedName("updated_at")
    val updated_at: Int
)