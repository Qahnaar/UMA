package com.uma.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user_groups")
public class UserGroup {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_group_id")
	private Set<User> users;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_group_id")
	private Set<Permission> permissions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
}
