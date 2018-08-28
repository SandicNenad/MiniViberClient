package com.comtrade.view.admin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.communication.Communication;
import com.comtrade.comparator.MyComparatorGroups;
import com.comtrade.comparator.MyComparatorUser;
import com.comtrade.constant.Constant;
import com.comtrade.controllerclient.ControllerClient;
import com.comtrade.domain.GroupMembers;
import com.comtrade.domain.Groups;
import com.comtrade.domain.ListGroupEntry;
import com.comtrade.domain.ListGroupEntryRenderer;
import com.comtrade.domain.ListUsersEntry;
import com.comtrade.domain.ListUsersEntryRenderer;
import com.comtrade.domain.SendingFile;
import com.comtrade.domain.User;
import com.comtrade.thread.ThreadReqProccFromServer;
import com.comtrade.transfer.TransferClass;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AdminForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ThreadReqProccFromServer trps = new ThreadReqProccFromServer();
	private JPanel contentPane;
	private JPanel panelPeople;
	private JPanel panelPeople_Info;
	private JPanel panelGroups;
	private JPanel panelGroupInfo;
	private JPanel panelPeople_Info_ProfilePicture;
	private JLayeredPane layeredPane;

	private JList<Object> listPeople_ListOfUsers;
	private JList<Object> listGroups_ListOfGroups;
	private JList<Object> listGroups_Info_GroupMembers;

	private JScrollPane spPeople_ListOfUsers;
	private JScrollPane spGroups_ListOfGroups;
	private JScrollPane spPeople_Info_AboutMe;
	private JScrollPane spGroups_Info_About;
	private JScrollPane spGroups_Info_GroupMembers;

	private JLabel lblPeople_Info_Username;
	private JLabel lblPeople_Info_DateOfRegistration;
	private JLabel lblPeople_Info_LastNameFirstName;
	private JLabel lblPeople_Info_DateOfBirthMini;
	private JLabel lblPeople_Info_TownCountry;
	private JLabel lblPeople_Info_WorkPlace;
	private JLabel lblPeople_Info_Education;
	private JLabel lblPeople_Info_Gender;
	private JLabel lblPeople_Info_ProfilePicture;
	private JLabel lblGroups_Info_GroupName;
	private JLabel lblGroups_Info_CreatedBy;
	private JLabel lblGroups_Info_DateOfCreation;
	private JLabel lblPeople_Info_Email;
	private JLabel lblGroups_Info_GroupPicture;

	private JTextArea taPeople_Info_AboutMe;
	private JTextArea taGroups_Info_About;

	private JButton btnPeople;
	private JButton btnGroups;

	private Map<Integer, User> allUsersHM = new HashMap<>();
	private List<Integer> listOfActiveUsers = new ArrayList<>();
	private List<User> listOfAllUsers = new ArrayList<>();
	private List<Groups> listOfAllGroups = new ArrayList<>();
	private List<GroupMembers> listOfAllGroupMembers = new ArrayList<>();
	private List<SendingFile> listOfNewProfilePictures = new ArrayList<>();
	private List<SendingFile> listOfNewGroupPictures = new ArrayList<>();

	private Groups selectedGroup;

	private User selectedUser;
	private User currentUser;
	

	@SuppressWarnings({ "unchecked" })
	public AdminForm(Map<String, Object> hm) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int x = JOptionPane.showConfirmDialog(null, "You are quitting the miniViber \n Are you sure?", "Quit?",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (x == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		setBounds(10, 10, 1100, 700);
		setTitle("You are currently signed in as admin");
		allUsersHM = (Map<Integer, User>) hm.get(Constant.ALL_USERS_HM);
		listOfActiveUsers = (List<Integer>) hm.get(Constant.ACTIVE_USERS);
		listOfAllGroups = (List<Groups>) hm.get(Constant.ALL_GROUPS_LIST);
		listOfAllGroupMembers = (List<GroupMembers>) hm.get(Constant.ALL_GROUPMEMBERS_LIST);
		listOfNewProfilePictures = (List<SendingFile>) hm.get(Constant.ALL_NEW_PICTURES_LIST);
		listOfNewGroupPictures = (List<SendingFile>) hm.get(Constant.ALL_NEW_GROUP_PICTURES);
		currentUser = (User) hm.get(Constant.CURRENT_USER);

		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnPeople = new JButton("People");
		btnPeople.setIcon(new ImageIcon("icons/offline-icon.png"));
		btnPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buttonPressed(btnPeople.getText());
			}

		});
		btnPeople.setBounds(338, 90, 162, 36);
		contentPane.add(btnPeople);

		btnGroups = new JButton("Groups");
		btnGroups.setIcon(new ImageIcon("icons/GroupRequest.png"));
		btnGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPressed(btnGroups.getText());
			}
		});
		btnGroups.setBounds(600, 90, 162, 36);
		contentPane.add(btnGroups);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 132, 1064, 529);
		contentPane.add(layeredPane);

		panelPeople = new JPanel();
		panelPeople.setBackground(Color.WHITE);
		panelPeople.setBounds(10, 11, 1044, 509);
		layeredPane.add(panelPeople);
		panelPeople.setLayout(null);

		spPeople_ListOfUsers = new JScrollPane();
		spPeople_ListOfUsers.setBounds(10, 11, 207, 484);
		panelPeople.add(spPeople_ListOfUsers);

		listPeople_ListOfUsers = new JList<Object>();
		listPeople_ListOfUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (listPeople_ListOfUsers.getSelectedValue() != null) {
					ListUsersEntry lue = (ListUsersEntry) listPeople_ListOfUsers.getSelectedValue();
					selectedUser = lue.getUser();
					viewProfile();
					panelPeople_Info.setVisible(true);
				}
			}
		});
		spPeople_ListOfUsers.setViewportView(listPeople_ListOfUsers);

		panelPeople_Info = new JPanel();
		panelPeople_Info.setBackground(Color.WHITE);
		panelPeople_Info.setBounds(239, 11, 764, 484);
		panelPeople.add(panelPeople_Info);
		panelPeople_Info.setLayout(null);

		panelPeople_Info_ProfilePicture = new JPanel();
		panelPeople_Info_ProfilePicture.setBackground(new Color(240, 240, 240));
		panelPeople_Info_ProfilePicture.setBounds(10, 11, 304, 227);
		panelPeople_Info.add(panelPeople_Info_ProfilePicture);
		panelPeople_Info_ProfilePicture.setLayout(null);

		lblPeople_Info_ProfilePicture = new JLabel("New label");
		lblPeople_Info_ProfilePicture.setBounds(6, 6, 292, 215);
		panelPeople_Info_ProfilePicture.add(lblPeople_Info_ProfilePicture);
		panelPeople_Info.setLayout(null);

		lblPeople_Info_Username = new JLabel("<dynamic>'s profile");
		lblPeople_Info_Username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_Info_Username.setBounds(355, 22, 304, 28);
		panelPeople_Info.add(lblPeople_Info_Username);

		lblPeople_Info_DateOfRegistration = new JLabel("Registered since <dynamic>");
		lblPeople_Info_DateOfRegistration.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_Info_DateOfRegistration.setBounds(10, 280, 263, 28);
		panelPeople_Info.add(lblPeople_Info_DateOfRegistration);

		lblPeople_Info_LastNameFirstName = new JLabel("<dynamic> <dynamic>");
		lblPeople_Info_LastNameFirstName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_Info_LastNameFirstName.setBounds(355, 70, 263, 21);
		panelPeople_Info.add(lblPeople_Info_LastNameFirstName);

		lblPeople_Info_DateOfBirthMini = new JLabel("Date of birth : <dynamic>");
		lblPeople_Info_DateOfBirthMini.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_Info_DateOfBirthMini.setBounds(355, 117, 263, 21);
		panelPeople_Info.add(lblPeople_Info_DateOfBirthMini);

		lblPeople_Info_TownCountry = new JLabel("Curently in <dynamic>, <dynamic>");
		lblPeople_Info_TownCountry.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_Info_TownCountry.setBounds(355, 217, 263, 21);
		panelPeople_Info.add(lblPeople_Info_TownCountry);

		lblPeople_Info_WorkPlace = new JLabel("Workplace <dynamic>");
		lblPeople_Info_WorkPlace.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_Info_WorkPlace.setBounds(10, 383, 263, 21);
		panelPeople_Info.add(lblPeople_Info_WorkPlace);

		lblPeople_Info_Education = new JLabel("Education <dynamic>");
		lblPeople_Info_Education.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_Info_Education.setBounds(10, 427, 263, 21);
		panelPeople_Info.add(lblPeople_Info_Education);

		lblPeople_Info_Gender = new JLabel("Gender <dynamic>");
		lblPeople_Info_Gender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_Info_Gender.setBounds(355, 167, 263, 21);
		panelPeople_Info.add(lblPeople_Info_Gender);

		spPeople_Info_AboutMe = new JScrollPane();
		spPeople_Info_AboutMe.setBounds(297, 316, 304, 132);
		panelPeople_Info.add(spPeople_Info_AboutMe);

		taPeople_Info_AboutMe = new JTextArea();
		taPeople_Info_AboutMe.setEditable(false);
		taPeople_Info_AboutMe.setWrapStyleWord(true);
		taPeople_Info_AboutMe.setLineWrap(true);
		spPeople_Info_AboutMe.setViewportView(taPeople_Info_AboutMe);

		lblPeople_Info_Email = new JLabel("Workplace <dynamic>");
		lblPeople_Info_Email.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_Info_Email.setBounds(10, 332, 263, 21);
		panelPeople_Info.add(lblPeople_Info_Email);

		panelGroups = new JPanel();
		panelGroups.setBackground(Color.WHITE);
		panelGroups.setBounds(10, 11, 1044, 509);
		layeredPane.add(panelGroups);
		panelGroups.setLayout(null);

		spGroups_ListOfGroups = new JScrollPane();
		spGroups_ListOfGroups.setBounds(10, 11, 207, 484);
		panelGroups.add(spGroups_ListOfGroups);

		listGroups_ListOfGroups = new JList<Object>();
		listGroups_ListOfGroups.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (listGroups_ListOfGroups.getSelectedValue() != null) {
					ListGroupEntry lge = (ListGroupEntry) listGroups_ListOfGroups.getSelectedValue();
					selectedGroup = lge.getGroup();
					viewGroupInfo();
					panelGroupInfo.setVisible(true);
				}
			}
		});
		spGroups_ListOfGroups.setViewportView(listGroups_ListOfGroups);

		panelGroupInfo = new JPanel();
		panelGroupInfo.setBackground(Color.WHITE);
		panelGroupInfo.setBounds(239, 11, 765, 484);
		panelGroups.add(panelGroupInfo);
		panelGroupInfo.setLayout(null);

		lblGroups_Info_GroupName = new JLabel("New label");
		lblGroups_Info_GroupName.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroups_Info_GroupName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblGroups_Info_GroupName.setBounds(281, 38, 462, 35);
		panelGroupInfo.add(lblGroups_Info_GroupName);

		JLabel lblGroups_Info_Info = new JLabel("Group info:");
		lblGroups_Info_Info.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblGroups_Info_Info.setBounds(63, 200, 203, 22);
		panelGroupInfo.add(lblGroups_Info_Info);

		JLabel lblGroups_Info_Members = new JLabel("Group members");
		lblGroups_Info_Members.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblGroups_Info_Members.setBounds(493, 169, 203, 22);
		panelGroupInfo.add(lblGroups_Info_Members);

		lblGroups_Info_CreatedBy = new JLabel("New label");
		lblGroups_Info_CreatedBy.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroups_Info_CreatedBy.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblGroups_Info_CreatedBy.setBounds(281, 95, 462, 35);
		panelGroupInfo.add(lblGroups_Info_CreatedBy);

		lblGroups_Info_DateOfCreation = new JLabel("Group info");
		lblGroups_Info_DateOfCreation.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblGroups_Info_DateOfCreation.setBounds(64, 233, 327, 22);
		panelGroupInfo.add(lblGroups_Info_DateOfCreation);

		spGroups_Info_About = new JScrollPane();
		spGroups_Info_About.setBounds(63, 299, 203, 174);
		panelGroupInfo.add(spGroups_Info_About);

		taGroups_Info_About = new JTextArea();
		taGroups_Info_About.setEditable(false);
		taGroups_Info_About.setWrapStyleWord(true);
		taGroups_Info_About.setLineWrap(true);
		spGroups_Info_About.setViewportView(taGroups_Info_About);

		spGroups_Info_GroupMembers = new JScrollPane();
		spGroups_Info_GroupMembers.setBounds(495, 220, 201, 253);
		panelGroupInfo.add(spGroups_Info_GroupMembers);

		listGroups_Info_GroupMembers = new JList<Object>();
		spGroups_Info_GroupMembers.setViewportView(listGroups_Info_GroupMembers);

		JLabel lblGroups_Info_About = new JLabel("This group is about:");
		lblGroups_Info_About.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblGroups_Info_About.setBounds(63, 266, 203, 22);
		panelGroupInfo.add(lblGroups_Info_About);
		
		lblGroups_Info_GroupPicture = new JLabel("New label");
		lblGroups_Info_GroupPicture.setBounds(63, 11, 203, 180);
		panelGroupInfo.add(lblGroups_Info_GroupPicture);

		JLabel lblNewLabel = new JLabel("WELCOME, YOU ARE SIGNED AS ADMINISTRATOR OF miniVIBER\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(80, 11, 933, 54);
		contentPane.add(lblNewLabel);

		fillListOfAllUsers();
		fillPeoplePanelList();
		fillGroupPanelList();
		panelPeople_Info.setVisible(false);
		panelGroupInfo.setVisible(false);
		panelPeople.setVisible(false);
		panelGroups.setVisible(false);
		trps.start();
		ControllerClient.getInstance().setAdminForm(this);
		checkIsThereNewProfilePictures();
		checkIsThereNewGroupPictures();
	}

	private void checkIsThereNewGroupPictures() {
		if (listOfNewGroupPictures == null) {
		} else {
			File dir = new File(Constant.GROUP_PICTURE + currentUser.getUsername());
			if (!dir.exists()) {
				dir.mkdir();
			}
			for (SendingFile tempFile : listOfNewGroupPictures) {
				File newFile = new File(
						Constant.GROUP_PICTURE + currentUser.getUsername() + "/" + tempFile.getFileName());
				try {
					Files.write(newFile.toPath(), tempFile.getPicture(), StandardOpenOption.CREATE);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void checkIsThereNewProfilePictures() {
		if (listOfNewProfilePictures == null) {
		} else {
			File dir = new File(Constant.PROFILE_PICTURE + currentUser.getUsername());
			if (!dir.exists()) {
				dir.mkdir();
			}
			for (SendingFile tempFile : listOfNewProfilePictures) {
				File newFile = new File(
						Constant.PROFILE_PICTURE + currentUser.getUsername() + "/" + tempFile.getFileName());
				try {
					Files.write(newFile.toPath(), tempFile.getPicture(), StandardOpenOption.CREATE);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			viewProfile();
		}
	}

	private void fillGroupPanelList() {
		Collections.sort(listOfAllGroups, new MyComparatorGroups());
		DefaultListModel<Object> dlm = new DefaultListModel<>();
		for (Groups temp : listOfAllGroups) {
//			ListGroupEntry lge = new ListGroupEntry(temp, "groupView");
			String path;
			if (temp.getGroupPictureURL().contains(temp.getGroupName())) {
				path=Constant.GROUP_PICTURE+currentUser.getUsername()+"/"+temp.getGroupPictureURL();
			}else {
				path= Constant.ICON_GROUP_DEFAULT;
			}
			ListGroupEntry lge = new ListGroupEntry(temp,path);
			dlm.addElement(lge);
		}
		listGroups_ListOfGroups.setModel(dlm);
		listGroups_ListOfGroups.setCellRenderer(new ListGroupEntryRenderer());
	}

	private void viewGroupInfo() {
		if (selectedGroup != null) {
			String text = "Group name: " + selectedGroup.getGroupName();
			lblGroups_Info_GroupName.setText(text);
			text = "Created by: " + allUsersHM.get(selectedGroup.getGroupCreatorId()).getLastName() + " "
					+ allUsersHM.get(selectedGroup.getGroupCreatorId()).getFirstName();
			lblGroups_Info_CreatedBy.setText(text);
			text = "Group created: " + convertStringIntoDateAndPutInLabel(selectedGroup.getDateOfCreation());
			lblGroups_Info_DateOfCreation.setText(text);
			taGroups_Info_About.setText(selectedGroup.getGroupInfo());
			if (selectedGroup.getGroupPictureURL().contains(selectedGroup.getGroupName())) {
				File f = new File(Constant.GROUP_PICTURE+currentUser.getUsername()+"/"+selectedGroup.getGroupPictureURL());
				if (f.exists()) {
					putImageInLabel(Constant.GROUP_PICTURE+currentUser.getUsername()+"/"+selectedGroup.getGroupPictureURL(), lblGroups_Info_GroupPicture);
				} else {
					TransferClass tcAskForGroupPicture = new TransferClass();
					tcAskForGroupPicture.setClientObject(selectedGroup.getGroupPictureURL());
					tcAskForGroupPicture.setOperation(Constant.ASK_FOR_GROUP_PICTURE);
					Communication.getInstance().sendData(tcAskForGroupPicture);
				}
			}else {
				putImageInLabel(Constant.ICON_GROUP_DEFAULT, lblGroups_Info_GroupPicture);
			}
			
			int iAdmin = 0;
			int iMember = 0;
			DefaultListModel<Object> dlm = new DefaultListModel<>();
			for (GroupMembers temp : listOfAllGroupMembers) {
				if (temp.getGroupName().equals(selectedGroup.getGroupName())) {
					String status = temp.getTypeOfMember();
					if (status.equals("admin")) {
						ListUsersEntry lue = new ListUsersEntry(allUsersHM.get(temp.getIdUser()), Constant.ICON_USER_GROUP_ADMIN);
						dlm.insertElementAt(lue, iAdmin++);
					} else if (status.equals("member")) {
						ListUsersEntry lue = new ListUsersEntry(allUsersHM.get(temp.getIdUser()), Constant.ICON_USER_GROUP_MEMBER);
						dlm.insertElementAt(lue, (iAdmin + iMember++));
					} else {
						ListUsersEntry lue = new ListUsersEntry(allUsersHM.get(temp.getIdUser()), Constant.ICON_USER_GROUP_SENT_REQUEST);
						dlm.addElement(lue);
					}
				}
			}
			listGroups_Info_GroupMembers.setModel(dlm);
			listGroups_Info_GroupMembers.setCellRenderer(new ListUsersEntryRenderer());
		}
	}

	private void fillListOfAllUsers() {
		listOfAllUsers = new ArrayList<>();
		for (Entry<Integer, User> temp : allUsersHM.entrySet()) {
			User u = temp.getValue();
			listOfAllUsers.add(u);
		}
		Collections.sort(listOfAllUsers, new MyComparatorUser());

	}

	private void fillPeoplePanelList() {
		int positionOfOnlineUser = 0;
		DefaultListModel<Object> dlm = new DefaultListModel<>();

		for (User tempUser : listOfAllUsers) {
			if (!tempUser.getTypeOfUser().equals("admin")) {
				String status = "offline";
				if (listOfActiveUsers.contains(tempUser.getIdUser())) {
					status = "online";
				}
				ListUsersEntry usersEntry = new ListUsersEntry(tempUser, status);
				if (status.equals("online")) {
					dlm.insertElementAt(usersEntry, positionOfOnlineUser++);
				} else {
					dlm.addElement(usersEntry);
				}
			}
		}
		listPeople_ListOfUsers.setModel(dlm);
		listPeople_ListOfUsers.setCellRenderer(new ListUsersEntryRenderer());
	}

	private void putImageInLabel(String path, JLabel label) {
		ImageIcon img = new ImageIcon(path);
		Image image = img.getImage();
		Image newImg = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(newImg));
	}

	private void viewProfile() {
		if (selectedUser != null) {
			if (listOfActiveUsers.contains(selectedUser.getIdUser())) {
				panelPeople_Info_ProfilePicture.setBackground(new Color(0, 255, 0));
			} else {
				panelPeople_Info_ProfilePicture.setBackground(new Color(240, 240, 240));
			}

			if (selectedUser.getProfilePictureURL().contains(selectedUser.getUsername())) {
				File f = new File(Constant.PROFILE_PICTURE + currentUser.getUsername() + "/"
						+ selectedUser.getProfilePictureURL());
				if (f.exists()) {
					putImageInLabel(f.getPath(), lblPeople_Info_ProfilePicture);
				} else {
					TransferClass tcAskForPicture = new TransferClass();
					tcAskForPicture.setOperation(Constant.ASK_FOR_FRIEND_PROFILE_PICTURE);
					tcAskForPicture.setClientObject(selectedUser.getProfilePictureURL());
					Communication.getInstance().sendData(tcAskForPicture);
				}
			} else {
				if (selectedUser.getGender().equalsIgnoreCase("female")) {
					putImageInLabel(Constant.PROFILE_PICTURE + "female.jpg", lblPeople_Info_ProfilePicture);
				} else if (selectedUser.getGender().equalsIgnoreCase("male")) {
					putImageInLabel(Constant.PROFILE_PICTURE + "male.jpg", lblPeople_Info_ProfilePicture);
				}
			}

			lblPeople_Info_LastNameFirstName.setText(selectedUser.getLastName() + " " + selectedUser.getFirstName());
			lblPeople_Info_DateOfRegistration.setText(
					"Registered since " + convertStringIntoDateAndPutInLabel(selectedUser.getDateOfRegistration()));
			lblPeople_Info_DateOfBirthMini
					.setText("Date of birth :" + convertStringIntoDateAndPutInLabel(selectedUser.getDateOfBirth()));
			lblPeople_Info_Education.setText("Education " + selectedUser.getEducation());
			lblPeople_Info_WorkPlace.setText("Workplace " + selectedUser.getWorkplace());
			ImageIcon icon = new ImageIcon(Constant.COUNTRY_PICTURES + selectedUser.getCountry() + ".png");
			lblPeople_Info_TownCountry
					.setText("Curently in " + selectedUser.getTown() + ", " + selectedUser.getCountry());
			lblPeople_Info_TownCountry.setIcon(icon);
			lblPeople_Info_TownCountry.setHorizontalTextPosition(JLabel.LEFT);
			lblPeople_Info_TownCountry.setVerticalTextPosition(JLabel.CENTER);
			lblPeople_Info_Gender.setText("Gender " + selectedUser.getGender());
			taPeople_Info_AboutMe.setText(selectedUser.getAboutMe());
			taPeople_Info_AboutMe.setEditable(false);
			lblPeople_Info_Username.setText(selectedUser.getUsername() + "'s profile");
			lblPeople_Info_Email.setText("Email: " + selectedUser.getEmail());
		}
	}

	public void changeListOfActiveUsers(List<Integer> listOfActiveUsers2) {
		listOfActiveUsers = listOfActiveUsers2;
		fillPeoplePanelList();
	}

	private void buttonPressed(String text) {
		if (text.toLowerCase().contains("people")) {
			btnPeople.setBackground(new Color(240, 240, 240));
			btnPeople.setForeground(Color.BLUE);
			btnGroups.setBackground(Color.LIGHT_GRAY);
			btnGroups.setForeground(Color.BLACK);
			panelPeople.setVisible(true);
			panelGroups.setVisible(false);

		} else {
			btnPeople.setBackground(Color.LIGHT_GRAY);
			btnPeople.setForeground(Color.BLACK);
			btnGroups.setBackground(new Color(240, 240, 240));
			btnGroups.setForeground(Color.BLUE);
			panelPeople.setVisible(false);
			panelGroups.setVisible(true);
		}
	}

	@SuppressWarnings("unchecked")
	public void refreshUsers(Map<String, Object> hm) {
		allUsersHM = (Map<Integer, User>) hm.get(Constant.ALL_USERS_HM);
		listOfAllUsers = (List<User>) hm.get(Constant.ALL_USERS_LIST);
		fillListOfAllUsers();
		fillPeoplePanelList();
	}

	public void groupCreatedRefreshGroups(Groups newGroup) {
		listOfAllGroups.add(newGroup);
		fillGroupPanelList();
	}

	public void refreshGroupMembers(TransferClass tc) {
		if (tc.getOperation() == Constant.GROUPMEMBERS_CREATED) {
			GroupMembers grMem = (GroupMembers) tc.getServerObject();
			listOfAllGroupMembers.add(grMem);
			viewGroupInfo();
		} else if (tc.getOperation() == Constant.GROUPMEMBERS_KICKED) {
			GroupMembers grMem = (GroupMembers) tc.getServerObject();
			GroupMembers tempForDelete = null;
			for (GroupMembers temp : listOfAllGroupMembers) {
				if (temp.getIdUser() == grMem.getIdUser() && temp.getGroupName().equals(grMem.getGroupName())) {
					tempForDelete = temp;
					break;
				}
			}
			listOfAllGroupMembers.remove(tempForDelete);
			viewGroupInfo();
		} else if (tc.getOperation() == Constant.GROUPMEMBERS_ASKTOJOIN) {
			GroupMembers grMem = (GroupMembers) tc.getServerObject();
			listOfAllGroupMembers.add(grMem);
			viewGroupInfo();
		} else if (tc.getOperation() == Constant.GROUPMEMBERS_CANCELREQUEST) {
			GroupMembers grMem = (GroupMembers) tc.getServerObject();
			GroupMembers tempForDelete = null;
			for (GroupMembers temp : listOfAllGroupMembers) {
				if (temp.getIdUser() == grMem.getIdUser() && temp.getGroupName().equals(grMem.getGroupName())) {
					tempForDelete = temp;
					break;
				}
			}
			listOfAllGroupMembers.remove(tempForDelete);
			viewGroupInfo();
		} else if (tc.getOperation() == Constant.GROUPMEMBERS_ACCEPTEDMEMBERSHIP) {
			GroupMembers grMem = (GroupMembers) tc.getServerObject();
			for (GroupMembers temp : listOfAllGroupMembers) {
				if (temp.getIdUser() == grMem.getIdUser() && temp.getGroupName().equals(grMem.getGroupName())) {
					temp.setDateOfJoin(temp.getDateOfJoin());
					temp.setTimeOfJoin(temp.getTimeOfJoin());
					temp.setTypeOfMember(grMem.getTypeOfMember());
					break;
				}
			}
			viewGroupInfo();
		} else if (tc.getOperation() == Constant.GROUPMEMBERS_DECLINEDMEMBERSHIP) {
			GroupMembers grMem = (GroupMembers) tc.getServerObject();
			GroupMembers tempForDelete = null;
			for (GroupMembers temp : listOfAllGroupMembers) {
				if (temp.getIdUser() == grMem.getIdUser() && temp.getGroupName().equals(grMem.getGroupName())) {
					tempForDelete = temp;
					break;
				}
			}
			listOfAllGroupMembers.remove(tempForDelete);
			viewGroupInfo();
		}
	}

	public void dodajSliku(SendingFile sf) {

		File dir = new File(Constant.PROFILE_PICTURE + currentUser.getUsername());
		if (!dir.exists()) {
			dir.mkdir();
		}
		File newFile = new File(Constant.PROFILE_PICTURE + currentUser.getUsername() + "/" + sf.getFileName());

		try {
			Files.write(newFile.toPath(), sf.getPicture(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}

		viewProfile();
	}

	@SuppressWarnings("deprecation")
	private String convertStringIntoDateAndPutInLabel(String text) {
		String[] datum = text.split("-");
		Date date = new Date(Integer.parseInt(datum[0]) - 1900, Integer.parseInt(datum[1]) - 1,
				Integer.valueOf(datum[2]));
		text = new SimpleDateFormat("dd MMMM, YYYY").format(date);
		return text;
	}

	public void addGroupPicture(SendingFile sfRecievedGroupPicture) {
		File dir = new File(Constant.GROUP_PICTURE + currentUser.getUsername());
		if (!dir.exists()) {
			dir.mkdir();
		}
		File newFile = new File(
				Constant.GROUP_PICTURE + currentUser.getUsername() + "/" + sfRecievedGroupPicture.getFileName());
		try {
			Files.write(newFile.toPath(), sfRecievedGroupPicture.getPicture(), StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
		viewGroupInfo();
	}
}
