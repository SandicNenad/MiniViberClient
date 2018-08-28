package com.comtrade.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.comtrade.communication.Communication;
import com.comtrade.constant.Constant;
import com.comtrade.controllerdatacombobox.ControllerDataComboBox;
import com.comtrade.domain.SendingFile;
import com.comtrade.domain.User;
import com.comtrade.transfer.TransferClass;
import com.comtrade.view.admin.AdminForm;
import com.comtrade.view.user.UserForm;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class MainForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelMain;
	private JPanel panelRegistration;
	private JPanel panelLogin;
	private JPanel panelSignUp;

	private JLayeredPane layeredPane;
	private JTextField tfLogin_Username;
	private JPasswordField pfLogin_Password;
	private Map<String, Object> hm = new HashMap<>();
	private JLabel lblSignup_Title1;
	private JLabel lblSingup_Title2;
	private JLabel lblSignup_Username;
	private JLabel lblSignup_Email;
	private JLabel lblSignup_Password;
	private JLabel lblSignup_PasswordConfirm;
	private JLabel lblRegistration_Welcome;
	private JLabel lblRegistration_Username;
	private JLabel lblRegistration_Email;
	private JLabel lblRegistration_DateOfRegistration;
	private JLabel lblRegistration_FirstName;
	private JLabel lblRegistration_LastName;
	private JLabel lblRegistration_Gender;
	private JLabel lblRegistration_DateOfBirth;
	private JLabel lblRegistration_Contry;
	private JLabel lblRegistration_Town;
	private JLabel lblRegistration_Workplace;
	private JLabel lblRegistration_Education;
	private JLabel lblRegistration_ProfilePicture;
	private JLabel lblRegistration_EmailText;
	private JLabel lblRegistration_UsernameText;
	private JLabel lblRegistration_DateOfRegistrationText;
	private JLabel lblLogin_ForgotPassword;

	private JTextField tfSignup_Username;
	private JTextField tfSignup_Email;
	private JTextField tfRegistration_FirstName;
	private JTextField tfRegistration_LastName;
	private JTextField tfRegistration_WorkPlace;
	private JTextField tfRegistration_Education;

	private JScrollPane spRegistration_AboutMe;
	private JTextArea taRegistration_AboutMe;

	private JPasswordField pfSignup_Password;
	private JPasswordField pfSignup_PasswordConfirm;

	private JButton btnSignUp;
	private JButton btnLogin_LogIn;
	private JButton btnRegistration_Continue;
	private JButton btnRegistration_UploadPhoto;

	private JRadioButton rbRegistration_Female;
	private JRadioButton rbRegistration_Male;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	private JDateChooser dateChooser;

	private JComboBox<Object> cbRegistration_Country;
	private JComboBox<Object> cbRegistrationTown;

	private User currentUser;
	private JFileChooser fileChooser = new JFileChooser();
	private String profilePictureURL = "default";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm frame = new MainForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainForm() {
		setTitle("miniViber - Login");
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

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1084, 661);
		contentPane.add(layeredPane);

		panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		panelMain.setBounds(0, 0, 1084, 661);
		layeredPane.add(panelMain);
		panelMain.setLayout(null);

		panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 1084, 167);
		panelLogin.setBackground(new Color(102, 153, 255));
		panelMain.add(panelLogin);
		panelLogin.setLayout(null);

		JLabel lblLogin_Miniviber = new JLabel("miniViber");
		lblLogin_Miniviber.setForeground(Color.WHITE);
		lblLogin_Miniviber.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin_Miniviber.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 48));
		lblLogin_Miniviber.setBounds(10, 43, 324, 79);
		panelLogin.add(lblLogin_Miniviber);

		JLabel lblLogin_Username = new JLabel("Username");
		lblLogin_Username.setForeground(Color.WHITE);
		lblLogin_Username.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin_Username.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblLogin_Username.setBounds(503, 43, 129, 31);
		panelLogin.add(lblLogin_Username);

		JLabel lblLogin_Password = new JLabel("Password");
		lblLogin_Password.setForeground(Color.WHITE);
		lblLogin_Password.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin_Password.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblLogin_Password.setBounds(684, 43, 129, 31);
		panelLogin.add(lblLogin_Password);

		tfLogin_Username = new JTextField();
		tfLogin_Username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		tfLogin_Username.setHorizontalAlignment(SwingConstants.CENTER);
		tfLogin_Username.setBounds(503, 79, 129, 31);
		panelLogin.add(tfLogin_Username);
		tfLogin_Username.setColumns(10);

		pfLogin_Password = new JPasswordField();
		pfLogin_Password.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		pfLogin_Password.setHorizontalAlignment(SwingConstants.CENTER);
		pfLogin_Password.setBounds(684, 79, 129, 31);
		panelLogin.add(pfLogin_Password);

		btnLogin_LogIn = new JButton("Login");
		btnLogin_LogIn.setForeground(Color.WHITE);
		btnLogin_LogIn.setBackground(new Color(102, 153, 255));
		btnLogin_LogIn.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		btnLogin_LogIn.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				String username = tfLogin_Username.getText();
				@SuppressWarnings("deprecation")
				String password = pfLogin_Password.getText();
				User u = new User();
				u.setUsername(username);
				u.setPassword(password);
				TransferClass tc = new TransferClass();
				tc.setOperation(Constant.LOGIN);
				tc.setClientObject(u);
				Communication.getInstance().sendData(tc);
				TransferClass returnedTc = Communication.getInstance().readData();
				switch (returnedTc.getOperation()) {
				case Constant.LOGIN_FAILED:
					JOptionPane.showMessageDialog(null, returnedTc.getServerMessage());
					break;

				case Constant.LOGIN_SUCCESSFULL:
					hm = (HashMap<String, Object>) returnedTc.getServerObject();
					User povratni = (User) hm.get(Constant.CURRENT_USER);
					if (povratni.getTypeOfUser().equals("admin")) {
						AdminForm af = new AdminForm(hm);
						af.setVisible(true);
						dispose();
					} else if (povratni.getTypeOfUser().equals("user")) {
						UserForm uf = new UserForm(hm);
						uf.setVisible(true);
						dispose();
					}
					break;

				default:
					break;
				}
			}
		});
		btnLogin_LogIn.setBounds(864, 79, 129, 31);
		panelLogin.add(btnLogin_LogIn);

		lblLogin_ForgotPassword = new JLabel("Forgot password?");
		lblLogin_ForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				if (tfLogin_Username.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Enter your username and we will send you password to email");
				} else {
					String username = tfLogin_Username.getText();
					TransferClass tc = new TransferClass();
					tc.setClientObject(username);
					tc.setOperation(Constant.SEND_PASSWORD_TO_EMAIL);
					Communication.getInstance().sendData(tc);
					TransferClass returnedTc = Communication.getInstance().readData();
					if (returnedTc.getOperation() == Constant.SEND_PASSWORD_SUCCESS) {
						JOptionPane.showMessageDialog(null, returnedTc.getServerMessage());
					} else {
						JOptionPane.showMessageDialog(null, returnedTc.getServerMessage());
					}
				}
			}
		});
		lblLogin_ForgotPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin_ForgotPassword.setForeground(Color.WHITE);
		lblLogin_ForgotPassword.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblLogin_ForgotPassword.setBounds(578, 125, 177, 31);
		panelLogin.add(lblLogin_ForgotPassword);

		panelSignUp = new JPanel();
		panelSignUp.setBackground(Color.WHITE);
		panelSignUp.setBounds(0, 167, 1084, 494);
		panelMain.add(panelSignUp);
		panelSignUp.setLayout(null);

		lblSignup_Title1 = new JLabel("CREATE A NEW ACCOUNT:\r\n");
		lblSignup_Title1.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblSignup_Title1.setBounds(401, 45, 442, 58);
		panelSignUp.add(lblSignup_Title1);

		lblSingup_Title2 = new JLabel("Connect with friends on miniViber\r\n");
		lblSingup_Title2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblSingup_Title2.setBounds(426, 114, 396, 38);
		panelSignUp.add(lblSingup_Title2);

		lblSignup_Username = new JLabel("Username:");
		lblSignup_Username.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSignup_Username.setBounds(426, 169, 151, 32);
		panelSignUp.add(lblSignup_Username);

		lblSignup_Email = new JLabel("E-mail:");
		lblSignup_Email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSignup_Email.setBounds(426, 212, 151, 32);
		panelSignUp.add(lblSignup_Email);

		lblSignup_Password = new JLabel("Password:");
		lblSignup_Password.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSignup_Password.setBounds(426, 255, 151, 32);
		panelSignUp.add(lblSignup_Password);

		lblSignup_PasswordConfirm = new JLabel("Confirm password:");
		lblSignup_PasswordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSignup_PasswordConfirm.setBounds(426, 298, 151, 32);
		panelSignUp.add(lblSignup_PasswordConfirm);

		tfSignup_Username = new JTextField();
		tfSignup_Username.setHorizontalAlignment(SwingConstants.CENTER);
		tfSignup_Username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		tfSignup_Username.setBounds(657, 169, 151, 32);
		panelSignUp.add(tfSignup_Username);
		tfSignup_Username.setColumns(10);

		tfSignup_Email = new JTextField();
		tfSignup_Email.setHorizontalAlignment(SwingConstants.CENTER);
		tfSignup_Email.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		tfSignup_Email.setColumns(10);
		tfSignup_Email.setBounds(657, 212, 151, 32);
		panelSignUp.add(tfSignup_Email);

		pfSignup_Password = new JPasswordField();
		pfSignup_Password.setHorizontalAlignment(SwingConstants.CENTER);
		pfSignup_Password.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		pfSignup_Password.setBounds(657, 255, 151, 32);
		panelSignUp.add(pfSignup_Password);

		pfSignup_PasswordConfirm = new JPasswordField();
		pfSignup_PasswordConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		pfSignup_PasswordConfirm.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		pfSignup_PasswordConfirm.setBounds(657, 298, 151, 32);
		panelSignUp.add(pfSignup_PasswordConfirm);

		btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				lblSignup_Username.setForeground(Color.BLACK);
				lblSignup_Email.setForeground(Color.BLACK);
				lblSignup_PasswordConfirm.setForeground(Color.BLACK);
				String username = tfSignup_Username.getText();
				String email = tfSignup_Email.getText();
				@SuppressWarnings("deprecation")
				String password = pfSignup_Password.getText();
				@SuppressWarnings("deprecation")
				String confirmPassword = pfSignup_PasswordConfirm.getText();
				String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				if (password.equals(confirmPassword)) {
					if ((username.length() <= 20) && (email.length() <= 30) && (password.length() <= 20)) {
						User user = new User(username, password, "", "", email, "", "", "", "", "", "", date, date,
								"user", "default");
						TransferClass tc = new TransferClass();
						tc.setOperation(Constant.CREATE_USER);
						tc.setClientObject(user);
						Communication.getInstance().sendData(tc);
						TransferClass tc2 = Communication.getInstance().readData();
						if (tc2.getServerMessage().equals("CLIENT CREATED")) {
							hm = (Map<String, Object>) tc2.getServerObject();
							panelMain.setVisible(false);
							panelRegistration.setVisible(true);
							fillPanelRegistration();
						} else if (tc2.getServerMessage().equals("USERNAME EXIST")) {
							JOptionPane.showMessageDialog(null, tc2.getServerMessage());
							tfSignup_Username.requestFocus();
							lblSignup_Username.setForeground(Color.RED);
						} else if (tc2.getServerMessage().equals("EMAIL EXIST")) {
							JOptionPane.showMessageDialog(null, tc2.getServerMessage());
							tfSignup_Email.requestFocus();
							lblSignup_Email.setForeground(Color.RED);
						}
					} else {
						if (username.length() > 20) {
							JOptionPane.showMessageDialog(null, "Maximum number of characters for username is 20");
						} else if (password.length() > 20) {
							JOptionPane.showMessageDialog(null, "Maximum number of characters for password is 20");
						} else if (email.length() > 30) {
							JOptionPane.showMessageDialog(null, "Maximum number of characters for email is 20");
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, "Confirmed password must be same as password");
					pfSignup_PasswordConfirm.requestFocus();
					lblSignup_PasswordConfirm.setForeground(Color.RED);
				}
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnSignUp.setBounds(546, 368, 151, 32);
		panelSignUp.add(btnSignUp);

		panelRegistration = new JPanel();
		panelRegistration.setBackground(Color.WHITE);
		panelRegistration.setBounds(0, 0, 1084, 661);
		layeredPane.add(panelRegistration);
		panelRegistration.setLayout(null);

		lblRegistration_Welcome = new JLabel("Welcome ");
		lblRegistration_Welcome.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblRegistration_Welcome.setBounds(31, 33, 1005, 48);
		panelRegistration.add(lblRegistration_Welcome);

		lblRegistration_Username = new JLabel("Username");
		lblRegistration_Username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_Username.setBounds(31, 111, 156, 24);
		panelRegistration.add(lblRegistration_Username);

		lblRegistration_Email = new JLabel("E-mail adress");
		lblRegistration_Email.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_Email.setBounds(31, 146, 156, 24);
		panelRegistration.add(lblRegistration_Email);

		lblRegistration_DateOfRegistration = new JLabel("Date of Registration");
		lblRegistration_DateOfRegistration.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_DateOfRegistration.setBounds(31, 181, 156, 24);
		panelRegistration.add(lblRegistration_DateOfRegistration);

		lblRegistration_FirstName = new JLabel("First name");
		lblRegistration_FirstName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_FirstName.setBounds(31, 216, 156, 24);
		panelRegistration.add(lblRegistration_FirstName);

		lblRegistration_LastName = new JLabel("Last name");
		lblRegistration_LastName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_LastName.setBounds(31, 251, 156, 24);
		panelRegistration.add(lblRegistration_LastName);

		lblRegistration_Gender = new JLabel("Gender");
		lblRegistration_Gender.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_Gender.setBounds(31, 312, 156, 24);
		panelRegistration.add(lblRegistration_Gender);

		rbRegistration_Male = new JRadioButton("Male");
		buttonGroup.add(rbRegistration_Male);
		rbRegistration_Male.setBackground(Color.WHITE);
		rbRegistration_Male.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		rbRegistration_Male.setBounds(31, 343, 78, 23);
		rbRegistration_Male.setSelected(true);
		panelRegistration.add(rbRegistration_Male);

		rbRegistration_Female = new JRadioButton("Female");
		buttonGroup.add(rbRegistration_Female);
		rbRegistration_Female.setBackground(Color.WHITE);
		rbRegistration_Female.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		rbRegistration_Female.setBounds(117, 343, 109, 23);
		panelRegistration.add(rbRegistration_Female);

		lblRegistration_DateOfBirth = new JLabel("Date of Birth");
		lblRegistration_DateOfBirth.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_DateOfBirth.setBounds(31, 398, 156, 24);
		panelRegistration.add(lblRegistration_DateOfBirth);

		lblRegistration_Contry = new JLabel("Country");
		lblRegistration_Contry.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_Contry.setBounds(31, 433, 156, 24);
		panelRegistration.add(lblRegistration_Contry);

		lblRegistration_Town = new JLabel("Town");
		lblRegistration_Town.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_Town.setBounds(31, 468, 156, 24);
		panelRegistration.add(lblRegistration_Town);

		lblRegistration_Workplace = new JLabel("Workplace");
		lblRegistration_Workplace.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_Workplace.setBounds(31, 505, 156, 24);
		panelRegistration.add(lblRegistration_Workplace);

		lblRegistration_Education = new JLabel("Education");
		lblRegistration_Education.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_Education.setBounds(31, 540, 156, 24);
		panelRegistration.add(lblRegistration_Education);

		tfRegistration_FirstName = new JTextField();
		tfRegistration_FirstName.setHorizontalAlignment(SwingConstants.CENTER);
		tfRegistration_FirstName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfRegistration_FirstName.setBackground(Color.WHITE);
		tfRegistration_FirstName.setBounds(197, 219, 156, 20);
		panelRegistration.add(tfRegistration_FirstName);
		tfRegistration_FirstName.setColumns(10);

		tfRegistration_LastName = new JTextField();
		tfRegistration_LastName.setHorizontalAlignment(SwingConstants.CENTER);
		tfRegistration_LastName.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfRegistration_LastName.setColumns(10);
		tfRegistration_LastName.setBackground(Color.WHITE);
		tfRegistration_LastName.setBounds(197, 254, 156, 20);
		panelRegistration.add(tfRegistration_LastName);

		tfRegistration_WorkPlace = new JTextField();
		tfRegistration_WorkPlace.setHorizontalAlignment(SwingConstants.CENTER);
		tfRegistration_WorkPlace.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfRegistration_WorkPlace.setColumns(10);
		tfRegistration_WorkPlace.setBackground(Color.WHITE);
		tfRegistration_WorkPlace.setBounds(197, 508, 156, 20);
		panelRegistration.add(tfRegistration_WorkPlace);

		tfRegistration_Education = new JTextField();
		tfRegistration_Education.setHorizontalAlignment(SwingConstants.CENTER);
		tfRegistration_Education.setFont(new Font("Tahoma", Font.ITALIC, 13));
		tfRegistration_Education.setColumns(10);
		tfRegistration_Education.setBackground(Color.WHITE);
		tfRegistration_Education.setBounds(197, 543, 156, 20);
		panelRegistration.add(tfRegistration_Education);

		cbRegistration_Country = new JComboBox<Object>();
		cbRegistration_Country.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbRegistrationTown.removeAllItems();
				String country = cbRegistration_Country.getSelectedItem().toString();
				List<String> lista = ControllerDataComboBox.getInstance().getHmOfCountries().get(country);
				for (String temp : lista) {
					cbRegistrationTown.addItem(temp);
				}
			}
		});

		cbRegistration_Country.setFont(new Font("Tahoma", Font.ITALIC, 13));
		cbRegistration_Country.setBackground(Color.WHITE);
		cbRegistration_Country.setBounds(197, 436, 156, 20);
		panelRegistration.add(cbRegistration_Country);

		cbRegistrationTown = new JComboBox<Object>();
		cbRegistrationTown.setFont(new Font("Tahoma", Font.ITALIC, 13));
		cbRegistrationTown.setBackground(Color.WHITE);
		cbRegistrationTown.setBounds(197, 471, 156, 20);
		panelRegistration.add(cbRegistrationTown);

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().setBackground(Color.WHITE);
		dateChooser.setBounds(197, 402, 156, 20);
		panelRegistration.add(dateChooser);

		lblRegistration_ProfilePicture = new JLabel("profile pictire");
		lblRegistration_ProfilePicture.setBounds(557, 117, 308, 180);
		panelRegistration.add(lblRegistration_ProfilePicture);

		btnRegistration_UploadPhoto = new JButton("Upload photo");
		btnRegistration_UploadPhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fileChooser.showOpenDialog(null);
				if (fileChooser.getSelectedFile() != null) {
					File f = fileChooser.getSelectedFile();
					String fileName = f.getName();
					String typeOfFile = fileName.substring(fileName.length() - 4);
					if (typeOfFile.equalsIgnoreCase(".jpg") || typeOfFile.equalsIgnoreCase(".png")
							|| typeOfFile.equalsIgnoreCase(".bmp")) {

						putImageInLabel(f.getPath(), lblRegistration_ProfilePicture);
					} else {
						JOptionPane.showMessageDialog(null, "Profile picture must be .jpg .bmp or .png format");
					}
				}
			}
		});
		btnRegistration_UploadPhoto.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		btnRegistration_UploadPhoto.setBackground(Color.WHITE);
		btnRegistration_UploadPhoto.setBounds(639, 343, 122, 23);
		panelRegistration.add(btnRegistration_UploadPhoto);

		JLabel lblRegistration_AboutMe = new JLabel("About me");
		lblRegistration_AboutMe.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistration_AboutMe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_AboutMe.setBounds(639, 398, 122, 24);
		panelRegistration.add(lblRegistration_AboutMe);

		spRegistration_AboutMe = new JScrollPane();
		spRegistration_AboutMe.setBounds(543, 433, 331, 127);
		panelRegistration.add(spRegistration_AboutMe);

		taRegistration_AboutMe = new JTextArea();
		taRegistration_AboutMe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		taRegistration_AboutMe.setWrapStyleWord(true);
		taRegistration_AboutMe.setLineWrap(true);
		spRegistration_AboutMe.setViewportView(taRegistration_AboutMe);

		btnRegistration_Continue = new JButton("Continue");
		btnRegistration_Continue.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				Date d = dateChooser.getDate();
				if (d == null) {
					JOptionPane.showMessageDialog(null, "Please select date of birth");
				} else {
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
					String date = df.format(dateChooser.getDate());
					currentUser.setDateOfBirth(date);
					String firstName = tfRegistration_FirstName.getText();
					String lastName = tfRegistration_LastName.getText();
					String gender;
					if (rbRegistration_Female.isSelected()) {
						gender = rbRegistration_Female.getText();
					} else {
						gender = rbRegistration_Male.getText();
					}
					String workplace = tfRegistration_WorkPlace.getText();
					String education = tfRegistration_Education.getText();
					String town = cbRegistrationTown.getSelectedItem().toString();
					String country = cbRegistration_Country.getSelectedItem().toString();
					String aboutMe = taRegistration_AboutMe.getText();
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
						currentUser.setProfilePictureURL(profilePictureURL);
						TransferClass tc = new TransferClass();
						tc.setOperation(Constant.UPDATE_USER_INFO);
						tc.setClientObject(currentUser);
						Communication.getInstance().sendData(tc);
						TransferClass tc2 = Communication.getInstance().readData();
						if (tc2.getOperation() == Constant.UPDATE_SUCCESSFULL) {
							hm = (Map<String, Object>) tc2.getServerObject();
							UserForm uf = new UserForm(hm);
							uf.setVisible(true);
							dispose();
						}

					}
				}
			}
		});
		btnRegistration_Continue.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		btnRegistration_Continue.setBounds(425, 607, 209, 33);
		panelRegistration.add(btnRegistration_Continue);

		lblRegistration_UsernameText = new JLabel("Username");
		lblRegistration_UsernameText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_UsernameText.setBounds(197, 111, 156, 24);
		panelRegistration.add(lblRegistration_UsernameText);

		lblRegistration_EmailText = new JLabel("Email");
		lblRegistration_EmailText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_EmailText.setBounds(197, 146, 156, 24);
		panelRegistration.add(lblRegistration_EmailText);

		lblRegistration_DateOfRegistrationText = new JLabel("DoR");
		lblRegistration_DateOfRegistrationText.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblRegistration_DateOfRegistrationText.setBounds(197, 181, 156, 24);
		panelRegistration.add(lblRegistration_DateOfRegistrationText);

		panelRegistration.setVisible(false);
	}

	private void fillPanelRegistration() {
		currentUser = (User) hm.get(Constant.CURRENT_USER);
		lblRegistration_Welcome.setText("Welcome " + currentUser.getUsername());
		lblRegistration_UsernameText.setText(currentUser.getUsername());
		lblRegistration_DateOfRegistrationText
				.setText(convertStringIntoDateAndPutInLabel(currentUser.getDateOfRegistration()));
		lblRegistration_EmailText.setText(currentUser.getEmail());
		taRegistration_AboutMe.setText("");
		tfRegistration_FirstName.setText("");
		tfRegistration_LastName.setText("");
		tfRegistration_WorkPlace.setText("");
		tfRegistration_Education.setText("");
		putImageInLabel(Constant.PROFILE_PICTURE + "default.png", lblRegistration_ProfilePicture);
		fillComboBoxesCountryAndTown();
	}

	private void putImageInLabel(String path, JLabel label) {
		ImageIcon img = new ImageIcon(path);
		Image image = img.getImage();
		Image newImg = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		label.setIcon(new ImageIcon(newImg));
	}

	private void fillComboBoxesCountryAndTown() {
		Map<String, List<String>> hmOfCountries = ControllerDataComboBox.getInstance().getHmOfCountries();
		for (Entry<String, List<String>> temp : hmOfCountries.entrySet()) {
			cbRegistration_Country.addItem(temp.getKey());
		}
		String country = cbRegistration_Country.getSelectedItem().toString();
		for (String temp : hmOfCountries.get(country)) {
			cbRegistrationTown.addItem(temp);
		}
	}

	@SuppressWarnings("deprecation")
	private String convertStringIntoDateAndPutInLabel(String text) {
		String[] datum = text.split("-");
		Date date = new Date(Integer.parseInt(datum[0]) - 1900, Integer.parseInt(datum[1]) - 1,
				Integer.valueOf(datum[2]));
		text = new SimpleDateFormat("dd MMMM, YYYY").format(date);
		return text;
	}
}
