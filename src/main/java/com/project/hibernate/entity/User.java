package com.project.hibernate.entity;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
//

//@XmlRootElement
////@NamedQueries({
////
//      @NamedQuery(name = "User.findAll", query = "SELECT s FROM user s")})

@Data
@Entity
@Indexed
@Table(name = "user")
@NamedQueries({
        @NamedQuery(
                name = "findByEmail",
                query = "from User u where u.email = :email"
        )
//        @NamedQuery(
//                name = "findByEmailAndPassword",
//                query = "from User u where u.email= :email and u.password = :password"
//        ),
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "User.getFollowed",resultClass = User.class, query = "SELECT * FROM user LEFT JOIN relationship on relationship.follower = :id WHERE relationship.followed = user.id"),
        @NamedNativeQuery(name = "User.findByIdIs", query = "SELECT DISTINCT photo.uploader_Id, user.name, photo.date_updated,photo.caption, photo.id FROM user,relationship,photo WHERE relationship.follower = :id AND (uploader_id = user.id AND (user.id = relationship.followed) AND (path <> '' OR path iS NOT NULL)) OR (uploader_id = :id AND uploader_id = user.id) ORDER BY photo.date_updated DESC"),
        @NamedNativeQuery(name = "User.getFollower", resultClass = User.class, query = "SELECT * FROM user LEFT JOIN relationship on relationship.followed = :id WHERE relationship.follower = user.id\n"),
        @NamedNativeQuery(name = "User.getPostsCount", query="SELECT COUNT(id) FROM photo WHERE uploader_id = :id"),
        @NamedNativeQuery(name = "User.isFollowingId", resultClass = Relationship.class, query = "SELECT DISTINCT * FROM relationship WHERE follower = :id AND followed = :profileid"),
        @NamedNativeQuery(name = "User.removeRelationship", query = "DELETE FROM relationship WHERE follower = :id AND followed = :profileid"),
        @NamedNativeQuery(name = "User.findUserByNameLike", query = "SELECT id,name FROM user WHERE name LIKE :keyword") // find user by name

})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int userId;


    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_name")
    private String userName;

    @Column
    @Field
    private String firstName;

    @Column
    private String lastName;


    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    @Transient
    @JsonIgnore
    private String password;

    @Column(name="email", nullable=false,unique = true)
    @Field(store = Store.NO)
    @Email(message = "*Please provide a valid e-mail address.")
    private String email;

//    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;

    @Temporal(TemporalType.DATE)
    @Column
    private Date date_of_birth;


    public Date dateRegistered;

    public String description;

    public String website;


//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user_id",fetch = FetchType.LAZY)
//    private List<Contact> contact;


// PROJECT
//    @ManyToMany(mappedBy = "members")
//    private Set<Project> projects = new HashSet<>();
//
    // role
    @ManyToMany(fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(
            name="user_role",
            joinColumns = { @JoinColumn(name="user_id")},
            inverseJoinColumns = { @JoinColumn(name="role_id")}
    )
    private List<Role> roles;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Contact contact;

//
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="department_id")
//    @JsonBackReference
//    private Department department;


    // UPDATE USER ENTITY WITH MEETUPS ENTITY RELATIONSHIP
    // MEET UP ORGANISED
    @OneToMany
    @JoinColumn(name = "organizer_user_id")
    private List<Meetup> meetupsOrganized = new ArrayList<>();

    // MEETUP ATTENDING
    @ManyToMany(mappedBy = "attendees")
    private List<Meetup> meetupsAttending = new ArrayList<>();

    // project review
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<ProjectReview> projectReviews;

    // address

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    // Photo
//    @OneToMany(mappedBy = "user")
//    private List<Photo> photos;

    @OneToMany(mappedBy = "uploader")
    @JsonManagedReference
    private List<Photo> photos;


    // post
    @OneToMany(mappedBy = "user")
    @JsonBackReference
    private List<Post> posts;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id")
    private Position position;

    // task table
    @ManyToMany(mappedBy = "users")
    private List<Task> tasks;

    @OneToMany(mappedBy = "follower")
    @JsonManagedReference
    private Collection<Relationship> following;

    // add bookings
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Booking> bookings;






}