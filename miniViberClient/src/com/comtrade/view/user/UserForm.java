package com.comtrade.view.user;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import com.comtrade.communication.Communication;
import com.comtrade.comparator.MyComparatorUser;
import com.comtrade.constant.Constant;
import com.comtrade.controllerclient.ControllerClient;
import com.comtrade.controllerdatacombobox.ControllerDataComboBox;
import com.comtrade.domain.Friends;
import com.comtrade.domain.GroupChatEntry;
import com.comtrade.domain.GroupChatEntryRenderer;
import com.comtrade.domain.GroupMembers;
import com.comtrade.domain.GroupMessages;
import com.comtrade.domain.Groups;
import com.comtrade.domain.ListGroupEntry;
import com.comtrade.domain.ListGroupEntryRenderer;
import com.comtrade.domain.ListUsersEntry;
import com.comtrade.domain.ListUsersEntryRenderer;
import com.comtrade.domain.PrivateChatEntry;
import com.comtrade.domain.PrivateChateEntryRenderer;
import com.comtrade.domain.PrivateMessage;
import com.comtrade.domain.SendingFile;
import com.comtrade.domain.User;
import com.comtrade.thread.ThreadReqProccFromServer;
import com.comtrade.transfer.TransferClass;
import com.toedter.calendar.JDateChooser;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.EtchedBorder;

public class UserForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLayeredPane layeredPane_Groups;
	private JLayeredPane layeredPaneMain;

	private JButton btnHome;
	private JButton btnProfile;
	private JButton btnPeople;
	private JButton btnMessages;
	private JButton btnGroups;
	private JButton btnLogOut;
	private JButton btnProfile_EditProfile;
	private JButton btnPeople_ProfileInfo_One;
	private JButton btnPeople_ProfileInfo_Two;
	private JButton btnMsg_Send;
	private JButton btnGroups_GroupCreate_Create;
	private JButton btnGroups_GroupInfo_One;
	private JButton btnGroups_GroupInfo_Two;
	private JButton btnGroups_GroupInfo_Three;
	private JButton btnGroupMessages;
	private JButton btnGroupMsg_Send;
	private JButton btnEdit_ChangeProfilePicture;
	private JButton btnEdit_SaveChanges;
	private JButton btnGroups_CreateNewGroup;
	private JButton btnPeople_ProfileInfo_Three;
	private JButton btnHome_ViewProfile;
	private JButton btnHome_ViewMessages;
	private JButton btnHome_ViewFriends;
	private JButton btnGroups_GroupInfo_Four;
	private JButton btnGroupMsg_GroupInfo;
	private JButton btnMsg_ProfileInfo;
	private JButton btnGroups_GroupCreate_UploadPicture;
	private JButton btnEdit_CancelChanges;

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panelHome;
	private JPanel panelProfile;
	private JPanel panelPeople;
	private JPanel panelMessages;
	private JPanel panelGroups;
	private JPanel panelPeople_ProfileInfo;
	private JPanel panelGroups_GroupInfo;
	private JPanel panelGroupMessages;
	private JPanel panelEditProfile;
	private JPanel panelPeople_ProfileInfo_ProfilePicture;
	private JPanel panelGroups_GroupCreate;

	private JLabel lblProfile_ProfilePicture;
	private JLabel lblProfile_Username;
	private JLabel lblProfile_DateOfRegistration;
	private JLabel lblProfile_LastnameFirstname;
	private JLabel lblProfile_DateOfBirth;
	private JLabel lblProfile_TownCountry;
	private JLabel lblProfile_Workplace;
	private JLabel lblProfile_Education;
	private JLabel lblPeople_ProfileInfo_ProfilePicture;
	private JLabel lblPeople_ProfileInfo_Username;
	private JLabel lblPeople_ProfileInfo_DateOfRegistration;
	private JLabel lblPeople_ProfileInfo_LastNameFirstName;
	private JLabel lblPeople_ProfileInfo_DateOfBirth;
	private JLabel lblPeople_ProfileInfo_TownCountry;
	private JLabel lblPeople_ProfileInfo_WorkPlace;
	private JLabel lblPeople_ProfileInfo_Education;
	private JLabel lblPeople_FriendRequests;
	private JLabel lblPeople_SentRequests;
	private JLabel lblPeople_FriendList;
	private JLabel lblPeople_ProfileInfo_Gender;
	private JLabel lblProfile_Gender;
	private JLabel lblMsg_LastMessageRecieved;
	private JLabel lblMsg_MessageRecievedAt;
	private JLabel lblMsg_StatusOfLastSentMessage;
	private JLabel lblMsg_SentStatus;
	private JLabel lblGroups_GroupInfo_Name;
	private JLabel lblEdit_Username;
	private JLabel lblEdit_Email;
	private JLabel lblEdit_DateOfRegistration;
	private JLabel lblEdit_FirstName;
	private JLabel lblEdit_LastName;
	private JLabel lblEdit_Gender;
	private JLabel lblEdit_ProfilePicture;
	private JLabel lblEdit_DateOfBirth;
	private JLabel lblEdit_Country;
	private JLabel lblEdit_Town;
	private JLabel lblEdit_Workplace;
	private JLabel lblEdit_Education;
	private JLabel lblEdit_UsernameText;
	private JLabel lblEdit_EmailText;
	private JLabel lblEdit_DateOfRegistrationText;
	private JLabel lblHome_Message;
	private JLabel lblHome_NewFriend;
	private JLabel lblHome_ProfilePicture;
	private JLabel lblProfile_Email;
	private JLabel lblPeople_ProfileInfo_Email;
	private JLabel lblGroups_GroupCreate_GroupPicture;
	private JLabel lblGroups_GroupInfo_GroupPicture;
	private JLabel lblGroups_GroupInfo_Title;
	private JLabel lblGroups_GroupInfo_Title2;
	private JLabel lblGroups_GroupInfo_Title3;
	private JLabel lblPeople_SearchTitle;

	private JTextArea taProfile_AboutMe;
	private JTextArea taMsg_TextField;
	private JTextArea taGroups_GroupCreate_Info;
	private JTextArea taProfile_ProfileInfo_AboutMe;
	private JTextArea taGroups_GroupInfo_Info;
	private JTextArea taGroupMsg_Chat;
	private JTextArea taEdit_AboutMe;
	private JTextArea taGroupMsg_textMessage;
	private JTextArea taHome_Welcome;
	private JTextArea taHome_Message;
	private JTextArea taHome_Friends;
	private JTextArea taMsg_PrivateMessageChat;

	private JScrollPane spProfile_AboutMe;
	private JScrollPane spPeople_FriendsList;
	private JScrollPane spPeople_SentRequests;
	private JScrollPane spPeople_FriendRequests;
	private JScrollPane spPeople_SearchResult;
	private JScrollPane spPeople_ProfileInfo_AboutMe;
	private JScrollPane spMsg_FriendList;
	private JScrollPane spMsg_Text;
	private JScrollPane spGroups_GroupSearch;
	private JScrollPane spGroups_MyGroups;
	private JScrollPane spGroups_GroupInfo_Info;
	private JScrollPane spGroups_GroupInfo_MembersRequests;
	private JScrollPane spGroupMsg_Chat;
	private JScrollPane spGroups_GroupInfo_GroupMembers;
	private JScrollPane spEdit_AboutMe;
	private JScrollPane spGroups_MySentGroupRequests;
	private JScrollPane spGroupMsg_ListGroupChats;
	private JScrollPane spMsg_PrivateMessage;
	private JScrollPane spMsg_PrivateMessageChat;
	private JScrollPane spGroups_GroupCreate_GroupInfo;
	private JScrollPane spGroupMsg_textMessage;
	private JScrollPane spHome_PeopleYouMayKnow;

	private JList<Object> listPeople_NewFriendRequests;
	private JList<Object> listPeople_SentRequests;
	private JList<Object> listPeople_FriendsList;
	private JList<Object> listPeople_SearchResult;
	private JList<Object> listMsg_FriendList;
	private JList<Object> listGroups_MyGroups;
	private JList<Object> listGroups_GroupSearch;
	private JList<Object> listGroups_GroupInfo_Members;
	private JList<Object> listGroups_GroupInfo_GroupMemberRequests;
	private JList<Object> listGroups_MyGroupsSentRequest;
	private JList<Object> listGroupMsg_ListGroupChats;
	private JList<Object> listMsg_PrivateMessage;
	private JList<Object> listHome_PeopleYouMayKnow;

	private JTextField tfPeople_SearchPeople;
	private JTextField tfMsg_SearchFriends;
	private JTextField tfGroups_SearchGroups;
	private JTextField tfGroups_GroupCreate_Name;
	private JTextField tfEdit_FirstName;
	private JTextField tfEdit_LastName;
	private JTextField tfEdit_WorkPlace;
	private JTextField tfEdit_Education;

	private JRadioButton rbEdit_Male;
	private JRadioButton rbEdit_Female;
	private final ButtonGroup buttonEditGroup = new ButtonGroup();

	private JComboBox<Object> cbEdit_Country;
	private JComboBox<Object> cbEdit_Town;

	JFileChooser fileChooser = new JFileChooser();
	JFileChooser fileChooserGroupPicture = new JFileChooser();

	private JDateChooser dateChooserEdit;

	private DefaultListModel<Object> dlmSearchResult = new DefaultListModel<>();
	private DefaultListModel<Object> dlmMyGroups = new DefaultListModel<>();

	ThreadReqProccFromServer trps = new ThreadReqProccFromServer();

	private User currentUser;
	private User selectedUser;
	private User selectedChatUser;

	private int numberOfNewFriendRequests = 0;
	private int numberOfNewMessages = 0;
	private int numberOfNewGroupMessages = 0;
	private int numberOfNewGroupRequests = 0;

	private Map<Integer, User> allUsersHM = new HashMap<>();
	private Map<String, Object> hm = new HashMap<>();
	private Map<String, Groups> allGroupsHM = new HashMap<>();

	private List<Friends> listFriendRelation = new ArrayList<>();
	private List<User> listOfBlockedUsers = new ArrayList<>();
	private List<User> listBlockByUsers = new ArrayList<>();
	private List<User> listOfMyFriends = new ArrayList<>();
	private List<User> listOfSentRequests = new ArrayList<>();
	private List<User> listOfRecievedRequests = new ArrayList<>();
	private List<PrivateMessage> listOfPrivateMessages = new ArrayList<>();
	// private List<Groups> listOfGroups = new ArrayList<>();
	private List<GroupMembers> listOfGroupMembers = new ArrayList<>();
	private List<String> listOfMyGroups = new ArrayList<>();
	private List<Integer> listOfActiveUsers = new ArrayList<>();
	private List<GroupMessages> listOfAllGroupMessages = new ArrayList<>();
	private List<User> listOfAllUsers;
	private List<SendingFile> listOfNewProfilePictures = new ArrayList<>();
	private List<SendingFile> listOfNewGroupPictures = new ArrayList<>();

	private Groups selectedGroupGrPanel;

	private String profilePictureURL = "default";
	private String selectedGroupChat;

	
	@SuppressWarnings({ "unchecked" })
	public UserForm(Map<String, Object> hm1) {
		this.hm = hm1;
		currentUser = (User) hm.get(Constant.CURRENT_USER);
		setTitle("Currently logged as: " + currentUser.getUsername());
		listFriendRelation = (List<Friends>) hm.get(Constant.ALL_FRIEND_RELATION_LIST);
		allUsersHM = (Map<Integer, User>) hm.get(Constant.ALL_USERS_HM);
		listOfPrivateMessages = (List<PrivateMessage>) hm.get(Constant.ALL_PRIVATE_MESSAGES);
		// listOfGroups = (List<Groups>) hm.get(Constant.ALL_GROUPS_LIST);
		listOfGroupMembers = (List<GroupMembers>) hm.get(Constant.ALL_GROUPMEMBERS_LIST);
		listOfAllGroupMessages = (List<GroupMessages>) hm.get(Constant.ALL_GROUPMESSAGES_LIST);
		listOfActiveUsers = (List<Integer>) hm.get(Constant.ACTIVE_USERS);
		listOfAllUsers = (List<User>) hm.get(Constant.ALL_USERS_LIST);
		listOfNewProfilePictures = (List<SendingFile>) hm.get(Constant.ALL_NEW_PICTURES_LIST);
		listOfNewGroupPictures = (List<SendingFile>) hm.get(Constant.ALL_NEW_GROUP_PICTURES);
		allGroupsHM = (Map<String, Groups>) hm.get(Constant.ALL_GROUPS_HM);

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
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(102, 153, 255));
		panel.setBounds(0, 0, 150, 661);
		contentPane.add(panel);
		panel.setLayout(null);

		btnHome = new JButton("Home");
		btnHome.setForeground(Color.BLACK);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showHome();
			}
		});
		btnHome.setBackground(new Color(102, 153, 255));
		btnHome.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnHome.setBounds(0, 89, 150, 36);
		panel.add(btnHome);

		btnProfile = new JButton("Profile");
		btnProfile.setForeground(Color.BLACK);
		btnProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showProfile();
			}
		});
		btnProfile.setBackground(new Color(102, 153, 255));
		btnProfile.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnProfile.setBounds(0, 136, 150, 36);
		panel.add(btnProfile);

		btnPeople = new JButton("People");
		btnPeople.setForeground(Color.BLACK);
		btnPeople.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPeople_ProfileInfo.setVisible(false);
				showPeople();
			}
		});
		btnPeople.setBackground(new Color(102, 153, 255));
		btnPeople.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnPeople.setBounds(0, 183, 150, 36);
		panel.add(btnPeople);

		btnMessages = new JButton("Messages");
		btnMessages.setForeground(Color.BLACK);
		btnMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMessages();
			}
		});
		btnMessages.setBackground(new Color(102, 153, 255));
		btnMessages.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnMessages.setBounds(0, 230, 150, 36);
		panel.add(btnMessages);

		btnGroups = new JButton("Groups");
		btnGroups.setForeground(Color.BLACK);
		btnGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showGroups();
			}
		});
		btnGroups.setBackground(new Color(102, 153, 255));
		btnGroups.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnGroups.setBounds(0, 277, 150, 36);
		panel.add(btnGroups);

		btnLogOut = new JButton("Quit");
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x = JOptionPane.showConfirmDialog(null, "You are quitting the miniViber \n Are you sure?", "Quit?",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if (x == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnLogOut.setBackground(new Color(102, 153, 255));
		btnLogOut.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnLogOut.setBounds(0, 588, 150, 36);
		panel.add(btnLogOut);

		btnGroupMessages = new JButton("Group Messages");
		btnGroupMessages.setForeground(Color.BLACK);
		btnGroupMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showGroupMessages();
			}
		});
		btnGroupMessages.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnGroupMessages.setBackground(new Color(102, 153, 255));
		btnGroupMessages.setBounds(0, 324, 150, 36);
		panel.add(btnGroupMessages);

		layeredPaneMain = new JLayeredPane();
		layeredPaneMain.setBounds(150, 0, 934, 661);
		contentPane.add(layeredPaneMain);
		layeredPaneMain.setLayout(null);

		panelHome = new JPanel();
		panelHome.setBackground(Color.WHITE);
		panelHome.setBounds(0, 0, 934, 661);
		layeredPaneMain.add(panelHome);
		panelHome.setLayout(null);

		lblHome_ProfilePicture = new JLabel("New label");
		lblHome_ProfilePicture.setBounds(24, 61, 339, 252);
		panelHome.add(lblHome_ProfilePicture);

		JLabel lblHome_PeopleYouMay = new JLabel("People you may know:");
		lblHome_PeopleYouMay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblHome_PeopleYouMay.setBounds(62, 373, 161, 14);
		panelHome.add(lblHome_PeopleYouMay);

		spHome_PeopleYouMayKnow = new JScrollPane();
		spHome_PeopleYouMayKnow.setBounds(62, 398, 175, 170);
		panelHome.add(spHome_PeopleYouMayKnow);

		listHome_PeopleYouMayKnow = new JList<Object>();
		spHome_PeopleYouMayKnow.setViewportView(listHome_PeopleYouMayKnow);

		btnHome_ViewProfile = new JButton("View profile");
		btnHome_ViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listHome_PeopleYouMayKnow.getSelectedValue() != null) {
					ListUsersEntry lue = (ListUsersEntry) listHome_PeopleYouMayKnow.getSelectedValue();
					selectedUser = lue.getUser();
					showPeople();
					viewProfile();
				} else {
					JOptionPane.showMessageDialog(null, "Please select user from list");
				}
			}
		});
		btnHome_ViewProfile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnHome_ViewProfile.setBounds(62, 585, 180, 34);
		panelHome.add(btnHome_ViewProfile);

		taHome_Welcome = new JTextArea();
		taHome_Welcome.setEditable(false);
		taHome_Welcome.setForeground(Color.BLACK);
		taHome_Welcome.setWrapStyleWord(true);
		taHome_Welcome.setLineWrap(true);
		taHome_Welcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		taHome_Welcome.setBounds(431, 61, 440, 252);
		panelHome.add(taHome_Welcome);

		lblHome_Message = new JLabel("New label");
		lblHome_Message.setBounds(413, 339, 48, 48);
		panelHome.add(lblHome_Message);

		lblHome_NewFriend = new JLabel("New label");
		lblHome_NewFriend.setBounds(694, 339, 48, 48);
		panelHome.add(lblHome_NewFriend);

		taHome_Message = new JTextArea();
		taHome_Message.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		taHome_Message.setEditable(false);
		taHome_Message.setWrapStyleWord(true);
		taHome_Message.setLineWrap(true);
		taHome_Message.setBounds(356, 395, 161, 169);
		panelHome.add(taHome_Message);

		taHome_Friends = new JTextArea();
		taHome_Friends.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		taHome_Friends.setEditable(false);
		taHome_Friends.setLineWrap(true);
		taHome_Friends.setWrapStyleWord(true);
		taHome_Friends.setBounds(638, 395, 161, 169);
		panelHome.add(taHome_Friends);

		btnHome_ViewMessages = new JButton("View messages");
		btnHome_ViewMessages.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMessages();
			}
		});
		btnHome_ViewMessages.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnHome_ViewMessages.setBounds(356, 585, 161, 34);
		panelHome.add(btnHome_ViewMessages);

		btnHome_ViewFriends = new JButton("View friends");
		btnHome_ViewFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showPeople();
			}
		});
		btnHome_ViewFriends.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnHome_ViewFriends.setBounds(638, 585, 161, 34);
		panelHome.add(btnHome_ViewFriends);

		panelMessages = new JPanel();
		panelMessages.setBackground(Color.WHITE);
		panelMessages.setBounds(0, 0, 934, 661);
		layeredPaneMain.add(panelMessages);
		panelMessages.setLayout(null);

		spMsg_FriendList = new JScrollPane();
		spMsg_FriendList.setBounds(711, 47, 184, 513);
		panelMessages.add(spMsg_FriendList);

		listMsg_FriendList = new JList<Object>();
		listMsg_FriendList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (listMsg_FriendList.getSelectedValue() != null) {
					ListUsersEntry lue = (ListUsersEntry) listMsg_FriendList.getSelectedValue();
					selectedChatUser = lue.getUser();

					boolean isInChat = false;
					int positionInChat = 0;
					DefaultListModel<Object> dlm = (DefaultListModel<Object>) listMsg_PrivateMessage.getModel();

					for (int i = 0; i < dlm.size(); i++) {
						PrivateChatEntry privateChat = (PrivateChatEntry) dlm.getElementAt(i);
						if (privateChat.getChatUserId() == selectedChatUser.getIdUser()) {
							isInChat = true;
							positionInChat = i;
							break;
						}
					}
					if (isInChat) {
						listMsg_PrivateMessage.setSelectedIndex(positionInChat);
						PrivateChatEntry prch = (PrivateChatEntry) dlm.getElementAt(positionInChat);
						taMsg_PrivateMessageChat.setText(prch.getStringBuff().toString());
						lblMsg_MessageRecievedAt.setText(prch.getReceivedMessageStatus());
						lblMsg_SentStatus.setText(prch.getSentMessageStatus());
					} else {
						PrivateChatEntry privateChat = new PrivateChatEntry(selectedChatUser.getIdUser(),
								selectedChatUser.toString());
						dlm.insertElementAt(privateChat, 0);
						listMsg_PrivateMessage.setSelectedIndex(0);
					}
				}
			}
		});
		spMsg_FriendList.setViewportView(listMsg_FriendList);

		tfMsg_SearchFriends = new JTextField();
		tfMsg_SearchFriends.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String text = tfMsg_SearchFriends.getText();
				if (text.isEmpty() || text.equals(" ")) {
					listMsg_FriendList.setModel(listPeople_FriendsList.getModel());
				} else {
					DefaultListModel<Object> dlm = new DefaultListModel<>();
					for (User temp : listOfMyFriends) {
						int onlinePosition = 0;
						if (temp.getFirstName().toLowerCase().contains(text.toLowerCase())
								|| temp.getLastName().toLowerCase().contains(text.toLowerCase())
								|| temp.getUsername().toLowerCase().contains(text.toLowerCase())) {
							if (listOfActiveUsers.contains(temp.getIdUser())) {
								ListUsersEntry lue = new ListUsersEntry(temp, "online");
								dlm.insertElementAt(lue, onlinePosition++);
							} else {
								ListUsersEntry lue = new ListUsersEntry(temp, "offline");
								dlm.addElement(lue);
							}
						}
					}
					listMsg_FriendList.setModel(dlm);
				}
			}
		});
		tfMsg_SearchFriends.setBounds(711, 27, 184, 20);
		panelMessages.add(tfMsg_SearchFriends);
		tfMsg_SearchFriends.setColumns(10);

		spMsg_Text = new JScrollPane();
		spMsg_Text.setBounds(260, 498, 281, 62);
		panelMessages.add(spMsg_Text);

		taMsg_TextField = new JTextArea();
		taMsg_TextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		taMsg_TextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (listMsg_PrivateMessage.getSelectedValue() != null) {
						PrivateChatEntry privateChat = (PrivateChatEntry) listMsg_PrivateMessage.getSelectedValue();
						selectedChatUser = allUsersHM.get(privateChat.getChatUserId());
						taMsg_PrivateMessageChat.setText(privateChat.getStringBuff().toString());
						if (!privateChat.isReceivedMessageSeen()) {
							privateChat.setReceivedMessageSeen(true);
							numberOfNewMessages = numberOfNewMessages - privateChat.getNumberOfNewMessages();
							privateChat.setNumberOfNewMessages(0);

							int tempChatUser = privateChat.getChatUserId();
							PrivateMessage pm;
							if (currentUser.getIdUser() < tempChatUser) {
								pm = new PrivateMessage(currentUser.getIdUser(), tempChatUser, tempChatUser,
										Constant.MESSAGE_SEEN, "", "", "", "", "");
							} else {
								pm = new PrivateMessage(tempChatUser, currentUser.getIdUser(), tempChatUser,
										Constant.MESSAGE_SEEN, "", "", "", "", "");
							}
							TransferClass tc = new TransferClass();
							tc.setOperation(Constant.MESSAGE_SEEN_OPERATION);
							tc.setClientObject(pm);
							Communication.getInstance().sendData(tc);
							int index = listMsg_PrivateMessage.getSelectedIndex();
							DefaultListModel<Object> dlm = (DefaultListModel<Object>) listMsg_PrivateMessage.getModel();
							listMsg_PrivateMessage.setModel(new DefaultListModel<>());
							listMsg_PrivateMessage.setModel(dlm);
							listMsg_PrivateMessage.setSelectedIndex(index);
						}
						if (numberOfNewMessages != 0) {
							String temp = "Messages (" + numberOfNewMessages + ")";
							btnMessages.setText(temp);
							btnMessages.setForeground(Color.RED);
						} else {
							String temp = "Messages";
							btnMessages.setText(temp);
							btnMessages.setForeground(Color.BLACK);
						}
						lblMsg_MessageRecievedAt.setText(privateChat.getReceivedMessageStatus());
						lblMsg_SentStatus.setText(privateChat.getSentMessageStatus());
					}

					if (listMsg_PrivateMessage.getSelectedValue() != null) {
						PrivateChatEntry privateChat = (PrivateChatEntry) listMsg_PrivateMessage.getSelectedValue();

						int selectedChatUserID = privateChat.getChatUserId();
						String msgBody = taMsg_TextField.getText();
						if (msgBody.isEmpty() || msgBody.equals("") || msgBody.equals("\n")) {
							JOptionPane.showMessageDialog(null, "Please enter text before sending message");
							taMsg_TextField.setText("");
						} else {
							taMsg_TextField.setText("");
							String sendDate = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
							String sendTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
							PrivateMessage pm;
							if (currentUser.getIdUser() < selectedChatUserID) {
								pm = new PrivateMessage(currentUser.getIdUser(), selectedChatUserID,
										currentUser.getIdUser(), Constant.MESSAGE_PENDING, sendDate, "1999-01-01",
										sendTime, sendTime, msgBody);
							} else {
								pm = new PrivateMessage(selectedChatUserID, currentUser.getIdUser(),
										currentUser.getIdUser(), Constant.MESSAGE_PENDING, sendDate, "1999-01-01",
										sendTime, sendTime, msgBody);
							}
							privateChat.setSentMessageStatus(Constant.MESSAGE_PENDING);
							TransferClass tc = new TransferClass();
							tc.setOperation(Constant.MESSAGE_PENDING_OPERATION);
							tc.setClientObject(pm);
							Communication.getInstance().sendData(tc);
							refreshMsgForm(pm);

							lblMsg_SentStatus.setText(Constant.MESSAGE_PENDING);
						}
					}
				}
			}
		});
		spMsg_Text.setViewportView(taMsg_TextField);

		btnMsg_Send = new JButton("SEND");
		btnMsg_Send.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnMsg_Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (listMsg_PrivateMessage.getSelectedValue() != null) {
					PrivateChatEntry privateChat = (PrivateChatEntry) listMsg_PrivateMessage.getSelectedValue();
					selectedChatUser = allUsersHM.get(privateChat.getChatUserId());
					taMsg_PrivateMessageChat.setText(privateChat.getStringBuff().toString());
					if (!privateChat.isReceivedMessageSeen()) {
						privateChat.setReceivedMessageSeen(true);
						numberOfNewMessages = numberOfNewMessages - privateChat.getNumberOfNewMessages();
						privateChat.setNumberOfNewMessages(0);

						int tempChatUser = privateChat.getChatUserId();
						PrivateMessage pm;
						if (currentUser.getIdUser() < tempChatUser) {
							pm = new PrivateMessage(currentUser.getIdUser(), tempChatUser, tempChatUser,
									Constant.MESSAGE_SEEN, "", "", "", "", "");
						} else {
							pm = new PrivateMessage(tempChatUser, currentUser.getIdUser(), tempChatUser,
									Constant.MESSAGE_SEEN, "", "", "", "", "");
						}
						TransferClass tc = new TransferClass();
						tc.setOperation(Constant.MESSAGE_SEEN_OPERATION);
						tc.setClientObject(pm);
						Communication.getInstance().sendData(tc);
						int index = listMsg_PrivateMessage.getSelectedIndex();
						DefaultListModel<Object> dlm = (DefaultListModel<Object>) listMsg_PrivateMessage.getModel();
						listMsg_PrivateMessage.setModel(new DefaultListModel<>());
						listMsg_PrivateMessage.setModel(dlm);
						listMsg_PrivateMessage.setSelectedIndex(index);
					}
					if (numberOfNewMessages != 0) {
						String temp = "Messages (" + numberOfNewMessages + ")";
						btnMessages.setText(temp);
						btnMessages.setForeground(Color.RED);
					} else {
						String temp = "Messages";
						btnMessages.setText(temp);
						btnMessages.setForeground(Color.BLACK);
					}
					lblMsg_MessageRecievedAt.setText(privateChat.getReceivedMessageStatus());
					lblMsg_SentStatus.setText(privateChat.getSentMessageStatus());
				}

				if (listMsg_PrivateMessage.getSelectedValue() != null) {
					PrivateChatEntry privateChat = (PrivateChatEntry) listMsg_PrivateMessage.getSelectedValue();

					int selectedChatUserID = privateChat.getChatUserId();
					String msgBody = taMsg_TextField.getText();
					if (msgBody.isEmpty() || msgBody.equals("")) {
						JOptionPane.showMessageDialog(null, "Please enter text before sending message");
					} else {
						taMsg_TextField.setText("");
						String sendDate = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
						String sendTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
						msgBody = msgBody + "\n";
						PrivateMessage pm;
						if (currentUser.getIdUser() < selectedChatUserID) {
							pm = new PrivateMessage(currentUser.getIdUser(), selectedChatUserID,
									currentUser.getIdUser(), Constant.MESSAGE_PENDING, sendDate, "1999-01-01", sendTime,
									sendTime, msgBody);
						} else {
							pm = new PrivateMessage(selectedChatUserID, currentUser.getIdUser(),
									currentUser.getIdUser(), Constant.MESSAGE_PENDING, sendDate, "1999-01-01", sendTime,
									sendTime, msgBody);
						}
						privateChat.setSentMessageStatus(Constant.MESSAGE_PENDING);
						TransferClass tc = new TransferClass();
						tc.setOperation(Constant.MESSAGE_PENDING_OPERATION);
						tc.setClientObject(pm);
						Communication.getInstance().sendData(tc);
						refreshMsgForm(pm);

						lblMsg_SentStatus.setText(Constant.MESSAGE_PENDING);
					}
				}

			}
		});
		btnMsg_Send.setBounds(551, 498, 150, 62);
		panelMessages.add(btnMsg_Send);
		Image temp = new ImageIcon(Constant.ICON_SEND_MESSAGE).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
		ImageIcon tt = new ImageIcon(temp);
		btnMsg_Send.setIcon(tt);
		btnMsg_Send.setText("Send");
		btnMsg_Send.setVerticalTextPosition(JButton.CENTER);
		btnMsg_Send.setHorizontalTextPosition(JButton.RIGHT);

		lblMsg_LastMessageRecieved = new JLabel("Last message recieved at:");
		lblMsg_LastMessageRecieved.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMsg_LastMessageRecieved.setBounds(28, 589, 268, 14);
		panelMessages.add(lblMsg_LastMessageRecieved);

		lblMsg_MessageRecievedAt = new JLabel("");
		lblMsg_MessageRecievedAt.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMsg_MessageRecievedAt.setBounds(28, 614, 268, 14);
		panelMessages.add(lblMsg_MessageRecievedAt);

		lblMsg_StatusOfLastSentMessage = new JLabel("Status of last sent message ");
		lblMsg_StatusOfLastSentMessage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMsg_StatusOfLastSentMessage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMsg_StatusOfLastSentMessage.setBounds(431, 589, 270, 14);
		panelMessages.add(lblMsg_StatusOfLastSentMessage);

		lblMsg_SentStatus = new JLabel("");
		lblMsg_SentStatus.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblMsg_SentStatus.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMsg_SentStatus.setBounds(431, 614, 270, 14);
		panelMessages.add(lblMsg_SentStatus);

		spMsg_PrivateMessage = new JScrollPane();
		spMsg_PrivateMessage.setBounds(28, 29, 222, 457);
		panelMessages.add(spMsg_PrivateMessage);

		listMsg_PrivateMessage = new JList<Object>();
		listMsg_PrivateMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (listMsg_PrivateMessage.getSelectedValue() != null) {
					PrivateChatEntry privateChat = (PrivateChatEntry) listMsg_PrivateMessage.getSelectedValue();
					selectedChatUser = allUsersHM.get(privateChat.getChatUserId());
					taMsg_PrivateMessageChat.setText(privateChat.getStringBuff().toString());
					if (!privateChat.isReceivedMessageSeen()) {
						privateChat.setReceivedMessageSeen(true);
						numberOfNewMessages = numberOfNewMessages - privateChat.getNumberOfNewMessages();
						privateChat.setNumberOfNewMessages(0);

						int tempChatUser = privateChat.getChatUserId();
						PrivateMessage pm;
						if (currentUser.getIdUser() < tempChatUser) {
							pm = new PrivateMessage(currentUser.getIdUser(), tempChatUser, tempChatUser,
									Constant.MESSAGE_SEEN, "", "", "", "", "");
						} else {
							pm = new PrivateMessage(tempChatUser, currentUser.getIdUser(), tempChatUser,
									Constant.MESSAGE_SEEN, "", "", "", "", "");
						}
						TransferClass tc = new TransferClass();
						tc.setOperation(Constant.MESSAGE_SEEN_OPERATION);
						tc.setClientObject(pm);
						Communication.getInstance().sendData(tc);
						int index = listMsg_PrivateMessage.getSelectedIndex();
						DefaultListModel<Object> dlm = (DefaultListModel<Object>) listMsg_PrivateMessage.getModel();
						listMsg_PrivateMessage.setModel(new DefaultListModel<>());
						listMsg_PrivateMessage.setModel(dlm);
						listMsg_PrivateMessage.setSelectedIndex(index);
					}
					if (numberOfNewMessages != 0) {
						String temp = "Messages (" + numberOfNewMessages + ")";
						btnMessages.setText(temp);
						btnMessages.setForeground(Color.RED);
					} else {
						String temp = "Messages";
						btnMessages.setText(temp);
						btnMessages.setForeground(Color.BLACK);
					}
					lblMsg_MessageRecievedAt.setText(privateChat.getReceivedMessageStatus());
					lblMsg_SentStatus.setText(privateChat.getSentMessageStatus());
					if (!listOfMyFriends.contains(selectedChatUser)) {
						spMsg_Text.setVisible(false);
						btnMsg_Send.setVisible(false);
						lblMsg_LastMessageRecieved.setVisible(true);
						lblMsg_MessageRecievedAt.setVisible(true);
						lblMsg_SentStatus.setVisible(true);
						lblMsg_StatusOfLastSentMessage.setVisible(true);
						if (listBlockByUsers.contains(selectedChatUser)) {
							btnMsg_ProfileInfo.setVisible(false);
						} else {
							btnMsg_ProfileInfo.setVisible(true);
						}
					} else {
						spMsg_Text.setVisible(true);
						btnMsg_Send.setVisible(true);
						btnMsg_ProfileInfo.setVisible(true);
						lblMsg_LastMessageRecieved.setVisible(true);
						lblMsg_MessageRecievedAt.setVisible(true);
						lblMsg_SentStatus.setVisible(true);
						lblMsg_StatusOfLastSentMessage.setVisible(true);
					}
				}

			}
		});
		DefaultListModel<Object> dlmTemp = new DefaultListModel<>();
		listMsg_PrivateMessage.setModel(dlmTemp);
		listMsg_PrivateMessage.setCellRenderer(new PrivateChateEntryRenderer());
		spMsg_PrivateMessage.setViewportView(listMsg_PrivateMessage);

		spMsg_PrivateMessageChat = new JScrollPane();
		spMsg_PrivateMessageChat.setBounds(260, 27, 441, 459);
		panelMessages.add(spMsg_PrivateMessageChat);

		taMsg_PrivateMessageChat = new JTextArea();
		taMsg_PrivateMessageChat.setFont(new Font("Tahoma", Font.ITALIC, 13));
		taMsg_PrivateMessageChat.setEditable(false);
		spMsg_PrivateMessageChat.setViewportView(taMsg_PrivateMessageChat);

		btnMsg_ProfileInfo = new JButton("New button");
		btnMsg_ProfileInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnMsg_ProfileInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectedUser = selectedChatUser;
				showPeople();
				viewProfile();
				listPeople_NewFriendRequests.clearSelection();
				listPeople_SearchResult.clearSelection();
				listPeople_SentRequests.clearSelection();
				listPeople_FriendsList.clearSelection();
				DefaultListModel<Object> dlmTemp = (DefaultListModel<Object>) listPeople_FriendsList.getModel();
				for (int i = 0; i < dlmTemp.size(); i++) {
					ListUsersEntry lue = (ListUsersEntry) dlmTemp.getElementAt(i);
					if (lue.getUser().getIdUser() == selectedUser.getIdUser()) {
						listPeople_FriendsList.setSelectedIndex(i);
						break;
					}
				}
			}
		});
		btnMsg_ProfileInfo.setBounds(28, 498, 222, 62);
		panelMessages.add(btnMsg_ProfileInfo);
		btnMsg_ProfileInfo.setText("Profile info");
		btnMsg_ProfileInfo.setIcon(new ImageIcon(Constant.ICON_INFO));
		btnMsg_ProfileInfo.setVerticalTextPosition(JButton.CENTER);
		btnMsg_ProfileInfo.setHorizontalTextPosition(JButton.RIGHT);

		panelGroups = new JPanel();
		panelGroups.setBackground(Color.WHITE);
		panelGroups.setBounds(0, 0, 934, 661);
		layeredPaneMain.add(panelGroups);
		panelGroups.setLayout(null);

		spGroups_MyGroups = new JScrollPane();
		spGroups_MyGroups.setBounds(35, 66, 175, 270);
		panelGroups.add(spGroups_MyGroups);

		listGroups_MyGroups = new JList<Object>();
		listGroups_MyGroups.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				listGroups_GroupSearch.clearSelection();
				listGroups_MyGroupsSentRequest.clearSelection();
				if (listGroups_MyGroups.getSelectedValue() != null) {
					ListGroupEntry lge = (ListGroupEntry) listGroups_MyGroups.getSelectedValue();
					selectedGroupGrPanel = lge.getGroup();
					viewGroupInfo();
				}
			}
		});
		spGroups_MyGroups.setViewportView(listGroups_MyGroups);
		listGroups_MyGroups.setModel(dlmMyGroups);
		listGroups_MyGroups.setCellRenderer(new ListGroupEntryRenderer());

		JLabel lblGroups_MyGroups = new JLabel("My groups");
		lblGroups_MyGroups.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGroups_MyGroups.setBounds(35, 35, 89, 14);
		panelGroups.add(lblGroups_MyGroups);

		tfGroups_SearchGroups = new JTextField();
		tfGroups_SearchGroups.setHorizontalAlignment(SwingConstants.CENTER);
		tfGroups_SearchGroups.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		tfGroups_SearchGroups.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String tempString = tfGroups_SearchGroups.getText();
				if (tempString != null && !tempString.isEmpty() && !tempString.equals("")) {
					searchGroups(tempString);
				} else {
					spGroups_GroupSearch.setVisible(false);
				}
			}
		});
		tfGroups_SearchGroups.setBounds(364, 27, 258, 28);
		panelGroups.add(tfGroups_SearchGroups);
		tfGroups_SearchGroups.setColumns(10);

		spGroups_GroupSearch = new JScrollPane();
		spGroups_GroupSearch.setBounds(364, 55, 258, 75);
		panelGroups.add(spGroups_GroupSearch);
		spGroups_GroupSearch.setVisible(false);

		listGroups_GroupSearch = new JList<Object>();
		listGroups_GroupSearch.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				listGroups_MyGroups.clearSelection();
				listGroups_MyGroupsSentRequest.clearSelection();
				ListGroupEntry lge = (ListGroupEntry) listGroups_GroupSearch.getSelectedValue();
				selectedGroupGrPanel = lge.getGroup();
				tfGroups_SearchGroups.setText("");
				viewGroupInfo();
				spGroups_GroupSearch.setVisible(false);
			}
		});
		spGroups_GroupSearch.setViewportView(listGroups_GroupSearch);

		JLabel lblGroups_SentGroupRequest = new JLabel("Sent group request");
		lblGroups_SentGroupRequest.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGroups_SentGroupRequest.setBounds(35, 360, 147, 14);
		panelGroups.add(lblGroups_SentGroupRequest);

		spGroups_MySentGroupRequests = new JScrollPane();
		spGroups_MySentGroupRequests.setBounds(35, 397, 175, 216);
		panelGroups.add(spGroups_MySentGroupRequests);

		listGroups_MyGroupsSentRequest = new JList<Object>();
		listGroups_MyGroupsSentRequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				listGroups_GroupSearch.clearSelection();
				listGroups_MyGroups.clearSelection();
				if (listGroups_MyGroupsSentRequest.getSelectedValue() != null) {
					ListGroupEntry lge = (ListGroupEntry) listGroups_MyGroupsSentRequest.getSelectedValue();
					selectedGroupGrPanel = lge.getGroup();
					viewGroupInfo();
				}
			}
		});
		spGroups_MySentGroupRequests.setViewportView(listGroups_MyGroupsSentRequest);

		layeredPane_Groups = new JLayeredPane();
		layeredPane_Groups.setBounds(258, 132, 635, 492);
		panelGroups.add(layeredPane_Groups);

		panelGroups_GroupInfo = new JPanel();
		panelGroups_GroupInfo.setBackground(Color.WHITE);
		panelGroups_GroupInfo.setBounds(0, 0, 635, 492);
		layeredPane_Groups.add(panelGroups_GroupInfo);
		panelGroups_GroupInfo.setLayout(null);

		lblGroups_GroupInfo_Name = new JLabel("Group name :");
		lblGroups_GroupInfo_Name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGroups_GroupInfo_Name.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroups_GroupInfo_Name.setBounds(237, 11, 367, 30);
		panelGroups_GroupInfo.add(lblGroups_GroupInfo_Name);

		spGroups_GroupInfo_Info = new JScrollPane();
		spGroups_GroupInfo_Info.setBounds(237, 94, 367, 83);
		panelGroups_GroupInfo.add(spGroups_GroupInfo_Info);

		taGroups_GroupInfo_Info = new JTextArea();
		taGroups_GroupInfo_Info.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		spGroups_GroupInfo_Info.setViewportView(taGroups_GroupInfo_Info);
		taGroups_GroupInfo_Info.setWrapStyleWord(true);
		taGroups_GroupInfo_Info.setLineWrap(true);
		taGroups_GroupInfo_Info.setEditable(false);

		spGroups_GroupInfo_GroupMembers = new JScrollPane();
		spGroups_GroupInfo_GroupMembers.setBounds(36, 229, 165, 185);
		panelGroups_GroupInfo.add(spGroups_GroupInfo_GroupMembers);

		listGroups_GroupInfo_Members = new JList<Object>();
		spGroups_GroupInfo_GroupMembers.setViewportView(listGroups_GroupInfo_Members);

		btnGroups_GroupInfo_One = new JButton("New button");
		btnGroups_GroupInfo_One.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnGroups_GroupInfo_One.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnGroups_GroupInfo_One.getText().equals(Constant.BUTTON_GROUP_KICKFROMGROUP)) {
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.GROUPMEMBERS_KICKED);
					if (listGroups_GroupInfo_Members.getSelectedValue() == null) {
						JOptionPane.showMessageDialog(null, "Please select user you want to kick from group");
					} else {
						ListUsersEntry lue = (ListUsersEntry) listGroups_GroupInfo_Members.getSelectedValue();
						User temp = lue.getUser();
						if (temp.getIdUser() == currentUser.getIdUser()) {
							JOptionPane.showMessageDialog(null, "You are admin of this group and u cant kick yourself");
						} else {
							GroupMembers grMem = new GroupMembers(temp.getIdUser(), selectedGroupGrPanel.getGroupName(),
									"", "", "");
							tc.setClientObject(grMem);
							Communication.getInstance().sendData(tc);
						}
					}
				} else if (btnGroups_GroupInfo_One.getText().equals(Constant.BUTTON_GROUP_ASKTOJOIN)) {
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.GROUPMEMBERS_ASKTOJOIN);
					String dateOfJoin = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
					String timeOfJoin = new SimpleDateFormat("HH:mm:ss:SSS").format(new Date());
					GroupMembers grMem = new GroupMembers(currentUser.getIdUser(), selectedGroupGrPanel.getGroupName(),
							dateOfJoin, timeOfJoin, "asktojoin");
					tc.setClientObject(grMem);
					Communication.getInstance().sendData(tc);
				} else if (btnGroups_GroupInfo_One.getText().equals(Constant.BUTTON_GROUP_CANCELREQUST)) {
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.GROUPMEMBERS_CANCELREQUEST);
					GroupMembers grMem = new GroupMembers(currentUser.getIdUser(), selectedGroupGrPanel.getGroupName(),
							"", "", "");
					tc.setClientObject(grMem);
					Communication.getInstance().sendData(tc);
				} else if (btnGroups_GroupInfo_One.getText().equals(Constant.BUTTON_GROUP_LEAVE)) {
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.GROUPMEMBERS_CANCELREQUEST);
					GroupMembers grMem = new GroupMembers(currentUser.getIdUser(), selectedGroupGrPanel.getGroupName(),
							"", "", "");
					tc.setClientObject(grMem);
					Communication.getInstance().sendData(tc);
				}
			}
		});
		btnGroups_GroupInfo_One.setBounds(36, 451, 165, 30);
		panelGroups_GroupInfo.add(btnGroups_GroupInfo_One);

		btnGroups_GroupInfo_Two = new JButton("New button");
		btnGroups_GroupInfo_Two.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnGroups_GroupInfo_Two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnGroups_GroupInfo_Two.getText().equals(Constant.BUTTON_GROUP_DECLINETOGROUP)) {
					if (listGroups_GroupInfo_GroupMemberRequests.getSelectedValue() != null) {
						ListUsersEntry lue = (ListUsersEntry) listGroups_GroupInfo_GroupMemberRequests
								.getSelectedValue();
						User tempUser = lue.getUser();
						String dateOfJoin = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
						String timeOfJoin = new SimpleDateFormat("HH:mm:ss:SSS").format(new Date());
						GroupMembers grMem = new GroupMembers(tempUser.getIdUser(), selectedGroupGrPanel.getGroupName(),
								dateOfJoin, timeOfJoin, "member");
						TransferClass tc = new TransferClass();
						tc.setOperation(Constant.GROUPMEMBERS_DECLINEDMEMBERSHIP);
						tc.setClientObject(grMem);
						Communication.getInstance().sendData(tc);
					}
				}
			}
		});
		btnGroups_GroupInfo_Two.setBounds(408, 451, 165, 30);
		panelGroups_GroupInfo.add(btnGroups_GroupInfo_Two);

		spGroups_GroupInfo_MembersRequests = new JScrollPane();
		spGroups_GroupInfo_MembersRequests.setBounds(408, 229, 165, 170);
		panelGroups_GroupInfo.add(spGroups_GroupInfo_MembersRequests);

		listGroups_GroupInfo_GroupMemberRequests = new JList<Object>();
		spGroups_GroupInfo_MembersRequests.setViewportView(listGroups_GroupInfo_GroupMemberRequests);

		btnGroups_GroupInfo_Three = new JButton("New button");
		btnGroups_GroupInfo_Three.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnGroups_GroupInfo_Three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnGroups_GroupInfo_Three.getText().equals(Constant.BUTTON_GROUP_ACCEPTINTOGROUP)) {
					if (listGroups_GroupInfo_GroupMemberRequests.getSelectedValue() != null) {
						ListUsersEntry lue = (ListUsersEntry) listGroups_GroupInfo_GroupMemberRequests
								.getSelectedValue();
						User tempUser = lue.getUser();
						String dateOfJoin = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
						String timeOfJoin = new SimpleDateFormat("HH:mm:ss:SSS").format(new Date());
						GroupMembers grMem = new GroupMembers(tempUser.getIdUser(), selectedGroupGrPanel.getGroupName(),
								dateOfJoin, timeOfJoin, "member");
						TransferClass tc = new TransferClass();
						tc.setOperation(Constant.GROUPMEMBERS_ACCEPTEDMEMBERSHIP);
						tc.setClientObject(grMem);
						Communication.getInstance().sendData(tc);
					}
				}
			}
		});
		btnGroups_GroupInfo_Three.setBounds(408, 411, 165, 30);
		panelGroups_GroupInfo.add(btnGroups_GroupInfo_Three);

		btnGroups_GroupInfo_Four = new JButton("New button");
		btnGroups_GroupInfo_Four.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnGroups_GroupInfo_Four.getText().equals(Constant.BUTTON_GROUP_SENDMESSAGE)) {
					selectedGroupChat = selectedGroupGrPanel.getGroupName();
					DefaultListModel<Object> dlm = (DefaultListModel<Object>) listGroupMsg_ListGroupChats.getModel();
					for (int i = 0; i < dlm.size(); i++) {
						GroupChatEntry groupChat = (GroupChatEntry) dlm.getElementAt(i);
						if (groupChat.getGroupName().equals(selectedGroupChat)) {
							listGroupMsg_ListGroupChats.setSelectedIndex(i);
							taGroupMsg_Chat.setText(groupChat.getStringBuff().toString());
							break;
						}
					}
					showGroupMessages();

				}
			}
		});
		btnGroups_GroupInfo_Four.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnGroups_GroupInfo_Four.setBounds(243, 451, 142, 30);
		panelGroups_GroupInfo.add(btnGroups_GroupInfo_Four);

		lblGroups_GroupInfo_GroupPicture = new JLabel("New label");
		lblGroups_GroupInfo_GroupPicture.setBounds(36, 22, 165, 155);
		panelGroups_GroupInfo.add(lblGroups_GroupInfo_GroupPicture);

		lblGroups_GroupInfo_Title = new JLabel("New label");
		lblGroups_GroupInfo_Title.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroups_GroupInfo_Title.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		lblGroups_GroupInfo_Title.setBounds(237, 46, 367, 30);
		panelGroups_GroupInfo.add(lblGroups_GroupInfo_Title);

		lblGroups_GroupInfo_Title2 = new JLabel("Group members");
		lblGroups_GroupInfo_Title2.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroups_GroupInfo_Title2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGroups_GroupInfo_Title2.setBounds(36, 190, 165, 30);
		panelGroups_GroupInfo.add(lblGroups_GroupInfo_Title2);

		lblGroups_GroupInfo_Title3 = new JLabel("Group requests");
		lblGroups_GroupInfo_Title3.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroups_GroupInfo_Title3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGroups_GroupInfo_Title3.setBounds(407, 188, 166, 30);
		panelGroups_GroupInfo.add(lblGroups_GroupInfo_Title3);

		panelGroups_GroupCreate = new JPanel();
		panelGroups_GroupCreate.setBackground(Color.WHITE);
		panelGroups_GroupCreate.setBounds(0, 0, 635, 492);
		layeredPane_Groups.add(panelGroups_GroupCreate);
		panelGroups_GroupCreate.setLayout(null);

		JLabel lblGroups_GroupCreate_CreateNewGroup = new JLabel("Create new Group");
		lblGroups_GroupCreate_CreateNewGroup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGroups_GroupCreate_CreateNewGroup.setBounds(203, 28, 170, 20);
		panelGroups_GroupCreate.add(lblGroups_GroupCreate_CreateNewGroup);

		JLabel lblGroups_GroupCreate_GroupName = new JLabel("Group name:");
		lblGroups_GroupCreate_GroupName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGroups_GroupCreate_GroupName.setBounds(97, 73, 104, 24);
		panelGroups_GroupCreate.add(lblGroups_GroupCreate_GroupName);

		tfGroups_GroupCreate_Name = new JTextField();
		tfGroups_GroupCreate_Name.setHorizontalAlignment(SwingConstants.CENTER);
		tfGroups_GroupCreate_Name.setBounds(211, 74, 276, 24);
		panelGroups_GroupCreate.add(tfGroups_GroupCreate_Name);
		tfGroups_GroupCreate_Name.setColumns(10);

		JLabel lblGroups_GroupCreate_GroupInfo = new JLabel("Group info");
		lblGroups_GroupCreate_GroupInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroups_GroupCreate_GroupInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGroups_GroupCreate_GroupInfo.setBounds(357, 125, 170, 20);
		panelGroups_GroupCreate.add(lblGroups_GroupCreate_GroupInfo);

		spGroups_GroupCreate_GroupInfo = new JScrollPane();
		spGroups_GroupCreate_GroupInfo.setBounds(309, 168, 262, 203);
		panelGroups_GroupCreate.add(spGroups_GroupCreate_GroupInfo);

		taGroups_GroupCreate_Info = new JTextArea();
		taGroups_GroupCreate_Info.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		spGroups_GroupCreate_GroupInfo.setViewportView(taGroups_GroupCreate_Info);
		taGroups_GroupCreate_Info.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		taGroups_GroupCreate_Info.setWrapStyleWord(true);
		taGroups_GroupCreate_Info.setLineWrap(true);

		btnGroups_GroupCreate_Create = new JButton("Create");
		btnGroups_GroupCreate_Create.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnGroups_GroupCreate_Create.setBounds(203, 433, 170, 30);
		panelGroups_GroupCreate.add(btnGroups_GroupCreate_Create);

		lblGroups_GroupCreate_GroupPicture = new JLabel("New label");
		lblGroups_GroupCreate_GroupPicture.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGroups_GroupCreate_GroupPicture.setBounds(36, 138, 170, 170);
		panelGroups_GroupCreate.add(lblGroups_GroupCreate_GroupPicture);

		btnGroups_GroupCreate_UploadPicture = new JButton("Upload picture");
		btnGroups_GroupCreate_UploadPicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fileChooserGroupPicture.showOpenDialog(null);
				if (fileChooserGroupPicture.getSelectedFile() != null) {
					File f = fileChooserGroupPicture.getSelectedFile();
					String fileName = f.getName();
					String typeOfFile = fileName.substring(fileName.length() - 4);
					if (typeOfFile.equalsIgnoreCase(".jpg") || typeOfFile.equalsIgnoreCase(".png")
							|| typeOfFile.equalsIgnoreCase(".bmp")) {
						putImageInLabel(f.getPath(), lblGroups_GroupCreate_GroupPicture);
					} else {
						JOptionPane.showMessageDialog(null, "Profile picture must be .jpg .bmp or .png format");
					}
				}
			}
		});
		btnGroups_GroupCreate_UploadPicture.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnGroups_GroupCreate_UploadPicture.setBounds(36, 341, 170, 30);
		panelGroups_GroupCreate.add(btnGroups_GroupCreate_UploadPicture);

		btnGroups_GroupCreate_Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String groupName = tfGroups_GroupCreate_Name.getText();
				if (groupName.length() > 30 || groupName.equals("")) {
					JOptionPane.showMessageDialog(null, "Maximum characters for group name is 30");
				} else {
					String groupInfo = taGroups_GroupCreate_Info.getText();
					int groupCreatorId = currentUser.getIdUser();
					String dateOfCreation = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
					String timeOfCreation = new SimpleDateFormat("HH:mm:ss").format(new Date());
					String groupPictureURL = "default";
					if (fileChooserGroupPicture.getSelectedFile() != null) {
						File f = fileChooserGroupPicture.getSelectedFile();
						String fileName = f.getName();
						String typeOfFile = fileName.substring(fileName.length() - 4);
						groupPictureURL = groupName + typeOfFile;

					}

					Groups group = new Groups(groupName, groupCreatorId, dateOfCreation, timeOfCreation, groupInfo,
							groupPictureURL);
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.GROUP_CREATE_OPERATION);
					tc.setClientObject(group);
					Communication.getInstance().sendData(tc);
					tfGroups_GroupCreate_Name.setText("");
					taGroups_GroupCreate_Info.setText("");
					btnGroups_CreateNewGroup.setVisible(true);
					panelGroups_GroupCreate.setVisible(false);
					
				}
			}
		});

		btnGroups_CreateNewGroup = new JButton("Create new group");
		btnGroups_CreateNewGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				panelGroups_GroupCreate.setVisible(true);
				tfGroups_GroupCreate_Name.setText("");
				taGroups_GroupCreate_Info.setText("");
				btnGroups_CreateNewGroup.setVisible(false);
				panelGroups_GroupInfo.setVisible(false);
				putImageInLabel(Constant.ICON_GROUP_DEFAULT, lblGroups_GroupCreate_GroupPicture);
			}
		});
		btnGroups_CreateNewGroup.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnGroups_CreateNewGroup.setBounds(723, 27, 170, 30);
		panelGroups.add(btnGroups_CreateNewGroup);

		JLabel lblGroups_SearchTitle = new JLabel("Search groups:");
		lblGroups_SearchTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblGroups_SearchTitle.setBounds(258, 27, 105, 28);
		panelGroups.add(lblGroups_SearchTitle);

		panelProfile = new JPanel();
		panelProfile.setBounds(0, 0, 934, 661);
		panelProfile.setBackground(Color.WHITE);
		layeredPaneMain.add(panelProfile);
		panelProfile.setLayout(null);

		lblProfile_ProfilePicture = new JLabel("profilePicture");
		lblProfile_ProfilePicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile_ProfilePicture.setBounds(35, 52, 378, 284);
		panelProfile.add(lblProfile_ProfilePicture);

		lblProfile_Username = new JLabel("Username");
		lblProfile_Username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblProfile_Username.setBounds(484, 52, 415, 24);
		panelProfile.add(lblProfile_Username);

		lblProfile_DateOfRegistration = new JLabel("Date of Registration");
		lblProfile_DateOfRegistration.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblProfile_DateOfRegistration.setBounds(484, 339, 415, 24);
		panelProfile.add(lblProfile_DateOfRegistration);

		lblProfile_LastnameFirstname = new JLabel("LastName FirstName");
		lblProfile_LastnameFirstname.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblProfile_LastnameFirstname.setBounds(484, 109, 415, 24);
		panelProfile.add(lblProfile_LastnameFirstname);

		lblProfile_DateOfBirth = new JLabel("Date of Birth");
		lblProfile_DateOfBirth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblProfile_DateOfBirth.setBounds(484, 167, 415, 24);
		panelProfile.add(lblProfile_DateOfBirth);

		lblProfile_TownCountry = new JLabel("Town Country");
		lblProfile_TownCountry.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblProfile_TownCountry.setBounds(484, 281, 415, 24);
		panelProfile.add(lblProfile_TownCountry);

		lblProfile_Workplace = new JLabel("Workplace");
		lblProfile_Workplace.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblProfile_Workplace.setBounds(484, 453, 415, 24);
		panelProfile.add(lblProfile_Workplace);

		lblProfile_Education = new JLabel("Education");
		lblProfile_Education.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblProfile_Education.setBounds(484, 511, 415, 24);
		panelProfile.add(lblProfile_Education);

		spProfile_AboutMe = new JScrollPane();
		spProfile_AboutMe.setBounds(35, 388, 378, 147);
		panelProfile.add(spProfile_AboutMe);

		taProfile_AboutMe = new JTextArea();
		taProfile_AboutMe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		taProfile_AboutMe.setWrapStyleWord(true);
		taProfile_AboutMe.setLineWrap(true);
		spProfile_AboutMe.setViewportView(taProfile_AboutMe);

		lblProfile_Gender = new JLabel("Gender");
		lblProfile_Gender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblProfile_Gender.setBounds(484, 224, 415, 24);
		panelProfile.add(lblProfile_Gender);

		btnProfile_EditProfile = new JButton("Edit profile");
		btnProfile_EditProfile.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnProfile_EditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelProfile.setVisible(false);
				panelEditProfile.setVisible(true);
				fillPanelEditProfileData();
			}
		});
		btnProfile_EditProfile.setBounds(384, 592, 156, 32);
		panelProfile.add(btnProfile_EditProfile);

		lblProfile_Email = new JLabel("Email:");
		lblProfile_Email.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblProfile_Email.setBounds(484, 394, 415, 24);
		panelProfile.add(lblProfile_Email);

		panelPeople = new JPanel();
		panelPeople.setBackground(Color.WHITE);
		panelPeople.setBounds(0, 0, 934, 661);
		layeredPaneMain.add(panelPeople);
		panelPeople.setLayout(null);

		spPeople_FriendsList = new JScrollPane();
		spPeople_FriendsList.setBounds(30, 41, 173, 221);
		panelPeople.add(spPeople_FriendsList);

		listPeople_FriendsList = new JList<Object>();
		listPeople_FriendsList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				listPeople_NewFriendRequests.clearSelection();
				listPeople_SearchResult.clearSelection();
				listPeople_SentRequests.clearSelection();
				if (listPeople_FriendsList.getSelectedValue() != null) {
					ListUsersEntry lue = (ListUsersEntry) listPeople_FriendsList.getSelectedValue();
					selectedUser = lue.getUser();
					viewProfile();
				}
			}
		});
		spPeople_FriendsList.setViewportView(listPeople_FriendsList);

		spPeople_SentRequests = new JScrollPane();
		spPeople_SentRequests.setBounds(30, 500, 173, 130);
		panelPeople.add(spPeople_SentRequests);

		listPeople_SentRequests = new JList<Object>();
		listPeople_SentRequests.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				listPeople_NewFriendRequests.clearSelection();
				listPeople_FriendsList.clearSelection();
				listPeople_SearchResult.clearSelection();
				if (listPeople_SentRequests.getSelectedValue() != null) {
					ListUsersEntry lue = (ListUsersEntry) listPeople_SentRequests.getSelectedValue();
					selectedUser = lue.getUser();
					viewProfile();
				}
			}
		});
		spPeople_SentRequests.setViewportView(listPeople_SentRequests);

		spPeople_FriendRequests = new JScrollPane();
		spPeople_FriendRequests.setBounds(30, 316, 173, 130);
		panelPeople.add(spPeople_FriendRequests);

		listPeople_NewFriendRequests = new JList<Object>();
		listPeople_NewFriendRequests.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				listPeople_FriendsList.clearSelection();
				listPeople_SearchResult.clearSelection();
				listPeople_SentRequests.clearSelection();
				if (listPeople_NewFriendRequests.getSelectedValue() != null) {
					ListUsersEntry lue = (ListUsersEntry) listPeople_NewFriendRequests.getSelectedValue();
					selectedUser = lue.getUser();
					viewProfile();
				}
			}
		});
		spPeople_FriendRequests.setViewportView(listPeople_NewFriendRequests);

		lblPeople_FriendList = new JLabel("Friend list");
		lblPeople_FriendList.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_FriendList.setBounds(30, 15, 173, 17);
		panelPeople.add(lblPeople_FriendList);

		lblPeople_SentRequests = new JLabel("Sent requests");
		lblPeople_SentRequests.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_SentRequests.setBounds(30, 474, 173, 17);
		panelPeople.add(lblPeople_SentRequests);

		lblPeople_FriendRequests = new JLabel("Friend requests");
		lblPeople_FriendRequests.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_FriendRequests.setBounds(30, 290, 173, 17);
		panelPeople.add(lblPeople_FriendRequests);

		tfPeople_SearchPeople = new JTextField();
		tfPeople_SearchPeople.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String tempString = tfPeople_SearchPeople.getText();
				if (!tempString.isEmpty() && !tempString.equals("")) {
					searchPeople(tempString);
					spPeople_SearchResult.setVisible(true);
					if (listPeople_SearchResult.getModel().getSize() == 0) {
						spPeople_SearchResult.setVisible(false);
					}
				} else {
					spPeople_SearchResult.setVisible(false);
					// JOptionPane.showMessageDialog(null, "Please enter some letters");
				}
			}
		});
		tfPeople_SearchPeople.setBounds(430, 8, 250, 30);
		panelPeople.add(tfPeople_SearchPeople);
		tfPeople_SearchPeople.setColumns(10);

		panelPeople_ProfileInfo = new JPanel();
		panelPeople_ProfileInfo.setBackground(Color.WHITE);
		panelPeople_ProfileInfo.setBounds(244, 146, 680, 515);
		panelPeople.add(panelPeople_ProfileInfo);
		panelPeople_ProfileInfo.setLayout(null);

		lblPeople_ProfileInfo_Username = new JLabel("<dynamic>'s profile");
		lblPeople_ProfileInfo_Username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_ProfileInfo_Username.setBounds(355, 22, 304, 28);
		panelPeople_ProfileInfo.add(lblPeople_ProfileInfo_Username);

		lblPeople_ProfileInfo_DateOfRegistration = new JLabel("Registered since <dynamic>");
		lblPeople_ProfileInfo_DateOfRegistration.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_ProfileInfo_DateOfRegistration.setBounds(10, 249, 263, 28);
		panelPeople_ProfileInfo.add(lblPeople_ProfileInfo_DateOfRegistration);

		lblPeople_ProfileInfo_LastNameFirstName = new JLabel("<dynamic> <dynamic>");
		lblPeople_ProfileInfo_LastNameFirstName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_ProfileInfo_LastNameFirstName.setBounds(355, 70, 304, 21);
		panelPeople_ProfileInfo.add(lblPeople_ProfileInfo_LastNameFirstName);

		lblPeople_ProfileInfo_DateOfBirth = new JLabel("Date of birth : <dynamic>");
		lblPeople_ProfileInfo_DateOfBirth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_ProfileInfo_DateOfBirth.setBounds(355, 117, 304, 21);
		panelPeople_ProfileInfo.add(lblPeople_ProfileInfo_DateOfBirth);

		lblPeople_ProfileInfo_TownCountry = new JLabel("Curently in <dynamic>, <dynamic>");
		lblPeople_ProfileInfo_TownCountry.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_ProfileInfo_TownCountry.setBounds(355, 217, 304, 21);
		panelPeople_ProfileInfo.add(lblPeople_ProfileInfo_TownCountry);

		lblPeople_ProfileInfo_WorkPlace = new JLabel("Workplace <dynamic>");
		lblPeople_ProfileInfo_WorkPlace.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_ProfileInfo_WorkPlace.setBounds(10, 350, 263, 21);
		panelPeople_ProfileInfo.add(lblPeople_ProfileInfo_WorkPlace);

		lblPeople_ProfileInfo_Education = new JLabel("Education <dynamic>");
		lblPeople_ProfileInfo_Education.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_ProfileInfo_Education.setBounds(10, 396, 263, 21);
		panelPeople_ProfileInfo.add(lblPeople_ProfileInfo_Education);

		spPeople_ProfileInfo_AboutMe = new JScrollPane();
		spPeople_ProfileInfo_AboutMe.setBounds(297, 285, 304, 132);
		panelPeople_ProfileInfo.add(spPeople_ProfileInfo_AboutMe);

		taProfile_ProfileInfo_AboutMe = new JTextArea();
		taProfile_ProfileInfo_AboutMe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		taProfile_ProfileInfo_AboutMe.setWrapStyleWord(true);
		taProfile_ProfileInfo_AboutMe.setLineWrap(true);
		spPeople_ProfileInfo_AboutMe.setViewportView(taProfile_ProfileInfo_AboutMe);

		lblPeople_ProfileInfo_Gender = new JLabel("Gender <dynamic>");
		lblPeople_ProfileInfo_Gender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_ProfileInfo_Gender.setBounds(355, 167, 304, 21);
		panelPeople_ProfileInfo.add(lblPeople_ProfileInfo_Gender);

		btnPeople_ProfileInfo_One = new JButton("1");
		btnPeople_ProfileInfo_One.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnPeople_ProfileInfo_One.setBackground(Color.WHITE);
		btnPeople_ProfileInfo_One.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnPeople_ProfileInfo_One.getText().contains(Constant.BUTTON_ADD_FRIEND)) {
					TransferClass tc = new TransferClass();
					Friends fr = new Friends(currentUser.getIdUser(), selectedUser.getIdUser(), currentUser.getIdUser(),
							Constant.FRIEND_REQUEST_SENT);
					tc.setClientObject(fr);
					tc.setOperation(Constant.FRIEND_REQUEST_SENT);
					Communication.getInstance().sendData(tc);
					refreshFriendRelations(fr);
				} else if (btnPeople_ProfileInfo_One.getText().contains(Constant.BUTTON_ACCEPT_REQUEST)) {
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.FRIEND_REQUEST_ACCEPTED);
					Friends fr = new Friends(currentUser.getIdUser(), selectedUser.getIdUser(), currentUser.getIdUser(),
							Constant.FRIEND_REQUEST_ACCEPTED);
					tc.setClientObject(fr);
					Communication.getInstance().sendData(tc);
					refreshFriendRelations(fr);
					if (currentUser.getProfilePictureURL().contains(currentUser.getUsername())) {
						File f = new File(Constant.PROFILE_PICTURE + currentUser.getUsername() + "/"
								+ currentUser.getProfilePictureURL());
						byte[] picture;
						try {
							picture = Files.readAllBytes(f.toPath());
							SendingFile sf = new SendingFile(picture);
							sf.setFileName(currentUser.getProfilePictureURL());
							sf.setIdSender(currentUser.getIdUser());
							sf.getListOfRecievers().add(selectedUser.getIdUser());
							TransferClass tcSendMyPicToFriend = new TransferClass();
							tcSendMyPicToFriend.setClientObject(sf);
							tcSendMyPicToFriend.setOperation(Constant.SEND_MY_PROFILE_PICTURE_TO_NEW_FRIEND);
							Communication.getInstance().sendData(tcSendMyPicToFriend);
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}
					if (selectedUser.getProfilePictureURL().contains(selectedUser.getUsername())) {
						TransferClass tcAskForPicture = new TransferClass();
						tcAskForPicture.setOperation(Constant.ASK_FOR_FRIEND_PROFILE_PICTURE);
						tcAskForPicture.setClientObject(selectedUser.getProfilePictureURL());
						Communication.getInstance().sendData(tcAskForPicture);

					}
				} else if (btnPeople_ProfileInfo_One.getText().contains(Constant.BUTTON_UNFRIEND)
						|| btnPeople_ProfileInfo_One.getText().contains(Constant.BUTTON_CANCEL_REQUEST)) {
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.FRIEND_REQUEST_DECLINED);
					Friends fr;
					if (currentUser.getIdUser() < selectedUser.getIdUser()) {
						fr = new Friends(currentUser.getIdUser(), selectedUser.getIdUser(), currentUser.getIdUser(),
								Constant.FRIEND_REQUEST_DECLINED);
					} else {
						fr = new Friends(selectedUser.getIdUser(), currentUser.getIdUser(), currentUser.getIdUser(),
								Constant.FRIEND_REQUEST_DECLINED);
					}
					tc.setClientObject(fr);
					Communication.getInstance().sendData(tc);
					refreshFriendRelations(fr);
				} else if (btnPeople_ProfileInfo_One.getText().equals(Constant.BUTTON_UNBLOCK_REQUEST)) {
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.FRIEND_REQUEST_DECLINED);
					Friends fr;
					if (currentUser.getIdUser() < selectedUser.getIdUser()) {
						fr = new Friends(currentUser.getIdUser(), selectedUser.getIdUser(), currentUser.getIdUser(),
								Constant.FRIEND_REQUEST_DECLINED);
					} else {
						fr = new Friends(selectedUser.getIdUser(), currentUser.getIdUser(), currentUser.getIdUser(),
								Constant.FRIEND_REQUEST_DECLINED);
					}
					tc.setClientObject(fr);
					Communication.getInstance().sendData(tc);
					refreshFriendRelations(fr);
				}
				viewProfile();
			}
		});
		btnPeople_ProfileInfo_One.setBounds(299, 454, 132, 30);
		panelPeople_ProfileInfo.add(btnPeople_ProfileInfo_One);

		btnPeople_ProfileInfo_Two = new JButton("2");
		btnPeople_ProfileInfo_Two.setBackground(Color.WHITE);
		btnPeople_ProfileInfo_Two.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnPeople_ProfileInfo_Two.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (btnPeople_ProfileInfo_Two.getText().contains(Constant.BUTTON_DECLINE_REQUEST)) {
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.FRIEND_REQUEST_DECLINED);
					Friends fr;
					if (currentUser.getIdUser() < selectedUser.getIdUser()) {
						fr = new Friends(currentUser.getIdUser(), selectedUser.getIdUser(), currentUser.getIdUser(),
								Constant.FRIEND_REQUEST_DECLINED);
					} else {
						fr = new Friends(selectedUser.getIdUser(), currentUser.getIdUser(), currentUser.getIdUser(),
								Constant.FRIEND_REQUEST_DECLINED);
					}
					tc.setClientObject(fr);
					Communication.getInstance().sendData(tc);
					refreshFriendRelations(fr);
				} else if (btnPeople_ProfileInfo_Two.getText().equals(Constant.BUTTON_BLOCK_USER)) {
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.FRIEND_REQUEST_BLOCK_FRIEND);
					Friends fr;
					if (currentUser.getIdUser() < selectedUser.getIdUser()) {
						fr = new Friends(currentUser.getIdUser(), selectedUser.getIdUser(), currentUser.getIdUser(),
								Constant.FRIEND_REQUEST_BLOCK_FRIEND);
					} else {
						fr = new Friends(selectedUser.getIdUser(), currentUser.getIdUser(), currentUser.getIdUser(),
								Constant.FRIEND_REQUEST_BLOCK_FRIEND);
					}
					if (!isThereFriendRelation(fr)) {
						tc.setOperation(Constant.FRIEND_REQUEST_BLOCK_NON_FRIEND);
						fr.setActionStatus(Constant.FRIEND_REQUEST_BLOCK_NON_FRIEND);
					}
					tc.setClientObject(fr);
					Communication.getInstance().sendData(tc);
					refreshFriendRelations(fr);
				}
				viewProfile();
			}
		});
		btnPeople_ProfileInfo_Two.setBounds(469, 454, 132, 30);
		panelPeople_ProfileInfo.add(btnPeople_ProfileInfo_Two);

		panelPeople_ProfileInfo_ProfilePicture = new JPanel();
		panelPeople_ProfileInfo_ProfilePicture.setBackground(new Color(240, 240, 240));
		panelPeople_ProfileInfo_ProfilePicture.setBounds(10, 11, 315, 215);
		panelPeople_ProfileInfo.add(panelPeople_ProfileInfo_ProfilePicture);
		panelPeople_ProfileInfo_ProfilePicture.setLayout(null);

		lblPeople_ProfileInfo_ProfilePicture = new JLabel("Profile Picture");
		lblPeople_ProfileInfo_ProfilePicture.setBounds(6, 6, 301, 203);
		panelPeople_ProfileInfo_ProfilePicture.add(lblPeople_ProfileInfo_ProfilePicture);

		btnPeople_ProfileInfo_Three = new JButton("3");
		btnPeople_ProfileInfo_Three.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listPeople_FriendsList.getSelectedValue() != null || selectedUser != null) {
					if (listPeople_FriendsList.getSelectedValue() != null) {
						ListUsersEntry lue = (ListUsersEntry) listPeople_FriendsList.getSelectedValue();
						selectedChatUser = lue.getUser();
					}
					if (selectedUser != null) {
						selectedChatUser = selectedUser;
					}
					boolean isInChat = false;
					int positionInChat = 0;
					DefaultListModel<Object> dlm = (DefaultListModel<Object>) listMsg_PrivateMessage.getModel();
					for (int i = 0; i < dlm.size(); i++) {
						PrivateChatEntry privateChat = (PrivateChatEntry) dlm.getElementAt(i);
						if (privateChat.getChatUserId() == selectedChatUser.getIdUser()) {
							isInChat = true;
							positionInChat = i;
							break;
						}
					}
					if (isInChat) {
						listMsg_PrivateMessage.setSelectedIndex(positionInChat);
						PrivateChatEntry prch = (PrivateChatEntry) dlm.getElementAt(positionInChat);
						taMsg_PrivateMessageChat.setText(prch.getStringBuff().toString());
						lblMsg_MessageRecievedAt.setText(prch.getReceivedMessageStatus());
						lblMsg_SentStatus.setText(prch.getSentMessageStatus());
					} else {
						PrivateChatEntry privateChat = new PrivateChatEntry(selectedChatUser.getIdUser(),
								selectedChatUser.toString());
						dlm.insertElementAt(privateChat, 0);
						listMsg_PrivateMessage.setSelectedIndex(0);
					}
					showMessages();
				}
			}
		});
		btnPeople_ProfileInfo_Three.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnPeople_ProfileInfo_Three.setBackground(Color.WHITE);
		btnPeople_ProfileInfo_Three.setBounds(80, 454, 132, 30);
		panelPeople_ProfileInfo.add(btnPeople_ProfileInfo_Three);

		lblPeople_ProfileInfo_Email = new JLabel("Email <dynamic>");
		lblPeople_ProfileInfo_Email.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_ProfileInfo_Email.setBounds(10, 301, 263, 21);
		panelPeople_ProfileInfo.add(lblPeople_ProfileInfo_Email);

		spPeople_SearchResult = new JScrollPane();
		spPeople_SearchResult.setBounds(430, 38, 250, 104);
		panelPeople.add(spPeople_SearchResult);
		spPeople_SearchResult.setVisible(false);

		listPeople_SearchResult = new JList<Object>();
		listPeople_SearchResult.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseReleased(MouseEvent e) {
				listPeople_NewFriendRequests.clearSelection();
				listPeople_FriendsList.clearSelection();
				listPeople_SentRequests.clearSelection();
				if (listPeople_SearchResult.getSelectedValue() != null) {
					ListUsersEntry lue = (ListUsersEntry) listPeople_SearchResult.getSelectedValue();
					selectedUser = lue.getUser();
					viewProfile();
					tfPeople_SearchPeople.setText("");
					spPeople_SearchResult.setVisible(false);
					if (listOfMyFriends.contains(selectedUser)) {
						DefaultListModel<Object> dlm = (DefaultListModel<Object>) listPeople_FriendsList.getModel();
						for (int i = 0; i < dlm.size(); i++) {
							ListUsersEntry userEntry = (ListUsersEntry) dlm.getElementAt(i);
							if (userEntry.getUser().getIdUser() == selectedUser.getIdUser()) {
								listPeople_FriendsList.setSelectedIndex(i);
								break;
							}
						}
					}
				}
			}
		});
		spPeople_SearchResult.setViewportView(listPeople_SearchResult);
		listPeople_SearchResult.setModel(dlmSearchResult);

		lblPeople_SearchTitle = new JLabel("Search people:");
		lblPeople_SearchTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblPeople_SearchTitle.setBounds(315, 8, 108, 30);
		panelPeople.add(lblPeople_SearchTitle);

		panelGroupMessages = new JPanel();
		panelGroupMessages.setBackground(Color.WHITE);
		panelGroupMessages.setBounds(0, 0, 934, 661);
		layeredPaneMain.add(panelGroupMessages);
		panelGroupMessages.setLayout(null);

		spGroupMsg_Chat = new JScrollPane();
		spGroupMsg_Chat.setBounds(260, 52, 529, 503);
		panelGroupMessages.add(spGroupMsg_Chat);

		taGroupMsg_Chat = new JTextArea();
		taGroupMsg_Chat.setFont(new Font("Tahoma", Font.ITALIC, 13));
		taGroupMsg_Chat.setWrapStyleWord(true);
		taGroupMsg_Chat.setLineWrap(true);
		taGroupMsg_Chat.setEditable(false);
		spGroupMsg_Chat.setViewportView(taGroupMsg_Chat);

		spGroupMsg_textMessage = new JScrollPane();
		spGroupMsg_textMessage.setBounds(260, 566, 370, 62);
		panelGroupMessages.add(spGroupMsg_textMessage);

		taGroupMsg_textMessage = new JTextArea();
		taGroupMsg_textMessage.setFont(new Font("Tahoma", Font.PLAIN, 13));
		taGroupMsg_textMessage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					if (taGroupMsg_textMessage.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please enter text before sending message");
					} else {
						if (listGroupMsg_ListGroupChats.getSelectedValue() != null) {
							DefaultListModel<Object> dlmGroupChat = (DefaultListModel<Object>) listGroupMsg_ListGroupChats
									.getModel();
							int index = listGroupMsg_ListGroupChats.getSelectedIndex();
							GroupChatEntry groupChat = (GroupChatEntry) dlmGroupChat.getElementAt(index);

							if (!groupChat.isReceivedMsgSeen()) {
								groupChat.setReceivedMsgSeen(true);
								numberOfNewGroupMessages = numberOfNewGroupMessages
										- groupChat.getNumberOfNewMessages();
								groupChat.setNumberOfNewMessages(0);
								for (GroupMembers tempMemb : listOfGroupMembers) {
									if (tempMemb.getIdUser() == currentUser.getIdUser()
											&& tempMemb.getGroupName().equals(groupChat.getGroupName())) {
										String dateOfDeliveredMessage = new SimpleDateFormat("YYYY-MM-dd")
												.format(new Date());
										String timeOfDeliveredMessage = new SimpleDateFormat("HH:mm:ss:SSS")
												.format(new Date());
										tempMemb.setDateOfDeliveredMessage(dateOfDeliveredMessage);
										tempMemb.setTimeOfDeliveredMessage(timeOfDeliveredMessage);
										TransferClass tc = new TransferClass();
										tc.setOperation(Constant.GROUPMEMBERS_CHANGED);
										tc.setClientObject(tempMemb);
										Communication.getInstance().sendData(tc);
									}
								}
							}

							int senderId = currentUser.getIdUser();
							String groupName = groupChat.getGroupName();
							String messageBody = taGroupMsg_textMessage.getText();
							if (messageBody.isEmpty() || messageBody.equals("") || messageBody.equals("\n")) {
								JOptionPane.showMessageDialog(null, "Please enter text before sending message");
							} else {
								String sendDate = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
								String sendTime = new SimpleDateFormat("HH:mm:ss:SSS").format(new Date());

								GroupMessages groupMess = new GroupMessages(senderId, groupName, messageBody, sendDate,
										sendTime);

								addGroupMessageToChat(groupMess);
								TransferClass tc = new TransferClass();
								tc.setOperation(Constant.GROUPMESSAGE_CREATEOPERATION);
								tc.setClientObject(groupMess);
								Communication.getInstance().sendData(tc);
								taGroupMsg_textMessage.setText("");
							}
							taGroupMsg_textMessage.setText("");
						}
					}
					if (listGroupMsg_ListGroupChats.getSelectedValue() != null) {
						GroupChatEntry groupChat = (GroupChatEntry) listGroupMsg_ListGroupChats.getSelectedValue();
						if (!groupChat.isReceivedMsgSeen()) {
							groupChat.setReceivedMsgSeen(true);
							numberOfNewGroupMessages = numberOfNewGroupMessages - groupChat.getNumberOfNewMessages();
							groupChat.setNumberOfNewMessages(0);
							for (GroupMembers tempMemb : listOfGroupMembers) {
								if (tempMemb.getIdUser() == currentUser.getIdUser()
										&& tempMemb.getGroupName().equals(groupChat.getGroupName())) {
									String dateOfDeliveredMessage = new SimpleDateFormat("YYYY-MM-dd")
											.format(new Date());
									String timeOfDeliveredMessage = new SimpleDateFormat("HH:mm:ss:SSS")
											.format(new Date());
									tempMemb.setDateOfDeliveredMessage(dateOfDeliveredMessage);
									tempMemb.setTimeOfDeliveredMessage(timeOfDeliveredMessage);
									TransferClass tc = new TransferClass();
									tc.setOperation(Constant.GROUPMEMBERS_CHANGED);
									tc.setClientObject(tempMemb);
									Communication.getInstance().sendData(tc);
								}
							}
						}
					}
				}
			}
		});
		spGroupMsg_textMessage.setViewportView(taGroupMsg_textMessage);

		btnGroupMsg_Send = new JButton("Send");
		btnGroupMsg_Send.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnGroupMsg_Send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (taGroupMsg_textMessage.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please enter text before sending message");
				} else {
					if (listGroupMsg_ListGroupChats.getSelectedValue() != null) {
						DefaultListModel<Object> dlmGroupChat = (DefaultListModel<Object>) listGroupMsg_ListGroupChats
								.getModel();
						int index = listGroupMsg_ListGroupChats.getSelectedIndex();
						GroupChatEntry groupChat = (GroupChatEntry) dlmGroupChat.getElementAt(index);
						int senderId = currentUser.getIdUser();
						String groupName = groupChat.getGroupName();
						String messageBody = taGroupMsg_textMessage.getText();
						if (messageBody.isEmpty() || messageBody.equals("") || messageBody.equals("\n")) {
							JOptionPane.showMessageDialog(null, "Please enter text before sending message");
						} else {
							String sendDate = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
							String sendTime = new SimpleDateFormat("HH:mm:ss:SSS").format(new Date());
							messageBody = messageBody + "\n";
							GroupMessages groupMess = new GroupMessages(senderId, groupName, messageBody, sendDate,
									sendTime);
							addGroupMessageToChat(groupMess);
							TransferClass tc = new TransferClass();
							tc.setOperation(Constant.GROUPMESSAGE_CREATEOPERATION);
							tc.setClientObject(groupMess);
							Communication.getInstance().sendData(tc);
							taGroupMsg_textMessage.setText("");
						}
						taGroupMsg_textMessage.setText("");
					}

				}

			}
		});
		btnGroupMsg_Send.setBounds(639, 566, 150, 62);
		Image temp1 = new ImageIcon(Constant.ICON_SEND_MESSAGE).getImage().getScaledInstance(60, 60,
				Image.SCALE_SMOOTH);
		ImageIcon tt1 = new ImageIcon(temp1);
		btnGroupMsg_Send.setIcon(tt1);
		btnGroupMsg_Send.setText("Send");
		btnGroupMsg_Send.setVerticalTextPosition(JButton.CENTER);
		btnGroupMsg_Send.setHorizontalTextPosition(JButton.RIGHT);
		panelGroupMessages.add(btnGroupMsg_Send);

		spGroupMsg_ListGroupChats = new JScrollPane();
		spGroupMsg_ListGroupChats.setBounds(28, 52, 222, 503);
		panelGroupMessages.add(spGroupMsg_ListGroupChats);

		listGroupMsg_ListGroupChats = new JList<Object>();
		listGroupMsg_ListGroupChats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (listGroupMsg_ListGroupChats.getSelectedValue() != null) {
					GroupChatEntry groupChat = (GroupChatEntry) listGroupMsg_ListGroupChats.getSelectedValue();
					btnGroupMsg_Send.setVisible(true);
					spGroupMsg_textMessage.setVisible(true);
					btnGroupMsg_GroupInfo.setVisible(true);
					selectedGroupChat = groupChat.getGroupName();

					taGroupMsg_Chat.setText(groupChat.getStringBuff().toString());
					if (!groupChat.isReceivedMsgSeen()) {
						groupChat.setReceivedMsgSeen(true);
						numberOfNewGroupMessages = numberOfNewGroupMessages - groupChat.getNumberOfNewMessages();
						groupChat.setNumberOfNewMessages(0);
						for (GroupMembers tempMemb : listOfGroupMembers) {
							if (tempMemb.getIdUser() == currentUser.getIdUser()
									&& tempMemb.getGroupName().equals(groupChat.getGroupName())) {
								String dateOfDeliveredMessage = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
								String timeOfDeliveredMessage = new SimpleDateFormat("HH:mm:ss:SSS").format(new Date());
								tempMemb.setDateOfDeliveredMessage(dateOfDeliveredMessage);
								tempMemb.setTimeOfDeliveredMessage(timeOfDeliveredMessage);
								TransferClass tc = new TransferClass();
								tc.setOperation(Constant.GROUPMEMBERS_CHANGED);
								tc.setClientObject(tempMemb);
								Communication.getInstance().sendData(tc);
							}
						}
					}
					int index = listGroupMsg_ListGroupChats.getSelectedIndex();
					DefaultListModel<Object> dlm = (DefaultListModel<Object>) listGroupMsg_ListGroupChats.getModel();
					listGroupMsg_ListGroupChats.setModel(new DefaultListModel<>());
					listGroupMsg_ListGroupChats.setModel(dlm);
					listGroupMsg_ListGroupChats.setSelectedIndex(index);
					if (numberOfNewGroupMessages != 0) {
						String text = "Group msg (+" + numberOfNewGroupMessages + ")";
						btnGroupMessages.setForeground(Color.RED);
						btnGroupMessages.setText(text);
					} else {
						String text = "Group messages";
						btnGroupMessages.setText(text);
						btnGroupMessages.setForeground(Color.BLACK);
						btnGroupMessages.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

					}
				}
			}
		});
		spGroupMsg_ListGroupChats.setViewportView(listGroupMsg_ListGroupChats);

		btnGroupMsg_GroupInfo = new JButton("New button");
		btnGroupMsg_GroupInfo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnGroupMsg_GroupInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultListModel<Object> dlm = (DefaultListModel<Object>) listGroups_MyGroups.getModel();
				for (int i = 0; i < dlm.size(); i++) {
					ListGroupEntry groupEntry = (ListGroupEntry) dlm.getElementAt(i);
					if (groupEntry.getGroup().getGroupName().equals(selectedGroupChat)) {
						selectedGroupGrPanel = groupEntry.getGroup();
						break;
					}
				}
				showGroups();
				viewGroupInfo();
			}
		});
		btnGroupMsg_GroupInfo.setBounds(28, 566, 222, 62);
		panelGroupMessages.add(btnGroupMsg_GroupInfo);
		btnGroupMsg_GroupInfo.setText("Group info");
		btnGroupMsg_GroupInfo.setIcon(new ImageIcon(Constant.ICON_INFO));
		btnGroupMsg_GroupInfo.setVerticalTextPosition(JButton.CENTER);
		btnGroupMsg_GroupInfo.setHorizontalTextPosition(JButton.RIGHT);

		panelEditProfile = new JPanel();
		panelEditProfile.setBackground(Color.WHITE);
		panelEditProfile.setBounds(0, 0, 934, 661);
		layeredPaneMain.add(panelEditProfile);
		panelEditProfile.setLayout(null);

		lblEdit_ProfilePicture = new JLabel("profilePicture");
		lblEdit_ProfilePicture.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit_ProfilePicture.setBounds(35, 52, 331, 210);
		panelEditProfile.add(lblEdit_ProfilePicture);

		btnEdit_ChangeProfilePicture = new JButton("Change picture");
		btnEdit_ChangeProfilePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fileChooser.showOpenDialog(null);
				if (fileChooser.getSelectedFile() != null) {
					File f = fileChooser.getSelectedFile();
					String fileName = f.getName();
					String typeOfFile = fileName.substring(fileName.length() - 4);
					if (typeOfFile.equalsIgnoreCase(".jpg") || typeOfFile.equalsIgnoreCase(".png")
							|| typeOfFile.equalsIgnoreCase(".bmp")) {
						putImageInLabel(f.getPath(), lblEdit_ProfilePicture);
					} else {
						JOptionPane.showMessageDialog(null, "Profile picture must be .jpg .bmp or .png format");
					}
				}
			}
		});
		btnEdit_ChangeProfilePicture.setBackground(Color.WHITE);
		btnEdit_ChangeProfilePicture.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnEdit_ChangeProfilePicture.setBounds(107, 308, 173, 32);
		panelEditProfile.add(btnEdit_ChangeProfilePicture);

		lblEdit_Username = new JLabel("Username");
		lblEdit_Username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_Username.setBounds(481, 52, 156, 24);
		panelEditProfile.add(lblEdit_Username);

		lblEdit_Email = new JLabel("E-mail adress");
		lblEdit_Email.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_Email.setBounds(481, 95, 156, 24);
		panelEditProfile.add(lblEdit_Email);

		lblEdit_DateOfRegistration = new JLabel("Date of Registration");
		lblEdit_DateOfRegistration.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_DateOfRegistration.setBounds(481, 137, 156, 24);
		panelEditProfile.add(lblEdit_DateOfRegistration);

		lblEdit_FirstName = new JLabel("First name");
		lblEdit_FirstName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_FirstName.setBounds(481, 179, 156, 24);
		panelEditProfile.add(lblEdit_FirstName);

		lblEdit_LastName = new JLabel("Last name");
		lblEdit_LastName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_LastName.setBounds(481, 221, 156, 24);
		panelEditProfile.add(lblEdit_LastName);

		lblEdit_Gender = new JLabel("Gender");
		lblEdit_Gender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_Gender.setBounds(481, 264, 156, 24);
		panelEditProfile.add(lblEdit_Gender);

		rbEdit_Male = new JRadioButton("Male");
		buttonEditGroup.add(rbEdit_Male);
		rbEdit_Male.setBackground(Color.WHITE);
		rbEdit_Male.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		rbEdit_Male.setBounds(481, 306, 78, 24);
		rbEdit_Male.setSelected(true);
		panelEditProfile.add(rbEdit_Male);

		rbEdit_Female = new JRadioButton("Female");
		buttonEditGroup.add(rbEdit_Female);
		rbEdit_Female.setBackground(Color.WHITE);
		rbEdit_Female.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		rbEdit_Female.setBounds(567, 306, 109, 24);
		panelEditProfile.add(rbEdit_Female);

		lblEdit_DateOfBirth = new JLabel("Date of Birth");
		lblEdit_DateOfBirth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_DateOfBirth.setBounds(481, 348, 156, 24);
		panelEditProfile.add(lblEdit_DateOfBirth);

		lblEdit_Country = new JLabel("Country");
		lblEdit_Country.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_Country.setBounds(481, 391, 156, 24);
		panelEditProfile.add(lblEdit_Country);

		lblEdit_Town = new JLabel("Town");
		lblEdit_Town.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_Town.setBounds(481, 433, 156, 24);
		panelEditProfile.add(lblEdit_Town);

		lblEdit_Workplace = new JLabel("Workplace");
		lblEdit_Workplace.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_Workplace.setBounds(481, 475, 156, 24);
		panelEditProfile.add(lblEdit_Workplace);

		lblEdit_Education = new JLabel("Education");
		lblEdit_Education.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_Education.setBounds(481, 517, 156, 24);
		panelEditProfile.add(lblEdit_Education);

		tfEdit_FirstName = new JTextField();
		tfEdit_FirstName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		tfEdit_FirstName.setBackground(Color.WHITE);
		tfEdit_FirstName.setBounds(647, 179, 156, 24);
		panelEditProfile.add(tfEdit_FirstName);
		tfEdit_FirstName.setColumns(10);

		tfEdit_LastName = new JTextField();
		tfEdit_LastName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		tfEdit_LastName.setColumns(10);
		tfEdit_LastName.setBackground(Color.WHITE);
		tfEdit_LastName.setBounds(647, 221, 156, 24);
		panelEditProfile.add(tfEdit_LastName);

		tfEdit_WorkPlace = new JTextField();
		tfEdit_WorkPlace.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		tfEdit_WorkPlace.setColumns(10);
		tfEdit_WorkPlace.setBackground(Color.WHITE);
		tfEdit_WorkPlace.setBounds(647, 475, 156, 24);
		panelEditProfile.add(tfEdit_WorkPlace);

		tfEdit_Education = new JTextField();
		tfEdit_Education.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		tfEdit_Education.setColumns(10);
		tfEdit_Education.setBackground(Color.WHITE);
		tfEdit_Education.setBounds(647, 517, 156, 24);
		panelEditProfile.add(tfEdit_Education);

		cbEdit_Country = new JComboBox<Object>();
		cbEdit_Country.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbEdit_Town.removeAllItems();
				String country = cbEdit_Country.getSelectedItem().toString();
				List<String> lista = ControllerDataComboBox.getInstance().getHmOfCountries().get(country);
				for (String temp : lista) {
					cbEdit_Town.addItem(temp);
				}
			}
		});

		cbEdit_Country.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		cbEdit_Country.setBackground(Color.WHITE);
		cbEdit_Country.setBounds(647, 391, 156, 24);
		panelEditProfile.add(cbEdit_Country);

		cbEdit_Town = new JComboBox<Object>();
		cbEdit_Town.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		cbEdit_Town.setBackground(Color.WHITE);
		cbEdit_Town.setBounds(647, 433, 156, 24);
		panelEditProfile.add(cbEdit_Town);

		dateChooserEdit = new JDateChooser();
		dateChooserEdit.getCalendarButton().setBackground(Color.WHITE);
		dateChooserEdit.setBounds(647, 348, 156, 24);
		panelEditProfile.add(dateChooserEdit);

		JLabel lblEdit_AboutMe = new JLabel("About me");
		lblEdit_AboutMe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit_AboutMe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_AboutMe.setBounds(139, 379, 122, 24);
		panelEditProfile.add(lblEdit_AboutMe);

		spEdit_AboutMe = new JScrollPane();
		spEdit_AboutMe.setBounds(35, 414, 331, 127);
		panelEditProfile.add(spEdit_AboutMe);

		taEdit_AboutMe = new JTextArea();
		taEdit_AboutMe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		taEdit_AboutMe.setWrapStyleWord(true);
		taEdit_AboutMe.setLineWrap(true);
		spEdit_AboutMe.setViewportView(taEdit_AboutMe);

		lblEdit_UsernameText = new JLabel("Username");
		lblEdit_UsernameText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_UsernameText.setBounds(647, 52, 248, 24);
		panelEditProfile.add(lblEdit_UsernameText);

		lblEdit_EmailText = new JLabel("Email");
		lblEdit_EmailText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_EmailText.setBounds(647, 95, 248, 24);
		panelEditProfile.add(lblEdit_EmailText);

		lblEdit_DateOfRegistrationText = new JLabel("DoR");
		lblEdit_DateOfRegistrationText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblEdit_DateOfRegistrationText.setBounds(647, 137, 248, 24);
		panelEditProfile.add(lblEdit_DateOfRegistrationText);

		btnEdit_SaveChanges = new JButton("Save changes");
		btnEdit_SaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date d = dateChooserEdit.getDate();
				if (d == null) {
					JOptionPane.showMessageDialog(null, "Please select date of birth");
				} else {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String date = df.format(dateChooserEdit.getDate());
					currentUser.setDateOfBirth(date);
					String firstName = tfEdit_FirstName.getText();
					String lastName = tfEdit_LastName.getText();
					String gender;
					if (rbEdit_Female.isSelected()) {
						gender = rbEdit_Female.getText();
					} else {
						gender = rbEdit_Male.getText();
					}
					String workplace = tfEdit_WorkPlace.getText();
					String education = tfEdit_Education.getText();
					String town = cbEdit_Town.getSelectedItem().toString();
					String country = cbEdit_Country.getSelectedItem().toString();
					String aboutMe = taEdit_AboutMe.getText();
					if (firstName.length() > 20) {
						JOptionPane.showMessageDialog(null, "Maximum characters for first name is 20");
					} else if (lastName.length() > 20) {
						JOptionPane.showMessageDialog(null, "Maximum characters for last name is 20");
					} else if (workplace.length() > 20) {
						JOptionPane.showMessageDialog(null, "Maximum characters for education is 20");
					} else if (education.length() > 20) {
						JOptionPane.showMessageDialog(null, "Maximum characters for workplace is 20");
					} else {
						currentUser.setFirstName(firstName);
						currentUser.setLastName(lastName);
						currentUser.setGender(gender);
						currentUser.setWorkplace(workplace);
						currentUser.setEducation(education);
						currentUser.setTown(town);
						currentUser.setCountry(country);
						currentUser.setAboutMe(aboutMe);
						if (fileChooser.getSelectedFile() != null) {
							File f = fileChooser.getSelectedFile();
							String fileName = f.getName();
							String typeOfFile = fileName.substring(fileName.length() - 4);
							if (typeOfFile.equalsIgnoreCase(".jpg") || typeOfFile.equalsIgnoreCase(".png")
									|| typeOfFile.equalsIgnoreCase(".bmp")) {
								profilePictureURL = currentUser.getUsername() + typeOfFile;
								File dir = new File(Constant.PROFILE_PICTURE + currentUser.getUsername());
								if (!dir.exists()) {
									dir.mkdir();
								}
								File destinationFile = new File(
										Constant.PROFILE_PICTURE + currentUser.getUsername() + "/" + profilePictureURL);
								currentUser.setProfilePictureURL(profilePictureURL);
								try {
									Files.copy(f.toPath(), destinationFile.toPath(),
											StandardCopyOption.REPLACE_EXISTING);
								} catch (IOException e) {
									e.printStackTrace();
								}
								byte[] picture;
								try {
									picture = Files.readAllBytes(destinationFile.toPath());
									SendingFile sf1 = new SendingFile(picture);
									for (User temp : listOfMyFriends) {
										sf1.getListOfRecievers().add(temp.getIdUser());
									}
									sf1.setFileName(profilePictureURL);
									sf1.setIdSender(currentUser.getIdUser());
									TransferClass tcSendPic = new TransferClass();
									tcSendPic.setOperation(Constant.COPY_PROFILE_PICTURE_TO_SERVER);
									tcSendPic.setClientObject(sf1);
									Communication.getInstance().sendData(tcSendPic);
								} catch (IOException e) {
									e.printStackTrace();
								}
							}
						}

						TransferClass tc = new TransferClass();
						tc.setOperation(Constant.UPDATE_USER_INFO);
						tc.setClientObject(currentUser);
						Communication.getInstance().sendData(tc);
						showProfile();
						panelEditProfile.setVisible(false);
					}
				}
			}
		});
		btnEdit_SaveChanges.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnEdit_SaveChanges.setBounds(428, 584, 209, 32);
		panelEditProfile.add(btnEdit_SaveChanges);

		btnEdit_CancelChanges = new JButton("Cancel changes");
		btnEdit_CancelChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showProfile();
			}
		});
		btnEdit_CancelChanges.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnEdit_CancelChanges.setBounds(686, 584, 209, 32);
		panelEditProfile.add(btnEdit_CancelChanges);

		trps.start();
		showHome();
		fillProfilePanel();
		ControllerClient.getInstance().setUserForm(this);
		fillPeoplePanel();
		fillPrivateMessagesPanel();
		fillGroupPanel();
		fillGroupMessagePanel();
		suggestedFriends();
		fillHomePanel();
		checkIsThereNewProfilePictures();
		checkIsThereNewGroupPictures();

	}
//	Home panel, fill with starting informations
	private void fillHomePanel() {
		if (currentUser.getProfilePictureURL().contains(currentUser.getUsername())) {
			putImageInLabel(
					Constant.PROFILE_PICTURE + currentUser.getUsername() + "/" + currentUser.getProfilePictureURL(),
					lblHome_ProfilePicture);
		} else if (currentUser.getGender().contains("Male")) {
			putImageInLabel(Constant.PROFILE_PICTURE_MALE, lblHome_ProfilePicture);
		} else {
			putImageInLabel(Constant.PROFILE_PICTURE_FEMALE, lblHome_ProfilePicture);
		}
		DefaultListModel<Object> dlm = new DefaultListModel<>();
		for (Integer temp : suggestedFriends()) {
			ListUsersEntry lue = new ListUsersEntry(allUsersHM.get(temp), "notfriend");
			dlm.addElement(lue);
		}
		listHome_PeopleYouMayKnow.setModel(dlm);
		listHome_PeopleYouMayKnow.setCellRenderer(new ListUsersEntryRenderer());

		StringBuffer sb = new StringBuffer();
		sb.append("Hello " + currentUser.getFirstName());
		sb.append("\nwelcome back to miniViber");
		taHome_Welcome.setText(sb.toString());
		String text;
		if (numberOfNewMessages != 0) {
			text = "Number of new messages " + numberOfNewMessages;
			DefaultListModel<Object> dlmMessage = (DefaultListModel<Object>) listMsg_PrivateMessage.getModel();
			int numOfChats = 0;
			for (int i = 0; i < dlmMessage.size(); i++) {
				PrivateChatEntry privateChat = (PrivateChatEntry) dlmMessage.getElementAt(i);
				if (privateChat.getNumberOfNewMessages() != 0) {
					numOfChats++;
				}
			}
			text = text + " from " + numOfChats + " friends";
		} else {
			text = "There is no new messages";
		}
		taHome_Message.setText(text);

		if (numberOfNewFriendRequests != 0) {
			text = "Number of new friend requests " + numberOfNewFriendRequests;
		} else {
			text = "There is no new friend requests";
		}
		if (listPeople_FriendsList.getModel().getSize() != 0) {
			text = text + "\nNumber of friends " + listPeople_FriendsList.getModel().getSize();
		}
		taHome_Friends.setText(text);
		putImageInLabel("icons/newmsg148.png", lblHome_Message);
		putImageInLabel("icons/recieved-request.png", lblHome_NewFriend);
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
		}
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

	private List<Integer> suggestedFriends() {
		List<Integer> myFriendsRelationList = new ArrayList<>();
		List<Integer> myFriends = new ArrayList<>();
		for (Friends tempFr : listFriendRelation) {
			if (tempFr.getUserOneId() == currentUser.getIdUser() || tempFr.getUserTwoId() == currentUser.getIdUser()) {
				if (currentUser.getIdUser() == tempFr.getUserOneId()) {
					myFriendsRelationList.add(tempFr.getUserTwoId());
					if (tempFr.getActionStatus() == Constant.FRIEND_REQUEST_ACCEPTED) {
						myFriends.add(tempFr.getUserTwoId());
					}
				} else {
					myFriendsRelationList.add(tempFr.getUserOneId());
					if (tempFr.getActionStatus() == Constant.FRIEND_REQUEST_ACCEPTED) {
						myFriends.add(tempFr.getUserOneId());
					}
				}
			}
		}
		List<Integer> listOfSuggestedFriends = new ArrayList<>();
		for (Friends tempFr : listFriendRelation) {
			if (tempFr.getActionStatus() == Constant.FRIEND_REQUEST_ACCEPTED) {
				if (myFriends.contains(tempFr.getUserOneId())) {
					if (!myFriendsRelationList.contains(tempFr.getUserTwoId())
							&& tempFr.getUserTwoId() != currentUser.getIdUser()) {
						listOfSuggestedFriends.add(tempFr.getUserTwoId());
					}
				}
				if (myFriends.contains(tempFr.getUserTwoId()) && tempFr.getUserOneId() != currentUser.getIdUser()) {
					if (!myFriendsRelationList.contains(tempFr.getUserOneId())) {
						listOfSuggestedFriends.add(tempFr.getUserOneId());
					}
				}
			}
		}

		for (User temp : listOfAllUsers) {
			if (!myFriendsRelationList.contains(temp.getIdUser()) && temp.getIdUser() != currentUser.getIdUser()
					&& !temp.getTypeOfUser().equals("admin")) {
				int rep = 0;
				if (temp.getLastName().equals(currentUser.getLastName())) {
					rep += 8;
				}
				if (temp.getWorkplace().equals(currentUser.getWorkplace())) {
					rep += 6;
				}
				if (temp.getEducation().equals(currentUser.getEducation())) {
					rep += 3;
				}
				if (temp.getTown().equals(currentUser.getTown())) {
					rep += 2;
				}
				if (temp.getCountry().equals(currentUser.getCountry())) {
					rep++;
				}
				for (int i = 0; i < rep; i++) {
					listOfSuggestedFriends.add(temp.getIdUser());
				}
			}
		}

		List<Integer> myFiveFriends = new ArrayList<>();
		Collections.sort(listOfSuggestedFriends);
		int numbOfSugg = 0;
		if (listOfSuggestedFriends.size() == 0) {

		} else {
			int temp1 = 0;
			int temp2 = 0;
			for (Integer t : listOfSuggestedFriends) {
				temp2 = t;
				if (temp2 != temp1) {
					numbOfSugg++;
				}
				temp1 = t;
			}
		}
		int i = 0;
		int n = 0;
		if (numbOfSugg < 5) {
			n = numbOfSugg;
		} else {
			n = 5;
		}
		while (i < n) {
			int maxIndex = listOfSuggestedFriends.size();

			int number = (int) (Math.random() * maxIndex);

			if (!myFiveFriends.contains(listOfSuggestedFriends.get(number))) {
				myFiveFriends.add(listOfSuggestedFriends.get(number));
				i++;
			}
		}
		return myFiveFriends;
	}

	private void putImageInLabel(String path, JLabel label) {
		ImageIcon img = new ImageIcon(path);
		img.getImage().flush();
		Image image = img.getImage();
		Image newImg = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(newImg));
	}

	// EDIT PANEL
	@SuppressWarnings("deprecation")
	private void fillPanelEditProfileData() {
		lblEdit_UsernameText.setText(currentUser.getUsername());
		lblEdit_EmailText.setText(currentUser.getEmail());
		lblEdit_DateOfRegistrationText.setText(convertStringIntoDateAndPutInLabel(currentUser.getDateOfRegistration()));
		String dateOfB[] = currentUser.getDateOfBirth().split("-");
		int year = Integer.valueOf(dateOfB[0]) - 1900;
		int month = Integer.valueOf(dateOfB[1]) - 1;
		int day = Integer.valueOf(dateOfB[2]);
		Date dateOfBirth = new Date(year, month, day);
		dateChooserEdit.setDate(dateOfBirth);
		tfEdit_FirstName.setText(currentUser.getFirstName());
		tfEdit_LastName.setText(currentUser.getLastName());
		tfEdit_WorkPlace.setText(currentUser.getWorkplace());
		tfEdit_Education.setText(currentUser.getEducation());
		taEdit_AboutMe.setText(currentUser.getAboutMe());
		if (currentUser.getGender().equals("Male")) {
			rbEdit_Male.setSelected(true);
		} else {
			rbEdit_Female.setSelected(true);
		}

		fillComboBoxesCountryAndTown();
		cbEdit_Country.setSelectedItem(currentUser.getCountry());
		cbEdit_Town.setSelectedItem(currentUser.getTown());

		if (currentUser.getProfilePictureURL().contains(currentUser.getUsername())) {
			putImageInLabel(
					Constant.PROFILE_PICTURE + currentUser.getUsername() + "/" + currentUser.getProfilePictureURL(),
					lblEdit_ProfilePicture);
		} else {
			if (currentUser.getGender().equalsIgnoreCase("female")) {
				putImageInLabel(Constant.PROFILE_PICTURE_FEMALE, lblEdit_ProfilePicture);
			} else if (currentUser.getGender().equalsIgnoreCase("male")) {
				putImageInLabel(Constant.PROFILE_PICTURE_MALE, lblEdit_ProfilePicture);
			}
		}
	}

	private void fillComboBoxesCountryAndTown() {
		Map<String, List<String>> hmOfCountries = ControllerDataComboBox.getInstance().getHmOfCountries();
		for (Entry<String, List<String>> temp : hmOfCountries.entrySet()) {
			cbEdit_Country.addItem(temp.getKey());
		}
		String country = cbEdit_Country.getSelectedItem().toString();
		for (String temp : hmOfCountries.get(country)) {
			cbEdit_Town.addItem(temp);
		}
	}

	// GROUP MESSAGE PANEL

	private boolean compareDates(String date1, String time1, String date2, String time2) {
		if (date1.compareTo(date2) > 0) {
			return true;
		} else if (date1.compareTo(date2) == 0) {
			if (time1.compareTo(time2) > 0) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	private void fillGroupMessagesInChat() {
		DefaultListModel<Object> dlmListGroupMessages = (DefaultListModel<Object>) listGroupMsg_ListGroupChats
				.getModel();
		Map<String, GroupMembers> hmOfMyGroupMemberships = new HashMap<>();
		for (GroupMembers tempGroupMember : listOfGroupMembers) {
			if (tempGroupMember.getIdUser() == currentUser.getIdUser()) {
				hmOfMyGroupMemberships.put(tempGroupMember.getGroupName(), tempGroupMember);
			}
		}

		for (GroupMessages tempGrMessage : listOfAllGroupMessages) {
			if (listOfMyGroups.contains(tempGrMessage.getGroupName())) {

				if (compareDates(tempGrMessage.getSendDate(), tempGrMessage.getSendTime(),
						hmOfMyGroupMemberships.get(tempGrMessage.getGroupName()).getDateOfJoin(),
						hmOfMyGroupMemberships.get(tempGrMessage.getGroupName()).getTimeOfJoin())) {

					int indexOfSelectedGroup = 0;
					for (int i = 0; i < dlmListGroupMessages.size(); i++) {
						GroupChatEntry groupChat = (GroupChatEntry) dlmListGroupMessages.getElementAt(i);
						if (groupChat.getGroupName().equals(tempGrMessage.getGroupName())) {
							indexOfSelectedGroup = i;
							break;
						}
					}
					GroupChatEntry groupChat = (GroupChatEntry) dlmListGroupMessages.getElementAt(indexOfSelectedGroup);
					if (tempGrMessage.getSenderId() == currentUser.getIdUser()) {
						groupChat.getStringBuff().append(">>>>ME<<<<: " + tempGrMessage.getMessageBody() + "\n");
					} else {
						groupChat.getStringBuff().append(allUsersHM.get(tempGrMessage.getSenderId()) + ": "
								+ tempGrMessage.getMessageBody() + "\n");

						if (compareDates(tempGrMessage.getSendDate(), tempGrMessage.getSendTime(),
								hmOfMyGroupMemberships.get(tempGrMessage.getGroupName()).getDateOfDeliveredMessage(),
								hmOfMyGroupMemberships.get(tempGrMessage.getGroupName()).getTimeOfDeliveredMessage())) {
							groupChat.addNumberOfNewMessage();
							groupChat.setReceivedMsgSeen(false);
							numberOfNewGroupMessages++;
						}
					}

					dlmListGroupMessages.removeElementAt(indexOfSelectedGroup);
					dlmListGroupMessages.insertElementAt(groupChat, 0);
				}

			}
		}
		listGroupMsg_ListGroupChats.setModel(dlmListGroupMessages);
		// listGroupMsg_ListGroupChats.setCellRenderer(new GroupChatEntryRenderer());
		if (numberOfNewGroupMessages != 0) {
			String text = "Group msg (+" + numberOfNewGroupMessages + ")";
			btnGroupMessages.setForeground(Color.RED);
			btnGroupMessages.setText(text);
		} else {
			btnGroupMessages.setForeground(Color.BLACK);
			btnGroupMessages.setFont(new Font("Comic Sans MS", Font.BOLD, 14));

		}
	}

	public void addGroupMessageToChat(GroupMessages groupMessage) {
		if (listOfMyGroups.contains(groupMessage.getGroupName())) {
			int indexOfSelectedGroup = 0;
			DefaultListModel<Object> dlmGroupChat = (DefaultListModel<Object>) listGroupMsg_ListGroupChats.getModel();

			for (int i = 0; i < dlmGroupChat.size(); i++) {
				GroupChatEntry groupChat = (GroupChatEntry) dlmGroupChat.getElementAt(i);
				if (groupChat.getGroupName().equals(groupMessage.getGroupName())) {
					indexOfSelectedGroup = i;
					break;
				}
			}

			GroupChatEntry groupChat = (GroupChatEntry) dlmGroupChat.getElementAt(indexOfSelectedGroup);
			if (groupMessage.getSenderId() == currentUser.getIdUser()) {
				groupChat.getStringBuff().append(">>>>ME<<<<: " + groupMessage.getMessageBody() + "\n");
			} else {
				groupChat.getStringBuff().append(
						allUsersHM.get(groupMessage.getSenderId()) + ": " + groupMessage.getMessageBody() + "\n");
				groupChat.addNumberOfNewMessage();
				groupChat.setReceivedMsgSeen(false);
				numberOfNewGroupMessages++;
			}

			dlmGroupChat.removeElementAt(indexOfSelectedGroup);
			dlmGroupChat.insertElementAt(groupChat, 0);

			if (selectedGroupChat != null) {
				if (selectedGroupChat.equals(groupMessage.getGroupName())) {
					listGroupMsg_ListGroupChats.setSelectedIndex(0);
					taGroupMsg_Chat.setText(groupChat.getStringBuff().toString());
				} else {
					int selectedGroupChatIndex = 0;
					for (int i = 0; i < dlmGroupChat.size(); i++) {
						groupChat = (GroupChatEntry) dlmGroupChat.getElementAt(i);
						if (groupChat.getGroupName().equals(selectedGroupChat)) {
							selectedGroupChatIndex = i;
							break;
						}
					}
					listGroupMsg_ListGroupChats.setSelectedIndex(selectedGroupChatIndex);
					// proveriti da li valja ovo
					taGroupMsg_Chat.setText(groupChat.getStringBuff().toString());
				}
			}

		}
		if (numberOfNewGroupMessages != 0) {
			String text = "Group msg (+" + numberOfNewGroupMessages + ")";
			btnGroupMessages.setForeground(Color.RED);
			btnGroupMessages.setText(text);
		} else {
			btnGroupMessages.setForeground(Color.BLACK);
			btnGroupMessages.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
			btnGroupMessages.setText("Group messages");

		}
	}

	@SuppressWarnings("unchecked")
	private void fillGroupMessagePanel() {
		DefaultListModel<Object> dlmGroupChat = new DefaultListModel<>();
		for (GroupMembers temp : listOfGroupMembers) {
			if (temp.getIdUser() == currentUser.getIdUser()
					&& (temp.getTypeOfMember().equals("admin") || temp.getTypeOfMember().equals("member"))) {
				GroupChatEntry groupChat = new GroupChatEntry(temp.getGroupName());
				dlmGroupChat.addElement(groupChat);
			}
		}
		listGroupMsg_ListGroupChats.setModel(new DefaultListModel<>());
		listGroupMsg_ListGroupChats.setModel(dlmGroupChat);
		listGroupMsg_ListGroupChats.setCellRenderer(new GroupChatEntryRenderer());
		fillGroupMessagesInChat();
	}

	// GROOUP PANEL

	private void fillGroupPanel() {
		numberOfNewGroupRequests = 0;
		DefaultListModel<Object> tempDlmMyGroups = new DefaultListModel<>();
		DefaultListModel<Object> tempDlmMyGroupsSentRequests = new DefaultListModel<>();
		listOfMyGroups = new ArrayList<>();

		for (GroupMembers tempGroupMembers : listOfGroupMembers) {
			if (tempGroupMembers.getIdUser() == currentUser.getIdUser()) {
				Groups tempGroup = allGroupsHM.get(tempGroupMembers.getGroupName());
				String pathGroupImage;
				if (tempGroup.getGroupPictureURL().contains(tempGroup.getGroupName())) {
					pathGroupImage = Constant.GROUP_PICTURE + currentUser.getUsername() + "/"
							+ tempGroup.getGroupPictureURL();
				} else {
					pathGroupImage = Constant.ICON_GROUP_DEFAULT;
				}
				ListGroupEntry lge = new ListGroupEntry(tempGroup, pathGroupImage);
				if (tempGroupMembers.getTypeOfMember().equals("asktojoin")) {
					tempDlmMyGroupsSentRequests.addElement(lge);
				} else {
					tempDlmMyGroups.addElement(lge);
					listOfMyGroups.add(tempGroup.getGroupName());
				}
			}
		}
		for (int i = 0; i < tempDlmMyGroups.size(); i++) {
			ListGroupEntry lge = (ListGroupEntry) tempDlmMyGroups.getElementAt(i);
			if (lge.getGroup().getGroupCreatorId() == currentUser.getIdUser()) {
				for (GroupMembers temp : listOfGroupMembers) {
					if (temp.getGroupName().equals(lge.getGroup().getGroupName())
							&& temp.getTypeOfMember().equals("asktojoin")) {
						numberOfNewGroupRequests++;
						lge.addNewGroupRequest();
					}
				}
			}
		}
		listGroups_MyGroups.setModel(new DefaultListModel<>());
		listGroups_MyGroups.setModel(tempDlmMyGroups);
		listGroups_MyGroups.setCellRenderer(new ListGroupEntryRenderer());
		listGroups_MyGroupsSentRequest.setModel(new DefaultListModel<>());
		listGroups_MyGroupsSentRequest.setModel(tempDlmMyGroupsSentRequests);
		listGroups_MyGroupsSentRequest.setCellRenderer(new ListGroupEntryRenderer());
		if (numberOfNewGroupRequests != 0) {
			btnGroups.setText("Groups (" + numberOfNewGroupRequests + ")");
			btnGroups.setForeground(Color.RED);
		} else {
			btnGroups.setText("Groups ");
			btnGroups.setForeground(Color.BLACK);
		}
	}

	public void groupCreateInfo(TransferClass tc) {
		Groups group = (Groups) tc.getServerObject();
		if (group.getGroupCreatorId() == currentUser.getIdUser()) {
			JOptionPane.showMessageDialog(null, tc.getServerMessage());
			if (tc.getOperation() == Constant.GROUP_CREATE_SUCCESS) {
				if (group.getGroupPictureURL().contains(group.getGroupName())) {
					File f = fileChooserGroupPicture.getSelectedFile();

					File dir = new File(Constant.GROUP_PICTURE + currentUser.getUsername());
					if (!dir.exists()) {
						dir.mkdir();
					}
					File destinationFile = new File(
							Constant.GROUP_PICTURE + currentUser.getUsername() + "/" + group.getGroupPictureURL());
					try {
						Files.copy(f.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
					} catch (IOException e) {
						e.printStackTrace();
					}

					byte[] picture;
					try {
						picture = Files.readAllBytes(destinationFile.toPath());
						SendingFile sf = new SendingFile(picture);
						sf.setFileName(group.getGroupPictureURL());
						sf.setIdSender(currentUser.getIdUser());
						TransferClass tcSendGroupPicture = new TransferClass();
						tcSendGroupPicture.setOperation(Constant.COPY_GROUP_PICTURE_TO_ALL);
						tcSendGroupPicture.setClientObject(sf);
						Communication.getInstance().sendData(tcSendGroupPicture);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				selectedGroupGrPanel = group;
				viewGroupInfo();
			} else if (tc.getOperation() == Constant.GROUP_CREATE_FAILED) {
				showGroups();
				panelGroups_GroupInfo.setVisible(false);
				panelGroups_GroupCreate.setVisible(true);
				tfGroups_GroupCreate_Name.setText(group.getGroupName());
				taGroups_GroupInfo_Info.setText(group.getGroupInfo());
				if (group.getGroupPictureURL().contains(group.getGroupName())) {
					File f = fileChooserGroupPicture.getSelectedFile();
					putImageInLabel(f.getPath(), lblGroups_GroupCreate_GroupPicture);
				} else {
					putImageInLabel(Constant.ICON_GROUP_DEFAULT, lblGroups_GroupCreate_GroupPicture);
				}
			}
		}
	}

	public void refreshGroupMembers(TransferClass tc) {
		GroupMembers ttgr = (GroupMembers) tc.getServerObject();
		if (ttgr.getIdUser() == currentUser.getIdUser()
				|| allGroupsHM.get(ttgr.getGroupName()).getGroupCreatorId() == currentUser.getIdUser()) {
		}
		if (tc.getOperation() == Constant.GROUPMEMBERS_CREATED) {
			GroupMembers tempGroupMember = (GroupMembers) tc.getServerObject();
			listOfGroupMembers.add(tempGroupMember);
			fillGroupPanel();
			viewGroupInfo();
			if (tempGroupMember.getIdUser() == currentUser.getIdUser()) {
				DefaultListModel<Object> dlmTempChat = (DefaultListModel<Object>) listGroupMsg_ListGroupChats
						.getModel();
				GroupChatEntry groupChat = new GroupChatEntry(tempGroupMember.getGroupName());
				dlmTempChat.insertElementAt(groupChat, 0);
			}
		} else if (tc.getOperation() == Constant.GROUPMEMBERS_ASKTOJOIN) {
			GroupMembers tempGroupMember = (GroupMembers) tc.getServerObject();
			listOfGroupMembers.add(tempGroupMember);
			fillGroupPanel();
			viewGroupInfo();
		} else if (tc.getOperation() == Constant.GROUPMEMBERS_CANCELREQUEST) {
			GroupMembers tempGroupMember = (GroupMembers) tc.getServerObject();
			GroupMembers tempForDelete = null;
			for (GroupMembers temp : listOfGroupMembers) {
				if (temp.getIdUser() == tempGroupMember.getIdUser()
						&& temp.getGroupName().equals(tempGroupMember.getGroupName())) {
					tempForDelete = temp;
					break;
				}
			}
			listOfGroupMembers.remove(tempForDelete);
			fillGroupPanel();
			viewGroupInfo();
		} else if (tc.getOperation() == Constant.GROUPMEMBERS_ACCEPTEDMEMBERSHIP) {
			GroupMembers grMem = (GroupMembers) tc.getServerObject();
			for (GroupMembers temp : listOfGroupMembers) {
				if (temp.getIdUser() == grMem.getIdUser() && temp.getGroupName().equals(grMem.getGroupName())) {
					temp.setDateOfJoin(grMem.getDateOfJoin());
					temp.setTimeOfJoin(grMem.getTimeOfJoin());
					temp.setTypeOfMember(grMem.getTypeOfMember());
					break;
				}
			}
			fillGroupPanel();
			viewGroupInfo();
			if (grMem.getIdUser() == currentUser.getIdUser()) {
				DefaultListModel<Object> dlmTempChat = (DefaultListModel<Object>) listGroupMsg_ListGroupChats
						.getModel();
				GroupChatEntry groupChat = new GroupChatEntry(grMem.getGroupName());
				dlmTempChat.insertElementAt(groupChat, 0);
			}
		} else if (tc.getOperation() == Constant.GROUPMEMBERS_DECLINEDMEMBERSHIP) {
			GroupMembers grMem = (GroupMembers) tc.getServerObject();
			GroupMembers tempForDelete = null;
			for (GroupMembers temp : listOfGroupMembers) {
				if (temp.getIdUser() == grMem.getIdUser() && temp.getGroupName().equals(grMem.getGroupName())) {
					tempForDelete = temp;
					break;
				}
			}
			listOfGroupMembers.remove(tempForDelete);
			fillGroupPanel();
			viewGroupInfo();
		} else if (tc.getOperation() == Constant.GROUPMEMBERS_KICKED) {
			GroupMembers grMem = (GroupMembers) tc.getServerObject();
			GroupMembers tempForDelete = null;
			for (GroupMembers temp : listOfGroupMembers) {
				if (temp.getIdUser() == grMem.getIdUser() && temp.getGroupName().equals(grMem.getGroupName())) {
					tempForDelete = temp;
					break;
				}
			}

			listOfGroupMembers.remove(tempForDelete);
			fillGroupPanel();
			viewGroupInfo();
		}
	}

	public void refreshGroupsGroupCreated(Object serverObject) {
		Groups gr = (Groups) serverObject;
		allGroupsHM.put(gr.getGroupName(), gr);
		fillGroupPanel();

	}

	private void searchGroups(String tempString) {
		DefaultListModel<Object> dlmGroupSearch = new DefaultListModel<>();
		for (Entry<String, Groups> tempGroup : allGroupsHM.entrySet()) {
			Groups temp = tempGroup.getValue();
			if (temp.getGroupName().toLowerCase().contains(tempString.toLowerCase())) {
				String pathGroupImage;
				if (temp.getGroupPictureURL().contains(temp.getGroupName())) {
					pathGroupImage = Constant.GROUP_PICTURE + currentUser.getUsername() + "/"
							+ temp.getGroupPictureURL();
				} else {
					pathGroupImage = Constant.ICON_GROUP_DEFAULT;
				}
				ListGroupEntry lge = new ListGroupEntry(temp, pathGroupImage);
				dlmGroupSearch.addElement(lge);
			}
		}

		if (dlmGroupSearch.size() != 0) {
			spGroups_GroupSearch.setVisible(true);
		}
		listGroups_GroupSearch.setModel(dlmGroupSearch);
		listGroups_GroupSearch.setCellRenderer(new ListGroupEntryRenderer());
	}

	private void viewGroupInfo() {
		btnGroups_GroupInfo_One.setVisible(true);
		btnGroups_GroupInfo_Two.setVisible(true);
		btnGroups_GroupInfo_Three.setVisible(true);
		btnGroups_GroupInfo_Four.setVisible(true);
		panelGroups_GroupInfo.setVisible(false);
		panelGroups_GroupCreate.setVisible(false);
		btnGroups_CreateNewGroup.setVisible(true);

		if (selectedGroupGrPanel != null) {
			panelGroups_GroupInfo.setVisible(true);
			if (selectedGroupGrPanel.getGroupCreatorId() == currentUser.getIdUser()) {
				btnGroups_GroupInfo_One.setText(Constant.BUTTON_GROUP_KICKFROMGROUP);
				btnGroups_GroupInfo_Two.setText(Constant.BUTTON_GROUP_DECLINETOGROUP);
				btnGroups_GroupInfo_Three.setText(Constant.BUTTON_GROUP_ACCEPTINTOGROUP);
				btnGroups_GroupInfo_Four.setText(Constant.BUTTON_GROUP_SENDMESSAGE);
				lblGroups_GroupInfo_Title3.setVisible(true);
			} else {
				btnGroups_GroupInfo_One.setText(Constant.BUTTON_GROUP_ASKTOJOIN);
				btnGroups_GroupInfo_Four.setVisible(false);
				btnGroups_GroupInfo_Two.setVisible(false);
				btnGroups_GroupInfo_Three.setVisible(false);
				lblGroups_GroupInfo_Title3.setVisible(false);
				for (GroupMembers temp : listOfGroupMembers) {

					if (temp.getGroupName().equals(selectedGroupGrPanel.getGroupName())
							&& temp.getIdUser() == currentUser.getIdUser()) {
						if (temp.getTypeOfMember().equals("member")) {
							btnGroups_GroupInfo_One.setText(Constant.BUTTON_GROUP_LEAVE);
							btnGroups_GroupInfo_Four.setVisible(true);
							btnGroups_GroupInfo_Four.setText(Constant.BUTTON_GROUP_SENDMESSAGE);
						} else if (temp.getTypeOfMember().equals("asktojoin")) {
							btnGroups_GroupInfo_One.setText(Constant.BUTTON_GROUP_CANCELREQUST);
						}
					}
				}
			}

			DefaultListModel<Object> dlmMembers = new DefaultListModel<>();
			DefaultListModel<Object> dlmRequests = new DefaultListModel<>();
			for (GroupMembers temp : listOfGroupMembers) {
				if (temp.getGroupName().equals(selectedGroupGrPanel.getGroupName())) {
					if (temp.getTypeOfMember().equals("admin")) {
						ListUsersEntry lue = new ListUsersEntry(allUsersHM.get(temp.getIdUser()),
								Constant.ICON_USER_GROUP_ADMIN);
						dlmMembers.add(0, lue);
					} else if (temp.getTypeOfMember().equals("member")) {
						ListUsersEntry lue = new ListUsersEntry(allUsersHM.get(temp.getIdUser()),
								Constant.ICON_USER_GROUP_MEMBER);
						dlmMembers.addElement(lue);
					} else if (temp.getTypeOfMember().equals("asktojoin")) {
						ListUsersEntry lue = new ListUsersEntry(allUsersHM.get(temp.getIdUser()),
								Constant.ICON_USER_GROUP_SENT_REQUEST);
						dlmRequests.addElement(lue);
					}
				}
			}
			listGroups_GroupInfo_Members.setModel(dlmMembers);
			listGroups_GroupInfo_Members.setCellRenderer(new ListUsersEntryRenderer());
			listGroups_GroupInfo_GroupMemberRequests.setModel(dlmRequests);
			listGroups_GroupInfo_GroupMemberRequests.setCellRenderer(new ListUsersEntryRenderer());
			String name = "GROUP NAME: " + selectedGroupGrPanel.getGroupName();
			lblGroups_GroupInfo_Name.setText(name);
			taGroups_GroupInfo_Info.setText(selectedGroupGrPanel.getGroupInfo());
			String text = "Created by " + allUsersHM.get(selectedGroupGrPanel.getGroupCreatorId()) + ", at "
					+ convertStringIntoDateAndPutInLabel(selectedGroupGrPanel.getDateOfCreation());
			lblGroups_GroupInfo_Title.setText(text);

			if (selectedGroupGrPanel.getGroupPictureURL().contains(selectedGroupGrPanel.getGroupName())) {
				File f = new File(Constant.GROUP_PICTURE + currentUser.getUsername() + "/"
						+ selectedGroupGrPanel.getGroupPictureURL());
				if (f.exists()) {
					putImageInLabel(Constant.GROUP_PICTURE + currentUser.getUsername() + "/"
							+ selectedGroupGrPanel.getGroupPictureURL(), lblGroups_GroupInfo_GroupPicture);
				} else {
					TransferClass tcAskForGroupPicture = new TransferClass();
					tcAskForGroupPicture.setClientObject(selectedGroupGrPanel.getGroupPictureURL());
					tcAskForGroupPicture.setOperation(Constant.ASK_FOR_GROUP_PICTURE);
					Communication.getInstance().sendData(tcAskForGroupPicture);
				}
			} else {
				putImageInLabel(Constant.ICON_GROUP_DEFAULT, lblGroups_GroupInfo_GroupPicture);
			}

			spGroups_GroupInfo_MembersRequests.setVisible(false);
			if (selectedGroupGrPanel.getGroupCreatorId() == currentUser.getIdUser()) {
				spGroups_GroupInfo_MembersRequests.setVisible(true);
			}
		}

	}

	// PRIVATE MESSAGES

	@SuppressWarnings({ "unchecked" })
	private void fillPrivateMessagesPanel() {
		User tempSelectedChatUser;
		numberOfNewMessages = 0;
		DefaultListModel<Object> dlmPrivateChat = (DefaultListModel<Object>) listMsg_PrivateMessage.getModel();

		for (PrivateMessage tempPrivateMessage : listOfPrivateMessages) {

			if (tempPrivateMessage.getUserOneId() == currentUser.getIdUser()) {
				tempSelectedChatUser = allUsersHM.get(tempPrivateMessage.getUserTwoId());
			} else {
				tempSelectedChatUser = allUsersHM.get(tempPrivateMessage.getUserOneId());
			}

			boolean isUserInChat = false;
			int userIndexInChat = 0;
			PrivateChatEntry privateChat;

			for (int i = 0; i < dlmPrivateChat.size(); i++) {
				privateChat = (PrivateChatEntry) dlmPrivateChat.getElementAt(i);
				if (privateChat.getChatUserId() == tempSelectedChatUser.getIdUser()) {
					isUserInChat = true;
					userIndexInChat = i;
					break;
				}
			}

			if (isUserInChat) {
				privateChat = (PrivateChatEntry) dlmPrivateChat.getElementAt(userIndexInChat);
				dlmPrivateChat.removeElementAt(userIndexInChat);
			} else {
				privateChat = new PrivateChatEntry(tempSelectedChatUser.getIdUser(), tempSelectedChatUser.toString());
			}
			dlmPrivateChat.insertElementAt(privateChat, 0);

			if (currentUser.getIdUser() == tempPrivateMessage.getSenderId()) {
				privateChat.getStringBuff().append("\n" + "<<<< Me >>>> :" + tempPrivateMessage.getMessageBody());
				privateChat.setSentMessageStatus(tempPrivateMessage.getMessageStatus());
				lblMsg_SentStatus.setText(tempPrivateMessage.getMessageStatus());
			} else {
				if (tempPrivateMessage.getMessageStatus().equals(Constant.MESSAGE_PENDING)) {
					tempPrivateMessage.setMessageStatus(Constant.MESSAGE_DELIVERED);
					String receivedDate = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
					String receivedTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
					tempPrivateMessage.setReceivedDate(receivedDate);
					tempPrivateMessage.setReceivedTime(receivedTime);
					TransferClass tc = new TransferClass();
					tc.setOperation(Constant.MESSAGE_DELIVERED_OPERATION);
					tc.setClientObject(tempPrivateMessage);
					Communication.getInstance().sendData(tc);
					numberOfNewMessages++;
					privateChat.setReceivedMessageSeen(false);
					privateChat.setNewMessage();
				} else if (tempPrivateMessage.getMessageStatus().equals(Constant.MESSAGE_DELIVERED)) {
					numberOfNewMessages++;
					privateChat.setReceivedMessageSeen(false);
					privateChat.setNewMessage();
				} else if (tempPrivateMessage.getMessageStatus().equals(Constant.MESSAGE_SEEN)) {
					privateChat.setReceivedMessageSeen(true);
				}
				privateChat.getStringBuff()
						.append("\n" + tempSelectedChatUser.getLastName() + " :" + tempPrivateMessage.getMessageBody());
				privateChat.setReceivedMessageStatus(
						tempPrivateMessage.getReceivedDate() + " " + tempPrivateMessage.getReceivedTime());
				lblMsg_MessageRecievedAt.setText(privateChat.getReceivedMessageStatus());

			}
		}
		listMsg_PrivateMessage.setModel(dlmPrivateChat);
		listMsg_PrivateMessage.setCellRenderer(new PrivateChateEntryRenderer());
		if (numberOfNewMessages != 0) {
			String temp = "Messages (" + numberOfNewMessages + ")";
			btnMessages.setText(temp);
			btnMessages.setForeground(Color.RED);
		} else {
			String temp = "Messages";
			btnMessages.setText(temp);
			btnMessages.setForeground(Color.BLACK);
		}
	}

	public void refreshMsgForm(PrivateMessage pm) {
		User tempSelectedChatUser;
		DefaultListModel<Object> dlmPrivateChat = (DefaultListModel<Object>) listMsg_PrivateMessage.getModel();

		if (pm.getUserOneId() == currentUser.getIdUser()) {
			tempSelectedChatUser = allUsersHM.get(pm.getUserTwoId());
		} else {
			tempSelectedChatUser = allUsersHM.get(pm.getUserOneId());
		}

		boolean isUserInChat = false;
		int userIndexInChat = 0;
		PrivateChatEntry privateChat;

		for (int i = 0; i < dlmPrivateChat.size(); i++) {
			privateChat = (PrivateChatEntry) dlmPrivateChat.getElementAt(i);
			if (privateChat.getChatUserId() == tempSelectedChatUser.getIdUser()) {
				isUserInChat = true;
				userIndexInChat = i;
				break;
			}
		}

		if (isUserInChat) {
			privateChat = (PrivateChatEntry) dlmPrivateChat.getElementAt(userIndexInChat);
			dlmPrivateChat.removeElementAt(userIndexInChat);
		} else {
			privateChat = new PrivateChatEntry(tempSelectedChatUser.getIdUser(), tempSelectedChatUser.toString());
		}
		dlmPrivateChat.insertElementAt(privateChat, 0);
		if (currentUser.getIdUser() == pm.getSenderId()) {
			privateChat.getStringBuff().append("\n" + "<<<< Me >>>> :" + pm.getMessageBody());
			privateChat.setSentMessageStatus(pm.getMessageStatus());
			lblMsg_SentStatus.setText(pm.getMessageStatus());
			taMsg_PrivateMessageChat.setText(privateChat.getStringBuff().toString());
		} else {
			if (pm.getMessageStatus().equals(Constant.MESSAGE_PENDING)) {
				pm.setMessageStatus(Constant.MESSAGE_DELIVERED);
				String receivedDate = new SimpleDateFormat("YYYY-MM-dd").format(new Date());
				String receivedTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
				pm.setReceivedDate(receivedDate);
				pm.setReceivedTime(receivedTime);
				TransferClass tc = new TransferClass();
				tc.setOperation(Constant.MESSAGE_DELIVERED_OPERATION);
				tc.setClientObject(pm);
				Communication.getInstance().sendData(tc);
				numberOfNewMessages++;
				privateChat.setReceivedMessageSeen(false);
				privateChat.setNewMessage();
			} else if (pm.getMessageStatus().equals(Constant.MESSAGE_DELIVERED)) {
				numberOfNewMessages++;
				privateChat.setReceivedMessageSeen(false);
				privateChat.setNewMessage();
			} else if (pm.getMessageStatus().equals(Constant.MESSAGE_SEEN)) {
				privateChat.setReceivedMessageSeen(true);
			}
			privateChat.getStringBuff().append("\n" + tempSelectedChatUser.getLastName() + " :" + pm.getMessageBody());
			privateChat.setReceivedMessageStatus(pm.getReceivedDate() + " " + pm.getReceivedTime());
			if (selectedChatUser != null && privateChat.getChatUserId() == selectedChatUser.getIdUser()) {
				lblMsg_MessageRecievedAt.setText(privateChat.getReceivedMessageStatus());
			}
		}
		listMsg_PrivateMessage.setModel(new DefaultListModel<>());
		listMsg_PrivateMessage.setModel(dlmPrivateChat);
		if (selectedChatUser != null) {
			if (selectedChatUser.getIdUser() == privateChat.getChatUserId()) {
				listMsg_PrivateMessage.setSelectedIndex(0);
				taMsg_PrivateMessageChat.setText(privateChat.getStringBuff().toString());
			} else {
				int selectedChatUserIndex = 0;
				for (int i = 0; i < dlmPrivateChat.size(); i++) {
					privateChat = (PrivateChatEntry) dlmPrivateChat.getElementAt(i);
					if (privateChat.getChatUserId() == selectedChatUser.getIdUser()) {
						selectedChatUserIndex = i;
						break;
					}
				}
				listMsg_PrivateMessage.setSelectedIndex(selectedChatUserIndex);
				taMsg_PrivateMessageChat.setText(privateChat.getStringBuff().toString());
			}
		}
		if (numberOfNewMessages != 0) {
			String temp = "Messages (" + numberOfNewMessages + ")";
			btnMessages.setText(temp);
			btnMessages.setForeground(Color.RED);
		} else {
			String temp = "Messages";
			btnMessages.setText(temp);
			btnMessages.setForeground(Color.BLACK);
		}
	}

	public void refreshMsgStatus(PrivateMessage pm1) {

		int id = -1;
		if (pm1.getSenderId() == pm1.getUserOneId()) {
			id = pm1.getUserTwoId();
		} else {
			id = pm1.getUserOneId();
		}
		DefaultListModel<Object> dlmTemp = new DefaultListModel<>();
		dlmTemp = (DefaultListModel<Object>) listMsg_PrivateMessage.getModel();
		for (int i = 0; i < dlmTemp.size(); i++) {
			PrivateChatEntry privateChat = (PrivateChatEntry) dlmTemp.getElementAt(i);
			if (privateChat.getChatUserId() == id) {
				privateChat.setSentMessageStatus(pm1.getMessageStatus());
				if (selectedChatUser != null && selectedChatUser.getIdUser() == id) {
					lblMsg_SentStatus.setText(pm1.getMessageStatus());
				}
				break;
			}
		}

	}

	// FRIENDS/PEOPLE PANEL

	private void fillPeoplePanel() {
		numberOfNewFriendRequests = 0;
		listOfMyFriends = new ArrayList<>();
		listOfBlockedUsers = new ArrayList<>();
		listBlockByUsers = new ArrayList<>();
		listOfSentRequests = new ArrayList<>();
		listOfRecievedRequests = new ArrayList<>();

		for (Friends fr : listFriendRelation) {
			if (fr.getUserOneId() == currentUser.getIdUser()) {
				switch (fr.getActionStatus()) {
				case Constant.FRIEND_REQUEST_SENT:
					if (currentUser.getIdUser() == fr.getActionUserId()) {
						User tempUser = allUsersHM.get(fr.getUserTwoId());
						listOfSentRequests.add(tempUser);
					} else {
						User tempUser = allUsersHM.get(fr.getUserTwoId());
						listOfRecievedRequests.add(tempUser);
						numberOfNewFriendRequests++;
					}
					break;
				case Constant.FRIEND_REQUEST_RECIEVED:

					break;
				case Constant.FRIEND_REQUEST_ACCEPTED:
					User tempUser = allUsersHM.get(fr.getUserTwoId());
					listOfMyFriends.add(tempUser);
					break;
				case Constant.FRIEND_REQUEST_BLOCK_FRIEND:
					if (currentUser.getIdUser() == fr.getActionUserId()) {
						User tempUser1 = allUsersHM.get(fr.getUserTwoId());
						listOfBlockedUsers.add(tempUser1);
					} else {
						User tempUser1 = allUsersHM.get(fr.getUserTwoId());
						listBlockByUsers.add(tempUser1);
					}
					break;
				case Constant.FRIEND_REQUEST_BLOCK_NON_FRIEND:
					if (currentUser.getIdUser() == fr.getActionUserId()) {
						User tempUser1 = allUsersHM.get(fr.getUserTwoId());
						listOfBlockedUsers.add(tempUser1);
					} else {
						User tempUser1 = allUsersHM.get(fr.getUserTwoId());
						listBlockByUsers.add(tempUser1);
					}
					break;
				default:
					break;
				}
			} else if (fr.getUserTwoId() == currentUser.getIdUser()) {
				switch (fr.getActionStatus()) {
				case Constant.FRIEND_REQUEST_SENT:
					if (currentUser.getIdUser() == fr.getActionUserId()) {
						User tempUser = allUsersHM.get(fr.getUserOneId());
						listOfSentRequests.add(tempUser);
					} else {
						User tempUser = allUsersHM.get(fr.getUserOneId());
						listOfRecievedRequests.add(tempUser);
						numberOfNewFriendRequests++;
					}
					break;
				case Constant.FRIEND_REQUEST_RECIEVED:

					break;
				case Constant.FRIEND_REQUEST_ACCEPTED:
					User tempUser = allUsersHM.get(fr.getUserOneId());
					listOfMyFriends.add(tempUser);
					break;
				case Constant.FRIEND_REQUEST_BLOCK_FRIEND:
					if (currentUser.getIdUser() == fr.getActionUserId()) {
						User tempUser1 = allUsersHM.get(fr.getUserOneId());
						listOfBlockedUsers.add(tempUser1);
					} else {
						User tempUser1 = allUsersHM.get(fr.getUserOneId());
						listBlockByUsers.add(tempUser1);
					}
					break;
				case Constant.FRIEND_REQUEST_BLOCK_NON_FRIEND:
					if (currentUser.getIdUser() == fr.getActionUserId()) {
						User tempUser1 = allUsersHM.get(fr.getUserOneId());
						listOfBlockedUsers.add(tempUser1);
					} else {
						User tempUser1 = allUsersHM.get(fr.getUserOneId());
						listBlockByUsers.add(tempUser1);
					}
					break;
				default:
					break;
				}
			}
		}
		int onlinePosition = 0;
		DefaultListModel<Object> dlmTemp = new DefaultListModel<>();
		Collections.sort(listOfMyFriends, new MyComparatorUser());
		for (User temp : listOfMyFriends) {
			String status = "offline";
			if (listOfActiveUsers.contains(temp.getIdUser())) {
				status = "online";
				ListUsersEntry lue = new ListUsersEntry(temp, status);
				dlmTemp.insertElementAt(lue, onlinePosition++);
			} else {
				ListUsersEntry lue = new ListUsersEntry(temp, status);
				dlmTemp.addElement(lue);
			}
		}
		listPeople_FriendsList.setCellRenderer(new ListUsersEntryRenderer());
		listPeople_FriendsList.setModel(dlmTemp);

		listMsg_FriendList.setModel(dlmTemp);
		listMsg_FriendList.setCellRenderer(new ListUsersEntryRenderer());

		dlmTemp = new DefaultListModel<>();
		for (User temp : listOfRecievedRequests) {
			String status = "recieved";
			ListUsersEntry lue = new ListUsersEntry(temp, status);
			dlmTemp.addElement(lue);
		}
		listPeople_NewFriendRequests.setModel(dlmTemp);
		listPeople_NewFriendRequests.setCellRenderer(new ListUsersEntryRenderer());

		dlmTemp = new DefaultListModel<>();
		for (User temp : listOfSentRequests) {
			String status = "sent";
			ListUsersEntry lue = new ListUsersEntry(temp, status);
			dlmTemp.addElement(lue);
		}
		listPeople_SentRequests.setModel(dlmTemp);
		listPeople_SentRequests.setCellRenderer(new ListUsersEntryRenderer());
		if (numberOfNewFriendRequests != 0) {
			btnPeople.setForeground(Color.RED);
			String ppl = "People (+" + numberOfNewFriendRequests + ")";
			btnPeople.setText(ppl);
		} else {
			btnPeople.setForeground(Color.BLACK);
			btnPeople.setText("People");
		}
	}

	public void refreshFriendRelations(Friends newFr) {
		numberOfNewFriendRequests = 0;
		if (newFr.getActionStatus() == Constant.FRIEND_REQUEST_SENT) {
			listFriendRelation.add(newFr);
		} else if (newFr.getActionStatus() == Constant.FRIEND_REQUEST_ACCEPTED) {
			for (Friends f : listFriendRelation) {
				if ((newFr.getUserOneId() == f.getUserOneId() && newFr.getUserTwoId() == f.getUserTwoId())
						|| (newFr.getUserOneId() == f.getUserTwoId() && newFr.getUserTwoId() == f.getUserOneId())) {
					f.setActionStatus(newFr.getActionStatus());
				}
			}
		} else if (newFr.getActionStatus() == Constant.FRIEND_REQUEST_DECLINED) {
			Friends tempFriend = null;
			for (Friends f : listFriendRelation) {
				if ((newFr.getUserOneId() == f.getUserOneId() && newFr.getUserTwoId() == f.getUserTwoId())
						|| (newFr.getUserOneId() == f.getUserTwoId() && newFr.getUserTwoId() == f.getUserOneId())) {
					tempFriend = f;
				}
			}
			listFriendRelation.remove(tempFriend);
		} else if (newFr.getActionStatus() == Constant.FRIEND_REQUEST_BLOCK_FRIEND) {
			for (Friends f : listFriendRelation) {
				if ((newFr.getUserOneId() == f.getUserOneId() && newFr.getUserTwoId() == f.getUserTwoId())
						|| (newFr.getUserOneId() == f.getUserTwoId() && newFr.getUserTwoId() == f.getUserOneId())) {
					f.setActionUserId(newFr.getActionUserId());
					f.setActionStatus(newFr.getActionStatus());
				}
			}
		} else if (newFr.getActionStatus() == Constant.FRIEND_REQUEST_BLOCK_NON_FRIEND) {
			listFriendRelation.add(newFr);
		}

		listBlockByUsers = new ArrayList<>();
		listOfBlockedUsers = new ArrayList<>();
		fillPeoplePanel();
		viewProfile();
		if (numberOfNewFriendRequests != 0) {
			btnPeople.setForeground(Color.RED);
			String ppl = "People (+" + numberOfNewFriendRequests + ")";
			btnPeople.setText(ppl);
		} else {
			btnPeople.setForeground(Color.BLACK);
			btnPeople.setText("People");
		}
	}

	private void searchPeople(String tempString) {
		hm.get(Constant.ALL_USERS_LIST);
		dlmSearchResult.removeAllElements();
		tempString = tempString.toLowerCase();
		DefaultListModel<Object> dlmTemp = new DefaultListModel<>();
		for (Entry<Integer, User> temp : allUsersHM.entrySet()) {
			User temUser = temp.getValue();
			String username = temp.getValue().getUsername().toLowerCase();
			String firstName = temp.getValue().getFirstName().toLowerCase();
			String lastName = temp.getValue().getLastName().toLowerCase();
			if (temUser.getIdUser() == currentUser.getIdUser()) {
				continue;
			}
			if ((!temUser.getTypeOfUser().equals("admin")) && ((username.contains(tempString))
					|| (firstName.contains(tempString)) || (lastName.contains(tempString)))) {
				if (!listBlockByUsers.contains(temUser)) {
					String status = "";
					if (listOfBlockedUsers.contains(temUser)) {
						status = "blocked";
					} else if (listOfSentRequests.contains(temUser)) {
						status = "sent";
					} else if (listOfRecievedRequests.contains(temUser)) {
						status = "recieved";
					} else if (listOfMyFriends.contains(temUser) && listOfActiveUsers.contains(temUser.getIdUser())) {
						status = "online";
					} else if (listOfMyFriends.contains(temUser)) {
						status = "offline";
					} else {
						status = "notfriend";
					}
					ListUsersEntry lue = new ListUsersEntry(temUser, status);
					dlmTemp.addElement(lue);
				}
			}
		}
		listPeople_SearchResult.setModel(dlmTemp);
		listPeople_SearchResult.setCellRenderer(new ListUsersEntryRenderer());
	}

	private void viewProfile() {
		if (selectedUser == null) {
			panelPeople_ProfileInfo.setVisible(false);
		} else {
			panelPeople_ProfileInfo.setVisible(true);
			btnPeople_ProfileInfo_One.setVisible(true);
			btnPeople_ProfileInfo_Two.setVisible(true);
			btnPeople_ProfileInfo_Three.setVisible(false);
			if (listOfMyFriends.contains(selectedUser)) {
				btnPeople_ProfileInfo_One.setText(Constant.BUTTON_UNFRIEND);
				btnPeople_ProfileInfo_Two.setText(Constant.BUTTON_BLOCK_USER);
				btnPeople_ProfileInfo_Three.setVisible(true);
				btnPeople_ProfileInfo_Three.setText("Send message");
			} else if (listOfRecievedRequests.contains(selectedUser)) {
				btnPeople_ProfileInfo_One.setText(Constant.BUTTON_ACCEPT_REQUEST);
				btnPeople_ProfileInfo_Two.setText(Constant.BUTTON_DECLINE_REQUEST);
			} else if (listOfSentRequests.contains(selectedUser)) {
				btnPeople_ProfileInfo_One.setText(Constant.BUTTON_CANCEL_REQUEST);
				btnPeople_ProfileInfo_Two.setText(Constant.BUTTON_BLOCK_USER);
			} else if (listOfBlockedUsers.contains(selectedUser)) {
				btnPeople_ProfileInfo_One.setText(Constant.BUTTON_UNBLOCK_REQUEST);
				btnPeople_ProfileInfo_Two.setVisible(false);
			} else if (listBlockByUsers.contains(selectedUser)) {
				btnPeople_ProfileInfo_One.setVisible(false);
				btnPeople_ProfileInfo_Two.setVisible(false);
				panelPeople_ProfileInfo.setVisible(false);
			} else {
				btnPeople_ProfileInfo_One.setText(Constant.BUTTON_ADD_FRIEND + " " + selectedUser.getFirstName());
				btnPeople_ProfileInfo_Two.setText(Constant.BUTTON_BLOCK_USER);
			}
			if (listOfMyFriends.contains(selectedUser) && listOfActiveUsers.contains(selectedUser.getIdUser())) {
				panelPeople_ProfileInfo_ProfilePicture.setBackground(new Color(0, 255, 0));
			} else if (listOfMyFriends.contains(selectedUser)) {
				panelPeople_ProfileInfo_ProfilePicture.setBackground(new Color(240, 240, 240));
			} else if (listOfBlockedUsers.contains(selectedUser)) {
				panelPeople_ProfileInfo_ProfilePicture.setBackground(Color.RED);
			} else {
				panelPeople_ProfileInfo_ProfilePicture.setBackground(Color.WHITE);
			}

			if (listOfMyFriends.contains(selectedUser)) {
				if (selectedUser.getProfilePictureURL().contains(selectedUser.getUsername())) {
					File f = new File(Constant.PROFILE_PICTURE + currentUser.getUsername() + "/"
							+ selectedUser.getProfilePictureURL());
					if (f.exists()) {
						putImageInLabel(f.getPath(), lblPeople_ProfileInfo_ProfilePicture);
					} else {
						TransferClass tcAskForPicture = new TransferClass();
						tcAskForPicture.setOperation(Constant.ASK_FOR_FRIEND_PROFILE_PICTURE);
						tcAskForPicture.setClientObject(selectedUser.getProfilePictureURL());
						Communication.getInstance().sendData(tcAskForPicture);
					}
				} else {
					if (selectedUser.getGender().equalsIgnoreCase("female")) {
						putImageInLabel(Constant.PROFILE_PICTURE + "female.jpg", lblPeople_ProfileInfo_ProfilePicture);
					} else if (selectedUser.getGender().equalsIgnoreCase("male")) {
						putImageInLabel(Constant.PROFILE_PICTURE + "male.jpg", lblPeople_ProfileInfo_ProfilePicture);
					}
				}

			} else {
				if (selectedUser.getGender().equalsIgnoreCase("female")) {
					putImageInLabel(Constant.PROFILE_PICTURE + "female.jpg", lblPeople_ProfileInfo_ProfilePicture);
				} else if (selectedUser.getGender().equalsIgnoreCase("male")) {
					putImageInLabel(Constant.PROFILE_PICTURE + "male.jpg", lblPeople_ProfileInfo_ProfilePicture);
				}
			}
			lblPeople_ProfileInfo_LastNameFirstName
					.setText(selectedUser.getLastName() + " " + selectedUser.getFirstName());
			lblPeople_ProfileInfo_DateOfRegistration.setText(
					"Registered since " + convertStringIntoDateAndPutInLabel(selectedUser.getDateOfRegistration()));
			lblPeople_ProfileInfo_DateOfBirth
					.setText("Date of birth : " + convertStringIntoDateAndPutInLabel(selectedUser.getDateOfBirth()));
			lblPeople_ProfileInfo_Education.setText("Education " + selectedUser.getEducation());
			lblPeople_ProfileInfo_WorkPlace.setText("Workplace " + selectedUser.getWorkplace());
			lblPeople_ProfileInfo_TownCountry
					.setText("Curently in " + selectedUser.getTown() + ", " + selectedUser.getCountry());
			lblPeople_ProfileInfo_TownCountry
					.setIcon(new ImageIcon(Constant.COUNTRY_PICTURES + selectedUser.getCountry() + ".png"));
			lblPeople_ProfileInfo_TownCountry.setVerticalTextPosition(JLabel.CENTER);
			lblPeople_ProfileInfo_TownCountry.setHorizontalTextPosition(JLabel.LEFT);
			lblPeople_ProfileInfo_Gender.setText("Gender " + selectedUser.getGender());
			taProfile_ProfileInfo_AboutMe.setText(selectedUser.getAboutMe());
			taProfile_ProfileInfo_AboutMe.setEditable(false);
			lblPeople_ProfileInfo_Username.setText(selectedUser.getUsername() + "'s profile");
			lblPeople_ProfileInfo_Email.setText("Email: " + selectedUser.getEmail());

		}
	}

	public boolean isThereFriendRelation(Friends fr) {
		for (Friends tempFr : listFriendRelation) {
			if ((fr.getUserOneId() == tempFr.getUserOneId() && fr.getUserTwoId() == tempFr.getUserTwoId())
					|| (fr.getUserOneId() == tempFr.getUserTwoId() && fr.getUserTwoId() == tempFr.getUserOneId())) {
				return true;
			}
		}
		return false;
	}

//	Profil panel
	
	private void fillProfilePanel() {
		User curentUser = (User) hm.get(Constant.CURRENT_USER);

		if (curentUser.getProfilePictureURL().contains(curentUser.getUsername())) {
			ImageIcon img1 = new ImageIcon(
					Constant.PROFILE_PICTURE + currentUser.getUsername() + "/" + currentUser.getProfilePictureURL());

			img1.getImage().flush();
			Image image = img1.getImage().getScaledInstance(lblProfile_ProfilePicture.getWidth(),
					lblProfile_ProfilePicture.getHeight(), Image.SCALE_SMOOTH);
			lblProfile_ProfilePicture.setIcon(new ImageIcon(image));

		} else {
			if (curentUser.getGender().equalsIgnoreCase("female")) {
				putImageInLabel(Constant.PROFILE_PICTURE + "female.jpg", lblProfile_ProfilePicture);
			} else if (curentUser.getGender().equalsIgnoreCase("male")) {
				putImageInLabel(Constant.PROFILE_PICTURE + "male.jpg", lblProfile_ProfilePicture);
			}
		}

		String text;
		text = curentUser.getLastName() + " " + curentUser.getFirstName();
		lblProfile_LastnameFirstname.setText(text);
		text = "Registered since " + convertStringIntoDateAndPutInLabel(curentUser.getDateOfRegistration());
		lblProfile_DateOfRegistration.setText(text);
		text = "Date of birth : " + convertStringIntoDateAndPutInLabel(curentUser.getDateOfBirth());
		lblProfile_DateOfBirth.setText(text);
		text = "Currently in " + curentUser.getTown() + ", " + curentUser.getCountry();
		lblProfile_TownCountry.setText(text);
		lblProfile_TownCountry.setIcon(new ImageIcon(Constant.COUNTRY_PICTURES + curentUser.getCountry() + ".png"));
		lblProfile_TownCountry.setVerticalTextPosition(JLabel.CENTER);
		lblProfile_TownCountry.setHorizontalTextPosition(JLabel.LEFT);
		taProfile_AboutMe.setText(curentUser.getAboutMe());
		taProfile_AboutMe.setEditable(false);
		text = curentUser.getUsername() + "'s profile:";
		lblProfile_Username.setText(text);
		text = "Workplace: " + curentUser.getWorkplace();
		lblProfile_Workplace.setText(text);
		text = "Education: " + curentUser.getEducation();
		lblProfile_Education.setText(text);
		text = "Gender: " + curentUser.getGender();
		lblProfile_Gender.setText(text);
		text = "Email: " + curentUser.getEmail();
		lblProfile_Email.setText(text);
	}

	private void showHome() {
		panelHome.setVisible(true);
		panelProfile.setVisible(false);
		panelPeople.setVisible(false);
		panelMessages.setVisible(false);
		panelGroups.setVisible(false);
		panelGroupMessages.setVisible(false);
		panelEditProfile.setVisible(false);
		fillHomePanel();
	}

	private void showProfile() {
		panelHome.setVisible(false);
		panelProfile.setVisible(true);
		panelPeople.setVisible(false);
		panelMessages.setVisible(false);
		panelGroups.setVisible(false);
		panelGroupMessages.setVisible(false);
		panelEditProfile.setVisible(false);
	}

	private void showPeople() {
		panelHome.setVisible(false);
		panelProfile.setVisible(false);
		panelPeople.setVisible(true);
		panelMessages.setVisible(false);
		panelGroups.setVisible(false);
		panelGroupMessages.setVisible(false);
		panelEditProfile.setVisible(false);
		spPeople_SearchResult.setVisible(false);
		tfPeople_SearchPeople.setText("");
		if (selectedUser != null) {
			viewProfile();
		}
	}

	private void showMessages() {
		panelHome.setVisible(false);
		panelProfile.setVisible(false);
		panelPeople.setVisible(false);
		panelMessages.setVisible(true);
		panelGroups.setVisible(false);
		panelGroupMessages.setVisible(false);
		panelEditProfile.setVisible(false);
		if (selectedChatUser != null) {
			if (listOfMyFriends.contains(selectedChatUser)) {
				spMsg_Text.setVisible(true);
				btnMsg_Send.setVisible(true);
				btnMsg_ProfileInfo.setVisible(true);
				lblMsg_LastMessageRecieved.setVisible(true);
				lblMsg_MessageRecievedAt.setVisible(true);
				lblMsg_SentStatus.setVisible(true);
				lblMsg_StatusOfLastSentMessage.setVisible(true);
			} else {
				spMsg_Text.setVisible(false);
				btnMsg_Send.setVisible(false);
				btnMsg_ProfileInfo.setVisible(false);
				lblMsg_LastMessageRecieved.setVisible(false);
				lblMsg_MessageRecievedAt.setVisible(false);
				lblMsg_SentStatus.setVisible(false);
				lblMsg_StatusOfLastSentMessage.setVisible(false);

			}
			if (listBlockByUsers.contains(selectedChatUser)) {
				btnMsg_ProfileInfo.setVisible(false);
			} else {
				btnMsg_ProfileInfo.setVisible(true);
			}
		} else {
			spMsg_Text.setVisible(false);
			btnMsg_Send.setVisible(false);
			btnMsg_ProfileInfo.setVisible(false);
			lblMsg_LastMessageRecieved.setVisible(false);
			lblMsg_MessageRecievedAt.setVisible(false);
			lblMsg_SentStatus.setVisible(false);
			lblMsg_StatusOfLastSentMessage.setVisible(false);
		}
	}

	private void showGroups() {
		panelHome.setVisible(false);
		panelProfile.setVisible(false);
		panelPeople.setVisible(false);
		panelMessages.setVisible(false);
		panelGroups.setVisible(true);
		panelGroupMessages.setVisible(false);
		panelEditProfile.setVisible(false);

		panelGroups_GroupInfo.setVisible(false);
		panelGroups_GroupCreate.setVisible(false);
		btnGroups_CreateNewGroup.setVisible(true);

		tfGroups_SearchGroups.setText("");
		spGroups_GroupSearch.setVisible(false);
		if (selectedGroupGrPanel != null) {
			viewGroupInfo();
		}
	}

	private void showGroupMessages() {
		panelHome.setVisible(false);
		panelProfile.setVisible(false);
		panelPeople.setVisible(false);
		panelMessages.setVisible(false);
		panelGroups.setVisible(false);
		panelGroupMessages.setVisible(true);
		panelEditProfile.setVisible(false);
		if (selectedGroupChat != null) {
			btnGroupMsg_GroupInfo.setVisible(true);
			if (listOfMyGroups.contains(selectedGroupChat)) {
				btnGroupMsg_Send.setVisible(true);
				spGroupMsg_textMessage.setVisible(true);
			} else {
				btnGroupMsg_Send.setVisible(false);
				spGroupMsg_textMessage.setVisible(false);
			}
		} else {
			btnGroupMsg_Send.setVisible(false);
			spGroupMsg_textMessage.setVisible(false);
			btnGroupMsg_GroupInfo.setVisible(false);
		}
	}

	@SuppressWarnings("unchecked")
	public void refreshForm(Map<String, Object> hm2) {
		hm = hm2;
		allUsersHM = (Map<Integer, User>) hm2.get(Constant.ALL_USERS_HM);
		fillPeoplePanel();
	}

	@SuppressWarnings("unchecked")
	public void updateClientPersonalData(Map<String, Object> hm2) {
		hm = hm2;
		allUsersHM = (Map<Integer, User>) hm2.get(Constant.ALL_USERS_HM);

		fillProfilePanel();
	}

	public void changeListOfActiveUsers(List<Integer> listOfActiveUsers) {
		this.listOfActiveUsers = listOfActiveUsers;
		fillPeoplePanel();
	}

	public void addUserProfilPicture(SendingFile sf) {
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
