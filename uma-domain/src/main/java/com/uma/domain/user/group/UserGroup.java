package com.uma.domain.user.group;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.uma.domain.permission.Permission;
import com.uma.domain.user.User;

@Entity
@Table(name = "user_groups")
public class UserGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_groups_users", joinColumns = @JoinColumn(name = "user_group_id") , inverseJoinColumns = @JoinColumn(name = "user_id") )
	private Set<User> users;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_groups_permissions", joinColumns = @JoinColumn(name = "user_group_id") , inverseJoinColumns = @JoinColumn(name = "permission_id") )
	private Set<Permission> permissions;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
