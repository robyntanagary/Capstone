import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.event.ChangeEvent;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PostGradToolUI {

	private JFrame frmSchoolOfIt;
	private JTextField txtSignInApplicantNumber;
	private JPasswordField pswPassword;
	private JPasswordField pswConfirmPassword;
	private JTextField txtApplicationNumber;
	private JTextField txtApplicationStatus;
	private JTextField txtApplicationReasonStatus;
	private JTextField txtApplicantNumber;
	private JTextField txtSurname;
	private JTextField txtFirstName;
	private JTextField txtIDPassport;
	private JTextField txtEmail;
	private JTextField txtCellphone;
	private JTextField txtDegCountryOther;
	private JTextField txtDegOther;
	private JTextField txtDegUniversity;
	private JTextField txtStudyProgramOther;
	private JTextField txtAverageMathLevel1;
	private JTextField txtAverageMathLevel2;
	private JTextField txtAverageMathLevel3;
	private JTable tblApplications;
	private JTextField txtApplicantApplicationNumber;
	private JTextField txtApplicantApplicationStatus;
	private JTextField txtStatusReason;
	private ApplicationController appController;
	private UserController userController;
	private boolean bSignIn;
	private JPanel pnlSignInUI;
	private JLabel lblSignInApplicantNumber;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JLabel lblNewMessage;
	private JButton btnGoToSignUpProcess;
	private JButton btnSign;
	private JTextArea txtrApplicantNumberWarning;
	private JPanel pnlApplicantEntry;
	private JLabel lblApplicantApplicationNumber;
	private JLabel lblApplicantApplicationStatus;
	private JLabel lblStatusReason;
	private JTextArea txtrMessage;
	private JButton btnViewApplication;
	private JButton btnEditApplication;
	private JButton btnRemoveApplication;
	private JPanel pnlApplicationUI;
	private JPanel pnlPersonalDetails = new JPanel();
	private JLabel lblApplicationApplicantNumber;
	private JLabel lblSurname;
	private JLabel lblFirstName;
	private JLabel lblTitle;
	private JLabel lblCitizenship;
	private JComboBox<String> cbxTitle;
	private JLabel lblIdPassport;
	private JComboBox<String> cbxCitizenship;
	private JLabel lblRace;
	private JComboBox<String> cbxRace;
	private JLabel lblCountry;
	private JComboBox<String> cbxCountry;
	private JPanel pnlContactDetails;
	private JLabel lblEmail;
	private JLabel lblCellphone;
	private JLabel lblResidenceLineAddress;
	private JTextArea txtrLineAddress;
	private JLabel lblResidenceCountry;
	private JComboBox<String> cbxResCountry;
	private JLabel lblPreviousDegree;
	private JPanel pnlTertiaryQualifications;
	private JLabel lbldegCountry;
	private JComboBox<String> cbxDegCountry;
	private JLabel lblPreviousDegree_1;
	private JLabel lblDegOther;
	private JComboBox<String> cbxDegree;
	private JLabel lblNqfEquivalentOf;
	private JComboBox<String> cbxNQF;
	private JLabel lblMinDurationOf;
	private JSpinner spnMinDuration;
	private JLabel lblUniversity;
	private JPanel pnlProgrammeOfStudy;
	private JLabel lblProgrammeOfStudy;
	private JLabel lblIfOtherSpecify;
	private JComboBox<String> cbxStudyProgram; 
	private JLabel lblPriorItExperience;
	private JLabel lblLevelOfUndergraduate;
	private JSpinner spnLevelUndergrad;
	private JLabel lblAverageMathLevel1;
	private JLabel lblAveragesPerMathematics;
	private JSpinner spnYearsITExperience;
	private JCheckBox chckbxPreviousDegreeHadProjectThesis;
	private JTextArea txtrProvideBriefDescription;
	private JLabel lblAverageMathLevel2;
	private JLabel lblAverageMathLevel3;
	private JPanel pnlAdditionalDocumentation;
	private JTextArea txtrTheFollowingDocuments;
	private JCheckBox chckbxCertifiedTranscript;
	private JCheckBox chckbxCurriculumVitaecv;
	private JCheckBox chckbxResearchStatement;
	private JCheckBox chckbxRefereesNames;
	private JCheckBox chckbxMotivation;
	private JLabel lblPdfOfAdditional;
	private JButton btnChoosePDF;
	private JButton btnUploadFile;
	private JLabel lblPDFName;
	private JButton btnDownloadPDF;
	private JPanel pnlApplicationFieldCats;
	private JMenuItem mntmPersonalDetails;
	private JMenuItem mntmContactDetails;
	private JPanel pnlAcademicEntryUI;
	private JMenuItem mntmTertiaryQual;
	private JMenuItem mntmProgrammeOfStudy;
	private JMenuItem mntmRequiredDocumentation;
	private JButton btnNewButton;
	private JButton btnNext;
	private JButton btnSaveUpdate;
	private JButton btnSubmitReturn;
	private JButton btnChangeStatus;
	private JButton btnPdfOfApplication;
	private JLabel lblApplicationNumber;
	private JButton btnChooseCSV;
	private JLabel lblUploadCSVMessage;
	private JButton btnUploadCsv;
	private JLabel lblApplicationApplicationStatus;
	private JLabel lblApplicationReasonForStatus;
	private JLabel lblSelectFieldValues;
	private JButton btnGenerateCsv;
	private JLabel lblApplicationStatus;
	private JLabel lblLevelOfStudy;
	private JLabel lblAcademicEntryMessage;
	private JComboBox<String> cbxStudyPrograms;
	private JLabel lblStudyProgram;
	private JComboBox<String> cbxLevel;
	private JComboBox<String> cbxApplicationStatus;
	private JLabel lblNameOfCSVFile;
	private Applicant applicant;
	private InternationalApplicant intApplicant;
	private SouthAfricanApplicant rsaApplicant;
	private FOacademic academic;
	private Application application;
	private JCheckBox chkbxFundingStatement;
	private JTextField txtSignEmail;
	private boolean bApplicantSignedIn;
	private JComboBox<String> cbxApplicationApplicationStatus;
	private JComboBox<String> cbxApplicationStatusReason;
	private UndergraduateMathematics[] undMaths;
	private DataReaderWriter data;
	
	/**
	 * Run Postgraduate Application Tool.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostGradToolUI window1 = new PostGradToolUI();
					window1.frmSchoolOfIt.setVisible(true);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Prepare application by initiating controllers and setting up form and pannels.
	 */
	public PostGradToolUI() {
		data = new DataReaderWriter();
		appController = new ApplicationController(data);
		userController = new UserController(data);
		bSignIn = true;
		initialize();
	}

	/**
	 * general infoBox to act as pop-up messages
	 */
	
	public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frmSchoolOfIt = new JFrame();
		frmSchoolOfIt.setTitle("School of IT");
		frmSchoolOfIt.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		frmSchoolOfIt.setBounds(100, 100, 734, 429);
		frmSchoolOfIt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSchoolOfIt.getContentPane().setLayout(null);
		
		pnlAcademicEntryUI = new JPanel();
		pnlAcademicEntryUI.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlAcademicEntryUI.setBounds(0, 0, 718, 390);
		pnlAcademicEntryUI.setVisible(false);
		
		pnlApplicantEntry = new JPanel();
		pnlApplicantEntry.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlApplicantEntry.setBounds(0, 0, 718, 390);
		pnlApplicantEntry.setVisible(false);
		
		pnlApplicationUI = new JPanel();
		pnlApplicationUI.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlApplicationUI.setBounds(0, 0, 718, 390);
		pnlApplicationUI.setVisible(false);
		
		//Sign-In and Sign-Up UI & all its components
		pnlSignInUI = new JPanel();
		pnlSignInUI.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlSignInUI.setBounds(0, 0, 718, 390);
		frmSchoolOfIt.getContentPane().add(pnlSignInUI);
		pnlSignInUI.setLayout(null);
		
		lblSignInApplicantNumber = new JLabel("UCT Applicant / Student Number:");
		lblSignInApplicantNumber.setBounds(140, 151, 195, 14);
		lblSignInApplicantNumber.setFont(new Font("Calibri", Font.PLAIN, 12));
		pnlSignInUI.add(lblSignInApplicantNumber);
		
		txtSignInApplicantNumber = new JTextField();
		txtSignInApplicantNumber.setBounds(362, 146, 214, 20);
		pnlSignInUI.add(txtSignInApplicantNumber);
		txtSignInApplicantNumber.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPassword.setBounds(140, 217, 195, 14);
		pnlSignInUI.add(lblPassword);
		
		pswPassword = new JPasswordField();
		pswPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		pswPassword.setBounds(362, 212, 214, 20);
		pnlSignInUI.add(pswPassword);
		
		pswConfirmPassword = new JPasswordField();
		pswConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		pswConfirmPassword.setBounds(362, 243, 214, 20);
		pswConfirmPassword.setVisible(false);
		pnlSignInUI.add(pswConfirmPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblConfirmPassword.setBounds(140, 246, 195, 14);
		lblConfirmPassword.setVisible(false);
		pnlSignInUI.add(lblConfirmPassword);
		
		lblNewMessage = new JLabel("New to the School of IT Application System? Click Sign-Up.");
		lblNewMessage.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewMessage.setBounds(140, 107, 303, 14);
		pnlSignInUI.add(lblNewMessage);
		
		btnGoToSignUpProcess = new JButton("Sign-Up");
		btnGoToSignUpProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prepareSignUp();
			}
		});
		btnGoToSignUpProcess.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnGoToSignUpProcess.setBounds(487, 101, 89, 23);
		pnlSignInUI.add(btnGoToSignUpProcess);
		
		btnSign = new JButton("Sign-In");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = txtSignInApplicantNumber.getText().toString(); //get number representing username
				String password = String.valueOf(pswPassword.getPassword()); //get password
				System.out.println(number + " " + password);
				if (bSignIn) //Need to sign in applicant / academic.
				{ 
					if (userController.isApplicant(number, password)) //in the case of an applicant
					{
						applicant = userController.getApplicant(number);
						userController.setApplicantOfFocus(applicant);
						bApplicantSignedIn = true;
						pnlSignInUI.setVisible(false); //leave current interface
						
						if (appController.noExistingApplication(number)) //first-time application
						{
							application = appController.createNewApplication(number);
							showPersonalDetails();
						}
						else
						{
							application = appController.getApplicationOfApplicant(number);
							appController.setApplicationOfFocus(application);
							populateApplicationFields(applicant, application);
							showPersonalDetails();
						}
					}
					else if (userController.isFOacademic(number, password)) //in the case of an academic
					{
						academic = userController.getFOacademic(number);
						userController.setFOAcademicEvaluating(academic);;
						bApplicantSignedIn = false;
						showAcademicEntryInterface();
					}
					else
					{
						txtSignInApplicantNumber.setText("");
						txtSignEmail.setText("");
						pswPassword.setText("");
						pswConfirmPassword.setText("");
						bApplicantSignedIn = false;
						showSignInInterface();
						infoBox("The credentials you have provided are incorrect, please try again.", "Error");
						//display error message!!!
					}
				}
				else //need to sign up applicant and return to sign in
				{
					boolean bSuccessful = userController.registerNewApplicant(number, txtSignEmail.getText().trim(), password, pswConfirmPassword.getPassword().toString());
					if (bSuccessful)
					{
						populateApplicationFields(applicant, application);
						lblConfirmPassword.setVisible(false);
						pswConfirmPassword.setVisible(false);
						showSignInInterface();
					}
					else
					{
						txtSignInApplicantNumber.setText("");
						txtSignEmail.setText("");
						pswPassword.setText("");
						pswConfirmPassword.setText("");
						showSignInInterface();
					}
		
				}
			}
		});
		btnSign.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnSign.setBounds(487, 279, 89, 23);
		pnlSignInUI.add(btnSign);
		
		txtrApplicantNumberWarning = new JTextArea();
		txtrApplicantNumberWarning.setWrapStyleWord(true);
		txtrApplicantNumberWarning.setLineWrap(true);
		txtrApplicantNumberWarning.setEditable(false);
		txtrApplicantNumberWarning.setText("To all potential applicants: One needs to first apply at UCT Online Applications to receive an Applicant Number, unless you already have a UCT Student Number.");
		txtrApplicantNumberWarning.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtrApplicantNumberWarning.setBounds(502, 11, 206, 79);
		pnlSignInUI.add(txtrApplicantNumberWarning);
		
		txtSignEmail = new JTextField();
		txtSignEmail.setColumns(10);
		txtSignEmail.setBounds(362, 176, 214, 20);
		pnlSignInUI.add(txtSignEmail);
		
		JLabel lblSignEmail = new JLabel("Email:");
		lblSignEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSignEmail.setBounds(140, 181, 195, 14);
		pnlSignInUI.add(lblSignEmail);
		frmSchoolOfIt.getContentPane().add(pnlApplicationUI);
		pnlApplicationUI.setLayout(null);
		
		pnlPersonalDetails = new JPanel();
		pnlPersonalDetails.setBounds(235, 87, 459, 282);
		pnlApplicationUI.add(pnlPersonalDetails);
		pnlPersonalDetails.setLayout(null);
		
		txtApplicantNumber = new JTextField();
		txtApplicantNumber.setEditable(false);
		txtApplicantNumber.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtApplicantNumber.setBounds(160, 10, 188, 25);
		pnlPersonalDetails.add(txtApplicantNumber);
		txtApplicantNumber.setColumns(10);
		
		lblApplicationApplicantNumber = new JLabel("Applicant Number:");
		lblApplicationApplicantNumber.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblApplicationApplicantNumber.setBounds(10, 11, 125, 25);
		pnlPersonalDetails.add(lblApplicationApplicantNumber);
		
		lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSurname.setBounds(10, 45, 124, 24);
		pnlPersonalDetails.add(lblSurname);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblFirstName.setBounds(10, 80, 124, 24);
		pnlPersonalDetails.add(lblFirstName);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblTitle.setBounds(10, 115, 124, 24);
		pnlPersonalDetails.add(lblTitle);
		
		lblCitizenship = new JLabel("Citizenship");
		lblCitizenship.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCitizenship.setBounds(10, 150, 124, 24);
		pnlPersonalDetails.add(lblCitizenship);
		
		lblIdPassport = new JLabel("ID / Passport:");
		lblIdPassport.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIdPassport.setBounds(10, 213, 124, 24);
		lblIdPassport.setVisible(false);
		pnlPersonalDetails.add(lblIdPassport);
		
		lblRace = new JLabel("Race:");
		lblRace.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblRace.setBounds(10, 248, 124, 24);
		lblRace.setVisible(false);
		pnlPersonalDetails.add(lblRace);
		
		txtSurname = new JTextField();
		txtSurname.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.setSurname(txtSurname.getText().toString().trim());
			}
		});
		txtSurname.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtSurname.setColumns(10);
		txtSurname.setBounds(160, 46, 188, 25);
		pnlPersonalDetails.add(txtSurname);
		
		txtFirstName = new JTextField();
		txtFirstName.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.setFirstName(txtFirstName.getText().toString().trim());
			}
		});
		txtFirstName.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(160, 82, 188, 25);
		pnlPersonalDetails.add(txtFirstName);
		
		cbxTitle = new JComboBox<String>();
		populateComboBox(cbxTitle, "Titles.txt");
		cbxTitle.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.setTitle(cbxTitle.getSelectedItem().toString().trim());
			}
		});
		cbxTitle.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxTitle.setBounds(160, 118, 188, 22);
		pnlPersonalDetails.add(cbxTitle);
		
		txtIDPassport = new JTextField();
		txtIDPassport.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if (applicant.getCitizenship().equals("International"))
				{
					intApplicant.setPassport(txtIDPassport.getText().toString().trim());
				}
				else
				{
					rsaApplicant.setID(txtIDPassport.getText().toString().trim());
				}
			}
		});
		txtIDPassport.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtIDPassport.setColumns(10);
		txtIDPassport.setBounds(160, 213, 188, 25);
		txtIDPassport.setVisible(false);
		pnlPersonalDetails.add(txtIDPassport);
		
		cbxCitizenship = new JComboBox<String>();
		populateComboBox(cbxCitizenship, "Citizenship.txt");
		cbxCitizenship.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				//if South African, set cbxCountry to South Africa
				applicant.setCitizenship(cbxCitizenship.getSelectedItem().toString().trim());
				boolean bInternational = cbxCitizenship.getSelectedItem().equals("International");
				boolean bRSA = cbxCitizenship.getSelectedItem().toString().contains("South African");
				boolean bVisible = bInternational || bRSA;
				lblIdPassport.setVisible(bVisible);
				txtIDPassport.setVisible(bVisible);
				lblRace.setVisible(bRSA);
				cbxRace.setVisible(bRSA);
				if (bInternational)
				{
					intApplicant = new InternationalApplicant(applicant);
					userController.setInternationalApplicantOfFocus(intApplicant);
					lblIdPassport.setText("Passport");
					cbxCountry.setEditable(true);
				}
				else if (bRSA)
				{
					rsaApplicant = new SouthAfricanApplicant(applicant);
					userController.setSouthAfricanApplicantOfFocus(rsaApplicant);
					lblIdPassport.setText("ID");
					cbxCountry.setSelectedItem("South Africa");
					cbxCountry.setEditable(false);
					rsaApplicant.setCitizenshipCountry("South African");
				}
			}
		});
		cbxCitizenship.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxCitizenship.setBounds(160, 151, 188, 22);
		pnlPersonalDetails.add(cbxCitizenship);
		
		cbxRace = new JComboBox<String>();
		populateComboBox(cbxRace, "Races.txt");
		cbxRace.setVisible(false);
		cbxRace.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				rsaApplicant.setRace(cbxRace.getSelectedItem().toString().trim());
			}
		});
		cbxRace.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxRace.setBounds(160, 249, 188, 22);
		pnlPersonalDetails.add(cbxRace);
		
		lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCountry.setBounds(11, 185, 124, 24);
		pnlPersonalDetails.add(lblCountry);
		
		cbxCountry = new JComboBox<String>();
		populateComboBox(cbxCountry, "Countries.txt");
		cbxCountry.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				boolean bInternationalCitizenship = cbxCitizenship.getSelectedItem().toString().trim().equals("International");
				boolean bRSACitizenship = cbxCitizenship.getSelectedItem().toString().trim().contains("South African");
				boolean bUnindicatedCitizenship = !(bInternationalCitizenship || bRSACitizenship);
				
				if (bUnindicatedCitizenship && cbxCountry.getSelectedItem().toString().trim().equals("South Africa"))
				{
					populateComboBox(cbxCitizenship, "CitizenshipRSA.txt");
					cbxCitizenship.setEditable(true);
				}
				else if (bUnindicatedCitizenship && (!cbxCountry.getSelectedItem().toString().trim().equals("South Africa")))
				{
					populateComboBox(cbxCitizenship, "Citizenship.txt");
					cbxCitizenship.setSelectedItem("International");
					cbxCitizenship.setEditable(false);
					applicant.setCitizenship("International");
					applicant.setCitizenshipCountry(cbxCountry.getSelectedItem().toString().trim());
					intApplicant = new InternationalApplicant(applicant);
				}
				else if (bInternationalCitizenship && (!cbxCountry.getSelectedItem().toString().trim().equals("South Africa")))
				{
					intApplicant.setCitizenshipCountry(cbxCountry.getSelectedItem().toString().trim());
				}
				else if (bRSACitizenship && cbxCountry.getSelectedItem().toString().trim().equals("South Africa"))
				{
					rsaApplicant.setCitizenshipCountry(cbxCountry.getSelectedItem().toString().trim());
				}
				else if (cbxCountry.getSelectedIndex() == -1)
				{
					
				}
				else
				{
					//show error as citizenship does not match up with country choice
				}
			}
		});
		cbxCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxCountry.setBounds(160, 185, 188, 22);
		pnlPersonalDetails.add(cbxCountry);
		
		pnlContactDetails = new JPanel();
		pnlContactDetails.setBounds(235, 86, 459, 282);
		pnlContactDetails.setVisible(false);
		pnlApplicationUI.add(pnlContactDetails);
		pnlContactDetails.setLayout(null);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblEmail.setBounds(10, 11, 125, 25);
		pnlContactDetails.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(160, 10, 190, 25);
		pnlContactDetails.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblCellphone = new JLabel("Cell-phone:");
		lblCellphone.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCellphone.setBounds(10, 45, 125, 25);
		pnlContactDetails.add(lblCellphone);
		
		txtCellphone = new JTextField();
		txtCellphone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				applicant.setCellPhone(txtCellphone.getText().toString().trim());
			}
		});
		txtCellphone.setColumns(10);
		txtCellphone.setBounds(160, 46, 190, 25);
		pnlContactDetails.add(txtCellphone);
		
		lblResidenceLineAddress = new JLabel("Residence line address:");
		lblResidenceLineAddress.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblResidenceLineAddress.setBounds(10, 81, 147, 25);
		pnlContactDetails.add(lblResidenceLineAddress);
		
		txtrLineAddress = new JTextArea();
		txtrLineAddress.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.getResidenceAddress().setLineAddress(txtrLineAddress.getText().toString().trim());
			}
		});
		txtrLineAddress.setWrapStyleWord(true);
		txtrLineAddress.setLineWrap(true);
		txtrLineAddress.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtrLineAddress.setBounds(160, 82, 190, 100);
		pnlContactDetails.add(txtrLineAddress);
		
		lblResidenceCountry = new JLabel("Residence country:");
		lblResidenceCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblResidenceCountry.setBounds(10, 193, 147, 25);
		pnlContactDetails.add(lblResidenceCountry);
		
		cbxResCountry = new JComboBox<String>();
		populateComboBox(cbxResCountry, "Countries.txt");
		cbxResCountry.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				applicant.getResidenceAddress().setCountry(cbxResCountry.getSelectedItem().toString().trim());
			}
		});
		cbxResCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxResCountry.setBounds(160, 192, 190, 22);
		pnlContactDetails.add(cbxResCountry);
		
		pnlTertiaryQualifications = new JPanel();
		pnlTertiaryQualifications.setBounds(235, 87, 459, 282);
		pnlTertiaryQualifications.setVisible(false);
		pnlApplicationUI.add(pnlTertiaryQualifications);
		pnlTertiaryQualifications.setLayout(null);
		
		lbldegCountry = new JLabel("Country where Previous Degree was Obtained:");
		lbldegCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		lbldegCountry.setBounds(10, 12, 262, 25);
		pnlTertiaryQualifications.add(lbldegCountry);
		
		txtDegCountryOther = new JTextField();
		txtDegCountryOther.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.getPreviousQualification().setCountry(txtDegCountryOther.getText().toString().trim());
			}
		});
		txtDegCountryOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtDegCountryOther.setColumns(10);
		txtDegCountryOther.setBounds(267, 48, 182, 25);
		//txtDegCountryOther.setVisible(cbxDegCountry.getSelectedItem().toString().trim().equals("Other"));
		pnlTertiaryQualifications.add(txtDegCountryOther);
		
		lblPreviousDegree = new JLabel("If Other, Specify:");
		lblPreviousDegree.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPreviousDegree.setBounds(10, 46, 124, 24);
		//lblPreviousDegree.setVisible(cbxDegCountry.getSelectedItem().toString().trim().equals("Other"));
		pnlTertiaryQualifications.add(lblPreviousDegree);
		
		cbxDegCountry = new JComboBox<String>();
		populateComboBox(cbxDegCountry, "Countries.txt");
		cbxDegCountry.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				String sDegCountry = cbxDegCountry.getSelectedItem().toString().trim();
				applicant.getPreviousQualification().setCountry(sDegCountry);
				//txtDegCountryOther.setVisible(sDegCountry.equals("Other"));
				//lblPreviousDegree.setVisible(sDegCountry.equals("Other"));
			}
		});
		cbxDegCountry.setBounds(267, 11, 182, 22);
		pnlTertiaryQualifications.add(cbxDegCountry);
		
		lblPreviousDegree_1 = new JLabel("Previous Degree:");
		lblPreviousDegree_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPreviousDegree_1.setBounds(10, 82, 262, 25);
		pnlTertiaryQualifications.add(lblPreviousDegree_1);
		
		cbxDegree = new JComboBox<String>();
		populateComboBox(cbxDegree, "Degrees.txt");
		cbxDegree.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				String sDegree = cbxDegree.getSelectedItem().toString().trim();
				applicant.getPreviousQualification().setDegree(sDegree);
				//txtDegOther.setVisible(sDegree.equals("Other"));
				//lblDegOther.setVisible(sDegree.equals("Other"));
			}
		});
		cbxDegree.setBounds(267, 81, 182, 22);
		pnlTertiaryQualifications.add(cbxDegree);
		
		txtDegOther = new JTextField();
		//String sDegree = cbxDegree.getSelectedItem().toString().trim();
		//txtDegOther.setVisible(sDegree.equals("Other"));
		txtDegOther.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.getPreviousQualification().setDegree(txtDegOther.getText().toString().trim());
			}
		});
		txtDegOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtDegOther.setColumns(10);
		txtDegOther.setBounds(267, 118, 182, 25);
		pnlTertiaryQualifications.add(txtDegOther);
		
		lblDegOther = new JLabel("If Other, Specify:");
		lblDegOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDegOther.setBounds(10, 116, 124, 24);
		//lblDegOther.setVisible(sDegree.equals("Other"));
		pnlTertiaryQualifications.add(lblDegOther);
		
		lblNqfEquivalentOf = new JLabel("NQF Equivalent of Previous Degree:");
		lblNqfEquivalentOf.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNqfEquivalentOf.setBounds(10, 155, 262, 25);
		pnlTertiaryQualifications.add(lblNqfEquivalentOf);
		
		cbxNQF = new JComboBox<String>();
		populateComboBox(cbxNQF, "NQF.txt");
		cbxNQF.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.getPreviousQualification().setNQFEquivalence(cbxNQF.getSelectedItem().toString().trim());
			}
		});
		cbxNQF.setBounds(267, 154, 182, 22);
		pnlTertiaryQualifications.add(cbxNQF);
		
		lblMinDurationOf = new JLabel("Min Duration of Previous Degree:");
		lblMinDurationOf.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMinDurationOf.setBounds(10, 191, 233, 24);
		pnlTertiaryQualifications.add(lblMinDurationOf);
		
		spnMinDuration = new JSpinner();
		spnMinDuration.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.getPreviousQualification().setMinDuration((int) spnMinDuration.getValue());
			}
		});
		spnMinDuration.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		spnMinDuration.setFont(new Font("Calibri", Font.PLAIN, 12));
		spnMinDuration.setBounds(267, 191, 30, 20);
		pnlTertiaryQualifications.add(spnMinDuration);
		
		lblUniversity = new JLabel("University that awarded Previous Degree:");
		lblUniversity.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblUniversity.setBounds(10, 222, 252, 24);
		pnlTertiaryQualifications.add(lblUniversity);
		
		txtDegUniversity = new JTextField();
		txtDegUniversity.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.getPreviousQualification().setTertiaryInstitution(txtDegUniversity.getText().toString().trim());
			}
		});
		txtDegUniversity.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtDegUniversity.setColumns(10);
		txtDegUniversity.setBounds(267, 224, 182, 25);
		pnlTertiaryQualifications.add(txtDegUniversity);
		
		pnlProgrammeOfStudy = new JPanel();
		pnlProgrammeOfStudy.setBounds(235, 86, 459, 282);
		pnlProgrammeOfStudy.setVisible(false);
		pnlApplicationUI.add(pnlProgrammeOfStudy);
		pnlProgrammeOfStudy.setLayout(null);
		
		lblProgrammeOfStudy = new JLabel("Programme of Study:");
		lblProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblProgrammeOfStudy.setBounds(10, 12, 125, 25);
		pnlProgrammeOfStudy.add(lblProgrammeOfStudy);
		
		txtStudyProgramOther = new JTextField();
		txtStudyProgramOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtStudyProgramOther.setColumns(10);
		txtStudyProgramOther.setBounds(219, 46, 188, 25);
		txtStudyProgramOther.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				application.setStudyProgram(appController.getStudyProgram(txtStudyProgramOther.toString().trim()));
			}
		});
		pnlProgrammeOfStudy.add(txtStudyProgramOther);
		
		lblIfOtherSpecify = new JLabel("If Other, Specify:");
		lblIfOtherSpecify.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIfOtherSpecify.setBounds(10, 46, 124, 24);
		pnlProgrammeOfStudy.add(lblIfOtherSpecify);
		
		cbxStudyProgram = new JComboBox<String>();
		populateComboBox(cbxStudyProgram, "Degrees.txt");
		cbxStudyProgram.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				String studyProgram = cbxStudyProgram.getSelectedItem().toString();
				application.setStudyProgram(appController.getStudyProgram(studyProgram));
				
				//lblIfOtherSpecify.setVisible(studyProgram.equals("Other"));
				//txtStudyProgramOther.setVisible(studyProgram.equals("Other"));
				
				if (studyProgram.contains("MIT") && (applicant.getPreviousQualification().getDegree().contains("Computer") || applicant.getPreviousQualification().getDegree().contains("Technology") || applicant.getPreviousQualification().getDegree().contains("Systems")))
				{
					JOptionPane.showMessageDialog(frmSchoolOfIt, "Not Eligible", "Not eligible to apply for MIT", JOptionPane.ERROR_MESSAGE);
					cbxStudyProgram.setSelectedIndex(-1);
				}
				else
				{
				//lblPriorItExperience.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
				//spnYearsITExperience.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
				//lblLevelOfUndergraduate.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
				//spnLevelUndergrad.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
				//chckbxPreviousDegreeHadProjectThesis.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
				}
			}
		});
		cbxStudyProgram.setBounds(219, 11, 188, 22);
		pnlProgrammeOfStudy.add(cbxStudyProgram);
		
		lblPriorItExperience = new JLabel("Years of Prior IT Experience:");
		lblPriorItExperience.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPriorItExperience.setBounds(10, 83, 150, 24);
		pnlProgrammeOfStudy.add(lblPriorItExperience);
		
		lblLevelOfUndergraduate = new JLabel("Level of Undergraduate Mathematics:");
		lblLevelOfUndergraduate.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblLevelOfUndergraduate.setBounds(10, 128, 209, 24);
		pnlProgrammeOfStudy.add(lblLevelOfUndergraduate);
		
		spnLevelUndergrad = new JSpinner();
		spnLevelUndergrad.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				undMaths = new UndergraduateMathematics[(int) spnLevelUndergrad.getValue()];
				displayUndergradMathInputs(Integer.getInteger(spnLevelUndergrad.getValue().toString()));
			}
		});
		spnLevelUndergrad.setModel(new SpinnerNumberModel(0, 0, 4, 1));
		spnLevelUndergrad.setFont(new Font("Calibri", Font.PLAIN, 12));
		spnLevelUndergrad.setBounds(219, 130, 30, 20);
		pnlProgrammeOfStudy.add(spnLevelUndergrad);
		
		lblAveragesPerMathematics = new JLabel("Averages per Mathematics Level:");
		lblAveragesPerMathematics.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAveragesPerMathematics.setBounds(10, 175, 209, 24);
		pnlProgrammeOfStudy.add(lblAveragesPerMathematics);
		
		txtAverageMathLevel1 = new JTextField();
		txtAverageMathLevel1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				undMaths[0] = new UndergraduateMathematics(1, Double.valueOf(txtAverageMathLevel1.getText().toString().trim()));
				if (undMaths.length == 1) {((TertiaryQualificationForMIT) applicant.getPreviousQualification()).setUndergradMaths(undMaths);}		
			}
		});
		txtAverageMathLevel1.setBounds(219, 175, 50, 20);
		pnlProgrammeOfStudy.add(txtAverageMathLevel1);
		txtAverageMathLevel1.setColumns(10);
		
		txtAverageMathLevel2 = new JTextField();
		txtAverageMathLevel2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				undMaths[1] = new UndergraduateMathematics(2, Double.valueOf(txtAverageMathLevel2.getText().toString().trim()));
				if (undMaths.length == 2) {((TertiaryQualificationForMIT) applicant.getPreviousQualification()).setUndergradMaths(undMaths);}	
			}
		});
		txtAverageMathLevel2.setBounds(279, 175, 50, 20);
		pnlProgrammeOfStudy.add(txtAverageMathLevel2);
		txtAverageMathLevel2.setColumns(10);
		
		txtAverageMathLevel3 = new JTextField();
		txtAverageMathLevel3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				undMaths[2] = new UndergraduateMathematics(1, Double.valueOf(txtAverageMathLevel3.getText().toString().trim()));
				if (undMaths.length == 3) {((TertiaryQualificationForMIT) applicant.getPreviousQualification()).setUndergradMaths(undMaths);}	
			}
		});
		txtAverageMathLevel3.setBounds(339, 175, 50, 20);
		pnlProgrammeOfStudy.add(txtAverageMathLevel3);
		txtAverageMathLevel3.setColumns(10);
		
		lblAverageMathLevel1 = new JLabel("Level 1");
		lblAverageMathLevel1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAverageMathLevel1.setBounds(219, 153, 50, 21);
		pnlProgrammeOfStudy.add(lblAverageMathLevel1);
		
		spnYearsITExperience = new JSpinner();
		spnYearsITExperience.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				((TertiaryQualificationForMIT) applicant.getPreviousQualification()).setPriorITExperience((int) spnYearsITExperience.getValue());
			}
		});
		spnYearsITExperience.setFont(new Font("Calibri", Font.PLAIN, 12));
		spnYearsITExperience.setBounds(219, 85, 30, 20);
		pnlProgrammeOfStudy.add(spnYearsITExperience);
		
		chckbxPreviousDegreeHadProjectThesis = new JCheckBox("Previous Degree had Project or Thesis Component");
		chckbxPreviousDegreeHadProjectThesis.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				((TertiaryQualificationForMIT) applicant.getPreviousQualification()).PresenceProjectThesisPresent(chckbxPreviousDegreeHadProjectThesis.isSelected());
				//txtrProvideBriefDescription.setVisible(chckbxPreviousDegreeHadProjectThesis.isSelected());
			}
		});
		chckbxPreviousDegreeHadProjectThesis.setBounds(10, 206, 269, 23);
		pnlProgrammeOfStudy.add(chckbxPreviousDegreeHadProjectThesis);
		
		txtrProvideBriefDescription = new JTextArea();
		txtrProvideBriefDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtrProvideBriefDescription.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				((TertiaryQualificationForMIT) applicant.getPreviousQualification()).setDescriptionProjectThesis(txtrProvideBriefDescription.getText().toString().trim());
			}
		});
		txtrProvideBriefDescription.setFont(new Font("Calibri", Font.ITALIC, 12));
		txtrProvideBriefDescription.setText("Provide Brief Description of Project or Thesis Component");
		txtrProvideBriefDescription.setLineWrap(true);
		txtrProvideBriefDescription.setWrapStyleWord(true);
		txtrProvideBriefDescription.setToolTipText("Provide Brief Description of Project or Thesis Component");
		txtrProvideBriefDescription.setBounds(10, 232, 384, 50);
		pnlProgrammeOfStudy.add(txtrProvideBriefDescription);
		
		lblAverageMathLevel2 = new JLabel("Level 2");
		lblAverageMathLevel2.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAverageMathLevel2.setBounds(279, 153, 50, 24);
		pnlProgrammeOfStudy.add(lblAverageMathLevel2);
		
		lblAverageMathLevel3 = new JLabel("Level 3");
		lblAverageMathLevel3.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAverageMathLevel3.setBounds(339, 153, 50, 24);
		pnlProgrammeOfStudy.add(lblAverageMathLevel3);
		
		pnlAdditionalDocumentation = new JPanel();
		pnlAdditionalDocumentation.setBounds(235, 90, 459, 282);
		pnlAdditionalDocumentation.setVisible(false);
		pnlApplicationUI.add(pnlAdditionalDocumentation);
		pnlAdditionalDocumentation.setLayout(null);
		
		txtrTheFollowingDocuments = new JTextArea();
		txtrTheFollowingDocuments.setBackground(SystemColor.menu);
		txtrTheFollowingDocuments.setText("The following documents (which are ticked) needs to be uploaded as a single PDF:");
		txtrTheFollowingDocuments.setWrapStyleWord(true);
		txtrTheFollowingDocuments.setLineWrap(true);
		txtrTheFollowingDocuments.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtrTheFollowingDocuments.setBounds(10, 9, 439, 34);
		pnlAdditionalDocumentation.add(txtrTheFollowingDocuments);
		
		chckbxCertifiedTranscript = new JCheckBox("Certified Transcript");
		//chckbxCertifiedTranscript.setSelected(application.getStudyProgram().requireTranscript());
		chckbxCertifiedTranscript.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxCertifiedTranscript.setEnabled(false);
		chckbxCertifiedTranscript.setBounds(10, 45, 141, 23);
		pnlAdditionalDocumentation.add(chckbxCertifiedTranscript);
		
		chckbxCurriculumVitaecv = new JCheckBox("Curriculum Vitae (CV)");
		//chckbxCurriculumVitaecv.setSelected(application.getStudyProgram().requireCV());
		chckbxCurriculumVitaecv.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxCurriculumVitaecv.setEnabled(false);
		chckbxCurriculumVitaecv.setBounds(232, 45, 141, 23);
		pnlAdditionalDocumentation.add(chckbxCurriculumVitaecv);
		
		chckbxResearchStatement = new JCheckBox("Research Statement");
		//chckbxResearchStatement.setSelected(application.getStudyProgram().requireResearchStatement());
		chckbxResearchStatement.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxResearchStatement.setEnabled(false);
		chckbxResearchStatement.setBounds(10, 71, 141, 23);
		pnlAdditionalDocumentation.add(chckbxResearchStatement);
		
		chckbxRefereesNames = new JCheckBox("Referees' Names");
		//chckbxRefereesNames.setSelected(application.getStudyProgram().requireRefereesNames());
		chckbxRefereesNames.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxRefereesNames.setEnabled(false);
		chckbxRefereesNames.setBounds(232, 69, 141, 23);
		pnlAdditionalDocumentation.add(chckbxRefereesNames);
		
		chckbxMotivation = new JCheckBox("Motivation");
		//chckbxMotivation.setSelected(application.getStudyProgram().requireMotivation());
		chckbxMotivation.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxMotivation.setEnabled(false);
		chckbxMotivation.setBounds(232, 95, 141, 23);
		pnlAdditionalDocumentation.add(chckbxMotivation);
		
		lblPdfOfAdditional = new JLabel("PDF of Additional Documentation:");
		lblPdfOfAdditional.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPdfOfAdditional.setBounds(10, 170, 204, 23);
		pnlAdditionalDocumentation.add(lblPdfOfAdditional);
		
		btnChoosePDF = new JButton("Choose File");
		btnChoosePDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(); //create a file chooser
				fileChooser.setFileFilter(new FileExtensionFilter(".pdf"));
				int returnVal = fileChooser.showOpenDialog(frmSchoolOfIt); //show file chooser for selecting file
				if (returnVal == JFileChooser.APPROVE_OPTION) //user has selected file
				{
					File file = fileChooser.getSelectedFile(); //fetch file chosen
					String fileName = file.getName(); //get name of file
					lblPDFName.setText(fileName); //name of file
					appController.chosenPDF(file);//prepare file for upload
					application.setPdfName(file.getName());
					application.setPdfPath(file.toString());
					btnUploadFile.setVisible(true);
				}
				}
			});
		
		btnChoosePDF.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnChoosePDF.setBounds(202, 194, 119, 23);
		pnlAdditionalDocumentation.add(btnChoosePDF);
		
		btnUploadFile = new JButton("Upload File");
		btnUploadFile.setVisible(false);
		btnUploadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!appController.uploadPDF(lblPDFName.getText()))
				{
					//show error
				}
				btnUploadFile.setVisible(false);
			}
			});
		btnUploadFile.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnUploadFile.setBounds(202, 225, 119, 23);
		pnlAdditionalDocumentation.add(btnUploadFile);
		
		lblPDFName = new JLabel("");
		lblPDFName.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPDFName.setBounds(224, 170, 204, 23);
		pnlAdditionalDocumentation.add(lblPDFName);
		
		btnDownloadPDF = new JButton("Download File");
		btnDownloadPDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(); //create JFileChooser for user to indicate location to save file.
				fileChooser.setDialogTitle("Specify location to save PDF of Application Details");   
				fileChooser.setFileFilter(new FileExtensionFilter(".pdf"));
				int returnVal = fileChooser.showSaveDialog(frmSchoolOfIt); //show save dialog
				 
				if (returnVal == JFileChooser.APPROVE_OPTION) { //if the user has selected a location and filename
				    File fileToSave = fileChooser.getSelectedFile(); //get information about file
				    appController.downloadPDF(applicant.getApplicantNumber(), fileToSave);
				}
				
			}
		});
		btnDownloadPDF.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnDownloadPDF.setBounds(330, 192, 119, 23);
		pnlAdditionalDocumentation.add(btnDownloadPDF);
		
		chkbxFundingStatement = new JCheckBox("Funding Statement");
		//chkbxFundingStatement.setSelected(application.getStudyProgram().requireFundingStatement());
		chkbxFundingStatement.setFont(new Font("Calibri", Font.PLAIN, 12));
		chkbxFundingStatement.setEnabled(false);
		chkbxFundingStatement.setBounds(10, 95, 141, 23);
		pnlAdditionalDocumentation.add(chkbxFundingStatement);
		
		pnlApplicationFieldCats = new JPanel();
		pnlApplicationFieldCats.setBounds(32, 76, 193, 162);
		pnlApplicationUI.add(pnlApplicationFieldCats);
		pnlApplicationFieldCats.setLayout(null);
		
		mntmPersonalDetails = new JMenuItem("Personal Details");
		mntmPersonalDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmPersonalDetails.setFont(new Font("Calibri", Font.BOLD, 12));
				mntmContactDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmTertiaryQual.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
				
				showPersonalDetails();
			}
		});
		mntmPersonalDetails.setBounds(0, 0, 190, 26);
		mntmPersonalDetails.setIcon(null);
		pnlApplicationFieldCats.add(mntmPersonalDetails);
		mntmPersonalDetails.setFont(new Font("Calibri", Font.BOLD, 12));
		
		mntmContactDetails = new JMenuItem("Contact Details");
		mntmContactDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmPersonalDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmContactDetails.setFont(new Font("Calibri", Font.BOLD, 12));
				mntmTertiaryQual.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
				
				showContactDetails();
			}
		});
		mntmContactDetails.setBounds(0, 30, 190, 26);
		mntmContactDetails.setHorizontalAlignment(SwingConstants.LEFT);
		mntmContactDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		pnlApplicationFieldCats.add(mntmContactDetails);
		
		mntmTertiaryQual = new JMenuItem("Tertiary Qualifications");
		mntmTertiaryQual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmPersonalDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmContactDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmTertiaryQual.setFont(new Font("Calibri", Font.BOLD, 12));
				mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
				
				showTertiaryQualifications();
			}
		});
		mntmTertiaryQual.setBounds(-1, 61, 191, 26);
		mntmTertiaryQual.setHorizontalAlignment(SwingConstants.LEFT);
		mntmTertiaryQual.setFont(new Font("Calibri", Font.PLAIN, 12));
		pnlApplicationFieldCats.add(mntmTertiaryQual);
		
		mntmProgrammeOfStudy = new JMenuItem("Programme of Study");
		mntmProgrammeOfStudy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmPersonalDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmContactDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmTertiaryQual.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.BOLD, 12));
				mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
				
				showStudyProgram();
			}
		});
		mntmProgrammeOfStudy.setBounds(-1, 98, 191, 26);
		mntmProgrammeOfStudy.setHorizontalAlignment(SwingConstants.LEFT);
		mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
		pnlApplicationFieldCats.add(mntmProgrammeOfStudy);
		
		mntmRequiredDocumentation = new JMenuItem("Additional Documentation");
		mntmRequiredDocumentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mntmPersonalDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmContactDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmTertiaryQual.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
				mntmRequiredDocumentation.setFont(new Font("Calibri", Font.BOLD, 12));
				
				showAdditionalDocumentation();
			}
		});
		mntmRequiredDocumentation.setHorizontalAlignment(SwingConstants.LEFT);
		mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmRequiredDocumentation.setBounds(0, 131, 190, 26);
		pnlApplicationFieldCats.add(mntmRequiredDocumentation);
		
		btnNewButton = new JButton("Previous");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pnlPersonalDetails.isVisible())
				{
					if (checkPersonalDetails())
					{
						pnlPersonalDetails.setVisible(false);
					}
				}
				else if (pnlContactDetails.isVisible())
				{
					if (checkContactDetails())
					{
						pnlContactDetails.setVisible(false);
						showPersonalDetails();
					}
				}
				else if (pnlTertiaryQualifications.isVisible())
				{
					if (checkQualificationDetails())
					{
					pnlTertiaryQualifications.setVisible(false);
					showContactDetails();
					}
				}
				else if (pnlProgrammeOfStudy.isVisible())
				{
					if (checkStudyProgramDetails())
					{
						pnlProgrammeOfStudy.setVisible(false);
						showTertiaryQualifications();
					}
				}
				else if (pnlAdditionalDocumentation.isVisible())
				{
					if (checkAdditionalDocuments())
					{
					pnlAdditionalDocumentation.setVisible(false);
					showStudyProgram();
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnNewButton.setBounds(42, 249, 89, 23);
		pnlApplicationUI.add(btnNewButton);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (pnlPersonalDetails.isVisible())
				{
					if (checkPersonalDetails())
					{
						pnlPersonalDetails.setVisible(false);
						showContactDetails();
					}
				}
				else if (pnlContactDetails.isVisible())
				{
					if (checkContactDetails())
					{
						pnlContactDetails.setVisible(false);
						showTertiaryQualifications();
					}
				}
				else if (pnlTertiaryQualifications.isVisible())
				{
					if (checkQualificationDetails())
					{
						pnlTertiaryQualifications.setVisible(false);
						showStudyProgram();
					}
				}
				else if (pnlProgrammeOfStudy.isVisible())
				{
					if (checkStudyProgramDetails())
					{
						pnlProgrammeOfStudy.setVisible(false);
						showAdditionalDocumentation();
					}
				}
				else if (pnlAdditionalDocumentation.isVisible())
				{
					if (checkAdditionalDocuments())
					{
						pnlAdditionalDocumentation.setVisible(false);
					}
				}
			}
		});
		btnNext.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnNext.setBounds(136, 249, 89, 23);
		pnlApplicationUI.add(btnNext);
		
		btnSaveUpdate = new JButton("Save / Update");
		btnSaveUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (applicant.getCitizenship().equals(""))
				{
					
					userController.insertOrUpdateApplicant(applicant);
				}
				else if (applicant.getCitizenship().equals("International"))
				{
					if (intApplicant.getResidenceAddress().equals(null)) {intApplicant.setResidenceAddress(applicant.getResidenceAddress());}   
					if (intApplicant.getPreviousQualification().equals(null)) {intApplicant.setPreviousQualification(applicant.getPreviousQualification()); }
					userController.insertOrUpdateInternationalApplicant(intApplicant);
				}
				else
				{
					if (rsaApplicant.getResidenceAddress().equals(null)) {rsaApplicant.setResidenceAddress(applicant.getResidenceAddress());}   
					if (rsaApplicant.getPreviousQualification().equals(null)) {rsaApplicant.setPreviousQualification(applicant.getPreviousQualification()); }
					userController.insertOrUpdateSouthAfricanApplicant(rsaApplicant);
				}
				
				appController.insertOrUpdateApplication(application);
			}
		});
		btnSaveUpdate.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnSaveUpdate.setBounds(42, 283, 89, 23);
		pnlApplicationUI.add(btnSaveUpdate);
		
		btnSubmitReturn = new JButton("Submit / Return");
		if (bApplicantSignedIn)
		{
			if (application.getApplicationStatus().getStatusDescripition().equalsIgnoreCase("Created"))
			{
				btnSubmitReturn.setText("Submit");
			}
			else
			{
				btnSubmitReturn.setText("Return");
			}
		}
		else
		{
			btnSubmitReturn.setText("Return");
		}
		btnSubmitReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bApplicantSignedIn && application.getApplicationStatus().getStatusDescripition().equalsIgnoreCase("Created")) //new application -> submit
				{
					if (applicant.getCitizenship().equals(""))
					{
						userController.insertOrUpdateApplicant(applicant);
					}
					else if (applicant.getCitizenship().equals("International"))
					{
						if (intApplicant.getResidenceAddress().equals(null)) {intApplicant.setResidenceAddress(applicant.getResidenceAddress());}   
						if (intApplicant.getPreviousQualification().equals(null)) {intApplicant.setPreviousQualification(applicant.getPreviousQualification()); }
						userController.insertOrUpdateInternationalApplicant(intApplicant);
					}
					else
					{
						if (rsaApplicant.getResidenceAddress().equals(null)) {rsaApplicant.setResidenceAddress(applicant.getResidenceAddress());}   
						if (rsaApplicant.getPreviousQualification().equals(null)) {rsaApplicant.setPreviousQualification(applicant.getPreviousQualification()); }
						userController.insertOrUpdateSouthAfricanApplicant(rsaApplicant);
					}
					
					appController.submitApplication(application);
				}
				else if (bApplicantSignedIn)//existing application
				{
					showApplicantEntryInterface();
				}
				else
				{
					showAcademicEntryInterface();
				}
			}
		});
		btnSubmitReturn.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnSubmitReturn.setBounds(136, 283, 89, 23);
		pnlApplicationUI.add(btnSubmitReturn);
		
		btnChangeStatus = new JButton("Change Status");
		btnChangeStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnChangeStatus.getText().equals("Change Status"))
				{
					btnChangeStatus.setText("Commit Appl. Status Changes");
					
					cbxApplicationApplicationStatus.setSelectedItem(txtApplicationStatus.getText().trim());
					cbxApplicationApplicationStatus.setVisible(true);
					txtApplicationStatus.setVisible(false);
					
					cbxApplicationStatusReason.setSelectedItem(txtApplicationReasonStatus.getText().trim());
					cbxApplicationStatusReason.setVisible(true);
					txtStatusReason.setVisible(false);
				}
				else
				{
					btnChangeStatus.setText("Change Status");
					
					String status = cbxApplicationApplicationStatus.getSelectedItem().toString();
					txtApplicationStatus.setText(status);
					cbxApplicationApplicationStatus.setVisible(false);
					txtApplicationStatus.setVisible(true);
					
					String reason = cbxApplicationStatusReason.getSelectedItem().toString();
					txtApplicationReasonStatus.setText(reason);
					cbxApplicationStatusReason.setVisible(false);
					txtStatusReason.setVisible(true);
					
					application.setApplicationStatus(new ApplicationStatus(status, reason));
				}
			}
		});
		btnChangeStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnChangeStatus.setBounds(44, 349, 181, 23);
		pnlApplicationUI.add(btnChangeStatus);
		
		btnPdfOfApplication = new JButton("PDF of Application Details");
		btnPdfOfApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(); //create JFileChooser for user to indicate location to save file.
				fileChooser.setDialogTitle("Specify location to save PDF of Application Details");   
				fileChooser.setFileFilter(new FileExtensionFilter(".pdf"));
				int returnVal = fileChooser.showSaveDialog(frmSchoolOfIt); //show save dialog
				 
				if (returnVal == JFileChooser.APPROVE_OPTION) { //if the user has selected a location and filename
				    File fileToSave = fileChooser.getSelectedFile(); //get information about file
				    appController.requestPDFofApplicantDetails(applicant.getApplicantNumber(), appController.getApplicationOfApplicant(applicant.getApplicantNumber()).getApplicationNumber(), fileToSave);
				}
				
			}
		});
		btnPdfOfApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnPdfOfApplication.setBounds(44, 315, 181, 23);
		pnlApplicationUI.add(btnPdfOfApplication);
		
		lblApplicationNumber = new JLabel("Application Number:");
		lblApplicationNumber.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblApplicationNumber.setBounds(32, 6, 199, 23);
		pnlApplicationUI.add(lblApplicationNumber);
		
		lblApplicationApplicationStatus = new JLabel("Application Status:");
		lblApplicationApplicationStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblApplicationApplicationStatus.setBounds(32, 40, 158, 14);
		pnlApplicationUI.add(lblApplicationApplicationStatus);
		
		lblApplicationReasonForStatus = new JLabel("Reason for Status:");
		lblApplicationReasonForStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblApplicationReasonForStatus.setBounds(32, 59, 158, 14);
		pnlApplicationUI.add(lblApplicationReasonForStatus);
		
		txtApplicationNumber = new JTextField();
		txtApplicationNumber.setEditable(false);
		txtApplicationNumber.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtApplicationNumber.setBounds(232, 5, 273, 20);
		pnlApplicationUI.add(txtApplicationNumber);
		txtApplicationNumber.setColumns(10);
		
		txtApplicationStatus = new JTextField();
		txtApplicationStatus.setEditable(false);
		txtApplicationStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtApplicationStatus.setColumns(10);
		txtApplicationStatus.setBounds(232, 35, 273, 20);
		pnlApplicationUI.add(txtApplicationStatus);
		
		txtApplicationReasonStatus = new JTextField();
		txtApplicationReasonStatus.setEditable(false);
		txtApplicationReasonStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtApplicationReasonStatus.setColumns(10);
		txtApplicationReasonStatus.setBounds(232, 56, 273, 20);
		pnlApplicationUI.add(txtApplicationReasonStatus);
		
		cbxApplicationApplicationStatus = new JComboBox<String>();
		populateComboBox(cbxApplicationApplicationStatus, "ApplicationStatusesForCombo.txt");
		cbxApplicationApplicationStatus.setFont(new Font("Calibri", Font.PLAIN, 11));
		cbxApplicationApplicationStatus.setBounds(232, 34, 273, 22);
		cbxApplicationApplicationStatus.setVisible(false);
		cbxApplicationApplicationStatus.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				application.changeStatus(cbxApplicationApplicationStatus.getSelectedItem().toString().trim());
			}
		});
		
				pnlApplicationUI.add(cbxApplicationApplicationStatus);
				
				cbxApplicationStatusReason = new JComboBox<String>();
				populateComboBox(cbxApplicationStatusReason, "StatusReasonsForCombo.txt");
				cbxApplicationStatusReason.setFont(new Font("Calibri", Font.PLAIN, 11));
				cbxApplicationStatusReason.setBounds(232, 59, 273, 22);
				cbxApplicationStatusReason.setVisible(false);
				cbxApplicationApplicationStatus.addFocusListener(new FocusAdapter() {
					public void focusLost(FocusEvent e) {
						application.addReasonForStatus(cbxApplicationStatusReason.getSelectedItem().toString().trim());
					}
				});
				pnlApplicationUI.add(cbxApplicationStatusReason);
				//String sDegCountry = cbxDegCountry.getSelectedItem().toString().trim();
		//btnViewApplication.setEnabled(!tblApplications.getSelectionModel().isSelectionEmpty());
		frmSchoolOfIt.getContentPane().add(pnlApplicantEntry);
		pnlApplicantEntry.setLayout(null);
		
		lblApplicantApplicationNumber = new JLabel("Application Number:");
		lblApplicantApplicationNumber.setFont(new Font("Calibri", Font.PLAIN, 16));
		lblApplicantApplicationNumber.setBounds(31, 12, 199, 23);
		pnlApplicantEntry.add(lblApplicantApplicationNumber);
		
		txtApplicantApplicationNumber = new JTextField();
		txtApplicantApplicationNumber.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtApplicantApplicationNumber.setEditable(false);
		txtApplicantApplicationNumber.setColumns(10);
		txtApplicantApplicationNumber.setBounds(231, 11, 273, 20);
		pnlApplicantEntry.add(txtApplicantApplicationNumber);
		
		txtApplicantApplicationStatus = new JTextField();
		txtApplicantApplicationStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtApplicantApplicationStatus.setEditable(false);
		txtApplicantApplicationStatus.setColumns(10);
		txtApplicantApplicationStatus.setBounds(231, 41, 273, 20);
		pnlApplicantEntry.add(txtApplicantApplicationStatus);
		
		lblApplicantApplicationStatus = new JLabel("Application Status:");
		lblApplicantApplicationStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblApplicantApplicationStatus.setBounds(31, 46, 158, 14);
		pnlApplicantEntry.add(lblApplicantApplicationStatus);
		
		lblStatusReason = new JLabel("Reason for Status:");
		lblStatusReason.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblStatusReason.setBounds(31, 65, 158, 14);
		pnlApplicantEntry.add(lblStatusReason);
		
		txtStatusReason = new JTextField();
		txtStatusReason.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtStatusReason.setEditable(false);
		txtStatusReason.setColumns(10);
		txtStatusReason.setBounds(231, 62, 273, 20);
		pnlApplicantEntry.add(txtStatusReason);
		
		txtrMessage = new JTextArea();
		txtrMessage.setLineWrap(true);
		txtrMessage.setWrapStyleWord(true);
		txtrMessage.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		txtrMessage.setBounds(31, 90, 661, 105);
		pnlApplicantEntry.add(txtrMessage);
		
		btnViewApplication = new JButton("View Application");
		btnViewApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateApplicationFields(applicant, application);
				showPersonalDetails();
			}
		});
		btnViewApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnViewApplication.setBounds(281, 220, 141, 23);
		pnlApplicantEntry.add(btnViewApplication);
		
		btnEditApplication = new JButton("Edit Application");
		btnEditApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateApplicationFields(applicant, application);
				showPersonalDetails();
			}
		});
		btnEditApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnEditApplication.setBounds(281, 260, 141, 23);
		pnlApplicantEntry.add(btnEditApplication);
		
		btnRemoveApplication = new JButton("Remove Application");
		btnRemoveApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.changeStatus("Withdrawn");
				application.addReasonForStatus("Applicant withdraws application");
				showSignInInterface();
			}
		});
		btnRemoveApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnRemoveApplication.setBounds(281, 294, 141, 23);
		pnlApplicantEntry.add(btnRemoveApplication);
		
		JButton btnLogOut_1 = new JButton("Log Out");
		btnLogOut_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnLogOut_1.setBounds(281, 328, 141, 23);
		btnRemoveApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSignInInterface();
			}
		});
		pnlApplicantEntry.add(btnLogOut_1);
		frmSchoolOfIt.getContentPane().add(pnlAcademicEntryUI);
		pnlAcademicEntryUI.setLayout(null);
		
		tblApplications = new JTable();
		tblApplications.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//fetch application
				
				//check if application is viewable
			}
		});
		tblApplications.setFont(new Font("Calibri", Font.PLAIN, 12));
		DefaultTableModel model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Application #", "Applicant #", "Application Status", "Previous Qualification", "Instituition of Previous Qualification", "Programme of Study"  
				}
			); 
		tblApplications.setModel(appController.populateApplicationsTable(model));
		tblApplications.getColumnModel().getColumn(0).setPreferredWidth(89);
		tblApplications.getColumnModel().getColumn(3).setPreferredWidth(116);
		tblApplications.getColumnModel().getColumn(4).setPreferredWidth(106);
		tblApplications.getColumnModel().getColumn(5).setResizable(false);
		tblApplications.setBounds(33, 36, 661, 220);
		tblApplications.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {
				      public void valueChanged(ListSelectionEvent e) {
				    	  applicant = userController.getApplicant(tblApplications.getValueAt(tblApplications.getSelectedRow(), 1).toString().trim());
				    	  userController.setApplicantOfFocus(applicant);
				    	  application = appController.getApplicationOfApplicant(applicant.getApplicantNumber());
				    	  appController.setApplicationOfFocus(application);
				    	  if (applicant.getCitizenship().equals("International"))
				    	  {
				    		  intApplicant = userController.getInternationalApplicant(applicant.getApplicantNumber());
				    		  userController.setInternationalApplicantOfFocus(intApplicant);
				    	  }
				    	  else if (applicant.getCitizenship().contains("South African"))
				    	  {
				    		  rsaApplicant = userController.getSouthAfricanApplicant(applicant.getApplicantNumber());
				    		  userController.setSouthAfricanApplicantOfFocus(rsaApplicant);
				    	  }
				      }}
				);
		pnlAcademicEntryUI.add(tblApplications);
		
		btnChooseCSV = new JButton("Choose CSV");
		btnChooseCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(); //create a file chooser
				fileChooser.setFileFilter(new FileExtensionFilter(".csv"));
				int returnVal = fileChooser.showOpenDialog(frmSchoolOfIt); //show file chooser for selecting file
				if (returnVal == JFileChooser.APPROVE_OPTION)  //user has selected file
				{
					File file = fileChooser.getSelectedFile(); //fetch file chosen
					String fileName = file.getName(); //get name of file
					lblNameOfCSVFile.setText(fileName); //name of file
					appController.chosenCSV(file); //prepare file for upload
					btnUploadCsv.setVisible(true);
				}
			}
		});
		btnChooseCSV.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnChooseCSV.setBounds(33, 333, 246, 23);
		pnlAcademicEntryUI.add(btnChooseCSV);
		
		lblUploadCSVMessage = new JLabel("Upload CSV to Notify Potential Applicants to Apply:");
		lblUploadCSVMessage.setBounds(33, 304, 258, 14);
		pnlAcademicEntryUI.add(lblUploadCSVMessage);
		
		btnUploadCsv = new JButton("Upload CSV");
		btnUploadCsv.setVisible(false);
		btnUploadCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appController.notifyApplicants(lblNameOfCSVFile.getText().toString().trim());
				btnUploadCsv.setVisible(false);
			}
		});
		btnUploadCsv.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnUploadCsv.setBounds(33, 367, 246, 23);
		pnlAcademicEntryUI.add(btnUploadCsv);
		
		lblSelectFieldValues = new JLabel("Select Field Values to Generate CSV:");
		lblSelectFieldValues.setBounds(402, 264, 282, 14);
		pnlAcademicEntryUI.add(lblSelectFieldValues);
		
		btnGenerateCsv = new JButton("Generate CSV");
		btnGenerateCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					JFileChooser fileChooser = new JFileChooser(); //create JFileChooser for user to indicate location to save file.
					fileChooser.setDialogTitle("Specify location to save CSV of Applicants");  
					fileChooser.setFileFilter(new FileExtensionFilter(".csv"));
					
					int returnVal = fileChooser.showSaveDialog(frmSchoolOfIt); //show save dialog
					 
					if (returnVal == JFileChooser.APPROVE_OPTION) { //if the user has selected a location and filename
					    File fileToSave = fileChooser.getSelectedFile(); //get information about file
					    
					   
					    appController.getFilteredApplicantListAsCSV(appController.getFilteredList(cbxStudyPrograms.getSelectedItem().toString().trim(), cbxLevel.getSelectedItem().toString().trim(),cbxApplicationStatus.getSelectedItem().toString().trim()), fileToSave);
					}
				}
			}
		});
		btnGenerateCsv.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnGenerateCsv.setBounds(406, 364, 282, 23);
		pnlAcademicEntryUI.add(btnGenerateCsv);
		
		lblApplicationStatus = new JLabel("Application Status");
		lblApplicationStatus.setBounds(412, 335, 107, 14);
		pnlAcademicEntryUI.add(lblApplicationStatus);
		
		lblLevelOfStudy = new JLabel("Level of Study Program:");
		lblLevelOfStudy.setBounds(412, 308, 282, 14);
		pnlAcademicEntryUI.add(lblLevelOfStudy);
		
		lblAcademicEntryMessage = new JLabel("Select an applicant to view its details:");
		lblAcademicEntryMessage.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAcademicEntryMessage.setBounds(33, 11, 341, 23);
		pnlAcademicEntryUI.add(lblAcademicEntryMessage);
		
		cbxStudyPrograms = new JComboBox<String>();
		populateComboBox(cbxStudyPrograms, "DegreesForFilters.txt");
		cbxStudyPrograms.setBounds(537, 277, 157, 22);
		pnlAcademicEntryUI.add(cbxStudyPrograms);
		
		lblStudyProgram = new JLabel("Study Program:");
		lblStudyProgram.setBounds(412, 281, 282, 14);
		pnlAcademicEntryUI.add(lblStudyProgram);
		
		cbxLevel = new JComboBox<String>();
		populateComboBox(cbxLevel, "Levels.txt");
		cbxLevel.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxLevel.setBounds(537, 304, 157, 22);
		pnlAcademicEntryUI.add(cbxLevel);
		
		cbxApplicationStatus = new JComboBox<String>();
		populateComboBox(cbxStudyPrograms, "ApplicationStatusesForFilters.txt");
		cbxApplicationStatus.setBounds(537, 331, 157, 22);
		pnlAcademicEntryUI.add(cbxApplicationStatus);
		
		lblNameOfCSVFile = new JLabel("");
		lblNameOfCSVFile.setBounds(287, 333, 98, 23);
		pnlAcademicEntryUI.add(lblNameOfCSVFile   );
		
		JButton btnViewApplication_1 = new JButton("View Application");
		btnViewApplication_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateApplicationFields(applicant, application);
				showPersonalDetails();
			}
		});
		btnViewApplication_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnViewApplication_1.setBounds(33, 267, 246, 23);
		pnlAcademicEntryUI.add(btnViewApplication_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnLogOut.setBounds(509, 11, 107, 23);
		btnViewApplication_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showSignInInterface();
			}
		});
		pnlAcademicEntryUI.add(btnLogOut);
	}
	
	/**
	 * Method sets form such as to allow for sign up.
	 */
	public void prepareSignUp()
	{
		bSignIn = false;
		lblNewMessage.setVisible(false); 
		btnGoToSignUpProcess.setVisible(false);
		btnSign.setText("Sign-Up");
	}
	
	/**
	 * Method populates application field values with the current information of the applicant and their application
	 * @param anApplicant Specified Applicant whose fields / characteristics should be used to populate UI fields.
	 * @param theirApplication Specified Application of the Applicant that will be used to populate UI Fields.
	 */
	public void populateApplicationFields(Applicant anApplicant, Application theirApplication)
	{
		txtApplicationNumber.setText(theirApplication.getApplicationNumber());
		txtApplicationStatus.setText(theirApplication.getApplicationStatus().getStatusDescripition());
		txtApplicationReasonStatus.setText(theirApplication.getApplicationStatus().getReasonDescription());
		txtApplicantApplicationNumber.setText(theirApplication.getApplicationNumber());
		txtApplicantApplicationStatus.setText(theirApplication.getApplicationStatus().getStatusDescripition());
		txtStatusReason.setText(theirApplication.getApplicationStatus().getReasonDescription());
		txtrMessage.setText(theirApplication.getApplicationStatus().generateMessageForApplicant());
		
		txtApplicantNumber.setText(anApplicant.getApplicantNumber());
		txtSurname.setText(anApplicant.getSurname());
		txtFirstName.setText(anApplicant.getFirstName());
		cbxTitle.setSelectedItem(anApplicant.getTitle());
		cbxCitizenship.setSelectedItem(anApplicant.getCitizenship());
		cbxCountry.setSelectedItem(anApplicant.getCitizenshipCountry());
		
		txtEmail.setText(anApplicant.getEmail());
		txtCellphone.setText(anApplicant.getCellPhone());
		txtrLineAddress.setText(anApplicant.getResidenceAddress().getLineAddress());
		cbxResCountry.setSelectedItem(anApplicant.getResidenceAddress().getCountry());
		
		txtDegUniversity.setText(anApplicant.getPreviousQualification().getTertiaryInstitution());
		
		if (itemListedInComboBox(anApplicant.getPreviousQualification().getCountry(), cbxDegCountry))
		{
			cbxDegCountry.setSelectedItem(anApplicant.getPreviousQualification().getCountry());
		}
		else
		{
			cbxDegCountry.setSelectedItem("Other");
			lbldegCountry.setVisible(true);
			txtDegCountryOther.setText(anApplicant.getPreviousQualification().getCountry());
			
		}
		if (itemListedInComboBox(anApplicant.getPreviousQualification().getDegree(), cbxDegree)) 
		{
			cbxDegree.setSelectedItem(anApplicant.getPreviousQualification().getDegree());
		}
		else
		{
			cbxDegree.setSelectedItem("Other");
			lblDegOther.setVisible(true);
			txtDegOther.setText(anApplicant.getPreviousQualification().getDegree());
		}
		cbxNQF.setSelectedItem(anApplicant.getPreviousQualification().getDegree());
		spnMinDuration.setValue(anApplicant.getPreviousQualification().getMinDuration());
		
		
		if (itemListedInComboBox(theirApplication.getStudyProgram().getAcademicQualification(), cbxStudyProgram))
		{
			cbxStudyProgram.setSelectedItem(theirApplication.getStudyProgram().getAcademicQualification());
		}
		else
		{
			cbxStudyProgram.setSelectedItem("Other");
			lblIfOtherSpecify.setVisible(true);
			txtStudyProgramOther.setText(theirApplication.getStudyProgram().getAcademicQualification());
		}
		
		chckbxCertifiedTranscript.setSelected(theirApplication.getStudyProgram().requireTranscript());
		chckbxCurriculumVitaecv.setSelected(theirApplication.getStudyProgram().requireCV());
		chckbxResearchStatement.setSelected(theirApplication.getStudyProgram().requireResearchStatement());
		chckbxRefereesNames.setSelected(theirApplication.getStudyProgram().requireRefereesNames());
		chkbxFundingStatement.setSelected(theirApplication.getStudyProgram().requireFundingStatement());
		chckbxMotivation.setSelected(theirApplication.getStudyProgram().requireMotivation());
		//lblPDFName
		
		//Determine if South African or International Applicant
		if (applicant.getCitizenship().equals("International")) //International Applicant
		{
			intApplicant = userController.getInternationalApplicant(anApplicant.getApplicantNumber());
			userController.setInternationalApplicantOfFocus(intApplicant);
			lblIdPassport.setText("Passport Number:");
			lblIdPassport.setVisible(true);
			txtIDPassport.setText(intApplicant.getPassport());	
			
		}
		else if (applicant.getCitizenship().contains("South African"))//South African Applicant
		{
			rsaApplicant = userController.getSouthAfricanApplicant(anApplicant.getApplicantNumber());
			userController.setSouthAfricanApplicantOfFocus(rsaApplicant);
			lblIdPassport.setText("ID number:");
			lblIdPassport.setVisible(true);
			System.out.println(rsaApplicant == null);
			txtIDPassport.setText(rsaApplicant.getID());
			lblRace.setVisible(true);
			cbxRace.setSelectedItem(((SouthAfricanApplicant) anApplicant).getRace());
		}
		
		//check for MIT application
		if (theirApplication.getStudyProgram().equals("Masters in Information Technology (MIT)"))
		{
			lblPriorItExperience.setVisible(true);
			spnYearsITExperience.setValue(((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getPriorITExperience());
			
			lblLevelOfUndergraduate.setVisible(true);
			lblAveragesPerMathematics.setVisible(false);
			lblAverageMathLevel1.setVisible(false);
			lblAverageMathLevel2.setVisible(false);
			lblAverageMathLevel3.setVisible(false);
			spnLevelUndergrad.setValue(((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getHighestLevelUndergradMathematcs());
			if (((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getHighestLevelUndergradMathematcs() > 0)
			{
				lblAverageMathLevel1.setVisible(true);
				txtAverageMathLevel1.setText(String.valueOf(((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getUndergradMaths()[1].getAverage()));
			}
			if (((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getHighestLevelUndergradMathematcs() > 1)
			{
				lblAverageMathLevel2.setVisible(true);
				txtAverageMathLevel2.setText(String.valueOf(((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getUndergradMaths()[2].getAverage()));
			}
			if (((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getHighestLevelUndergradMathematcs() > 2)
			{
				lblAverageMathLevel2.setVisible(true);
				txtAverageMathLevel3.setText(String.valueOf(((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getUndergradMaths()[3].getAverage()));
			}	
			
			if (((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).hasProjectThesis())
			{
				
				chckbxPreviousDegreeHadProjectThesis.setSelected(true);
				txtrProvideBriefDescription.setText(((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getDescriptionProjectThesis());
			}
			else
			{
				
				chckbxPreviousDegreeHadProjectThesis.setSelected(false);
			}
		}	
		
		lblPDFName.setText(theirApplication.getPdfName());
	}
	
	private void populateComboBox(JComboBox<String> comboBox, String fileName)
	{
		//clean combo box to avoid duplicates
		comboBox.removeAllItems();
		
		//read items
		Scanner comboItems = null;
		System.out.println(fileName);
		try
		{
			comboItems = new Scanner(new FileReader(fileName));
			
			
			while (comboItems.hasNextLine())
			{
				comboBox.addItem(comboItems.nextLine().trim());
			}
		}
		catch(IOException e)
		{
			System.out.println("Error in populating combo box.");
		}
		finally
		{
			if (comboItems != null)
			{
				comboItems.close();
			}
		}
		
		//no item selected initially
		comboBox.setSelectedIndex(-1);
	}
	
	private boolean itemListedInComboBox(String item, JComboBox<String> comboBox)
	{
		boolean bFound = false;
		
		int index = 0;
		
		while ((!bFound) && (index < comboBox.getItemCount()))
		{
			if (comboBox.getItemAt(index).equals(item)) {bFound = true;}
			index++;
		}
		
		return bFound;
	}
	
	private void showSignInInterface()
	{
		data.writeDataBack();
		pnlSignInUI.setVisible(true);
		pnlApplicationUI.setVisible(false);
		pnlApplicantEntry.setVisible(false);
		pnlAcademicEntryUI.setVisible(false);
		
		pnlApplicationFieldCats.setVisible(false);
		pnlPersonalDetails.setVisible(false);
		pnlContactDetails.setVisible(false);
		pnlTertiaryQualifications.setVisible(false);
		pnlProgrammeOfStudy.setVisible(false);
		pnlAdditionalDocumentation.setVisible(false);
		
		mntmPersonalDetails.setSelected(false);
		mntmContactDetails.setSelected(false);
		mntmTertiaryQual.setSelected(false);
		mntmProgrammeOfStudy.setSelected(false);
		mntmRequiredDocumentation.setSelected(false);
	}
	
	private void showAcademicEntryInterface()
	{
		pnlSignInUI.setVisible(false);
		pnlApplicationUI.setVisible(false);
		pnlApplicantEntry.setVisible(false);
		pnlAcademicEntryUI.setVisible(true);
		
		pnlApplicationFieldCats.setVisible(false);
		pnlPersonalDetails.setVisible(false);
		pnlContactDetails.setVisible(false);
		pnlTertiaryQualifications.setVisible(false);
		pnlProgrammeOfStudy.setVisible(false);
		pnlAdditionalDocumentation.setVisible(false);
		
		mntmPersonalDetails.setSelected(false);
		mntmContactDetails.setSelected(false);
		mntmTertiaryQual.setSelected(false);
		mntmProgrammeOfStudy.setSelected(false);
		mntmRequiredDocumentation.setSelected(false);
		
		lblNameOfCSVFile.setText("");
	}
	
	private void showApplicantEntryInterface()
	{
		pnlSignInUI.setVisible(false);
		pnlApplicationUI.setVisible(false);
		pnlApplicantEntry.setVisible(true);
		pnlAcademicEntryUI.setVisible(false);
		
		pnlApplicationFieldCats.setVisible(false);
		pnlPersonalDetails.setVisible(false);
		pnlContactDetails.setVisible(false);
		pnlTertiaryQualifications.setVisible(false);
		pnlProgrammeOfStudy.setVisible(false);
		pnlAdditionalDocumentation.setVisible(false);
		
		mntmPersonalDetails.setSelected(false);
		mntmContactDetails.setSelected(false);
		mntmTertiaryQual.setSelected(false);
		mntmProgrammeOfStudy.setSelected(false);
		mntmRequiredDocumentation.setSelected(false);
		
		
		if (appController.applicantionEditable(application.getApplicationNumber()))
		{
			btnEditApplication.setVisible(true);
		}
		else
		{
			btnEditApplication.setVisible(false);
		}
	}
	
	private void showPersonalDetails()
	{
		pnlSignInUI.setVisible(false);
		pnlApplicationUI.setVisible(true);
		pnlApplicantEntry.setVisible(false);
		pnlAcademicEntryUI.setVisible(false);
		
		pnlApplicationFieldCats.setVisible(true);
		pnlPersonalDetails.setVisible(true);
		pnlContactDetails.setVisible(false);
		pnlTertiaryQualifications.setVisible(false);
		pnlProgrammeOfStudy.setVisible(false);
		pnlAdditionalDocumentation.setVisible(false);
		
		mntmPersonalDetails.setSelected(true);
		mntmPersonalDetails.setFont(new Font("Calibri", Font.BOLD, 12));
		mntmContactDetails.setSelected(false);
		mntmTertiaryQual.setSelected(false);
		mntmProgrammeOfStudy.setSelected(false);
		mntmRequiredDocumentation.setSelected(false);
		
		btnNewButton.setEnabled(false);
		
		boolean bInternational = cbxCitizenship.getSelectedItem().equals("International");
		boolean bRSA = cbxCitizenship.getSelectedItem().toString().contains("South African");
		boolean bVisible = bInternational || bRSA;
		lblIdPassport.setVisible(bVisible);
		txtIDPassport.setVisible(bVisible);
		lblRace.setVisible(bRSA);
		cbxRace.setVisible(bRSA);
		if (bInternational)
		{
			lblIdPassport.setText("Passport");
		}
		else if (bRSA)
		{
			lblIdPassport.setText("ID");
		}
		
		if (!bApplicantSignedIn) //academic signed-in -> fields view only
		{
			txtApplicantNumber.setEditable(false);
			txtSurname.setEditable(false);
			txtFirstName.setEditable(false);
			cbxTitle.setEditable(false);
			cbxCitizenship.setEditable(false);
			cbxCountry.setEditable(false);
			txtIDPassport.setEditable(false);
			cbxRace.setEditable(false);
			btnPdfOfApplication.setVisible(true);
			btnChangeStatus.setVisible(true);
			
		}
		else //applicant signed in
		{
			boolean bEditable = (appController.applicantionEditable(application.getApplicationNumber()));
			
			txtApplicantNumber.setEditable(bEditable);
			txtSurname.setEditable(bEditable);
			txtFirstName.setEditable(bEditable);
			cbxTitle.setEditable(bEditable);
			cbxCitizenship.setEditable(bEditable);
			cbxCountry.setEditable(bEditable);
			txtIDPassport.setEditable(bEditable);
			cbxRace.setEditable(bEditable);
				
			if (application.getApplicationStatus().getStatusCode().equalsIgnoreCase("CRTD")) //new application
			{
				btnSaveUpdate.setText("Save");
				btnSubmitReturn.setText("Submit");
			}
			else //existing application
			{
				btnSaveUpdate.setText("Update");
				btnSubmitReturn.setText("Return");
			}
		}
		
	}
	
	private void showContactDetails()
	{
		btnNewButton.setEnabled(true);
		pnlSignInUI.setVisible(false);
		pnlApplicationUI.setVisible(true);
		pnlApplicantEntry.setVisible(false);
		pnlAcademicEntryUI.setVisible(false);
		
		pnlApplicationFieldCats.setVisible(true);
		pnlPersonalDetails.setVisible(false);
		pnlContactDetails.setVisible(true);
		pnlTertiaryQualifications.setVisible(false);
		pnlProgrammeOfStudy.setVisible(false);
		pnlAdditionalDocumentation.setVisible(false);
		
		mntmPersonalDetails.setSelected(false);
		mntmContactDetails.setSelected(true);
		mntmContactDetails.setFont(new Font("Calibri", Font.BOLD, 12));
		mntmTertiaryQual.setSelected(false);
		mntmProgrammeOfStudy.setSelected(false);
		mntmRequiredDocumentation.setSelected(false);
		
		//
		if (!bApplicantSignedIn) //academic signed-in -> fields view only
		{
			txtEmail.setEditable(false);
			txtCellphone.setEditable(false);
			txtrLineAddress.setEditable(false);
			cbxResCountry.setEditable(false);
			
		}
		else //applicant signed in
		{
			boolean bEditable = (appController.applicantionEditable(application.getApplicationNumber()));
			
			txtEmail.setEditable(bEditable);
			txtCellphone.setEditable(bEditable);
			txtrLineAddress.setEditable(bEditable);
			cbxResCountry.setEditable(bEditable);
				
			if (application.getApplicationStatus().getStatusCode().equalsIgnoreCase("CRTD")) //new application
			{
				btnSaveUpdate.setText("Save");
				btnSubmitReturn.setText("Submit");
			}
			else //existing application
			{
				btnSaveUpdate.setText("Update");
				btnSubmitReturn.setText("Return");
			}
		}
	}
	
	private void showTertiaryQualifications()
	{
		btnNewButton.setEnabled(true);
		pnlSignInUI.setVisible(false);
		pnlApplicationUI.setVisible(true);
		pnlApplicantEntry.setVisible(false);
		pnlAcademicEntryUI.setVisible(false);
		
		pnlApplicationFieldCats.setVisible(true);
		pnlPersonalDetails.setVisible(false);
		pnlContactDetails.setVisible(false);
		pnlTertiaryQualifications.setVisible(true);
		pnlProgrammeOfStudy.setVisible(false);
		pnlAdditionalDocumentation.setVisible(false);
		
		mntmPersonalDetails.setSelected(false);
		mntmContactDetails.setSelected(false);
		mntmTertiaryQual.setSelected(true);
		mntmTertiaryQual.setFont(new Font("Calibri", Font.BOLD, 12));
		mntmProgrammeOfStudy.setSelected(false);
		mntmRequiredDocumentation.setSelected(false);
		
		String sDegCountry = cbxDegCountry.getSelectedItem().toString().trim();
		txtDegCountryOther.setVisible(sDegCountry.equals("Other"));
		lblPreviousDegree.setVisible(sDegCountry.equals("Other"));
		
		String sDegree = cbxDegree.getSelectedItem().toString().trim();
		txtDegOther.setVisible(sDegree.equals("Other"));
		lblDegOther.setVisible(sDegree.equals("Other"));
		
		if (!bApplicantSignedIn) //academic signed-in -> fields view only
		{
			cbxDegCountry.setEditable(false);
			txtDegCountryOther.setEditable(false);
			cbxDegree.setEditable(false);
			txtDegOther.setEditable(false);
			cbxNQF.setEditable(false);
			spnMinDuration.setEnabled(false);
			txtDegUniversity.setEditable(false);
			
		}
		else //applicant signed in
		{
			boolean bEditable = (appController.applicantionEditable(application.getApplicationNumber()));
			
			cbxDegCountry.setEditable(bEditable);
			txtDegCountryOther.setEditable(bEditable);
			cbxDegree.setEditable(bEditable);
			txtDegOther.setEditable(bEditable);
			cbxNQF.setEditable(bEditable);
			spnMinDuration.setEnabled(bEditable);
			txtDegUniversity.setEditable(bEditable);
				
			if (application.getApplicationStatus().getStatusCode().equalsIgnoreCase("CRTD")) //new application
			{
				btnSaveUpdate.setText("Save");
				btnSubmitReturn.setText("Submit");
			}
			else //existing application
			{
				btnSaveUpdate.setText("Update");
				btnSubmitReturn.setText("Return");
			}
		}
		
	}
	
	private void showStudyProgram()
	{
		btnNewButton.setEnabled(true);
		pnlSignInUI.setVisible(false);
		pnlApplicationUI.setVisible(true);
		pnlApplicantEntry.setVisible(false);
		pnlAcademicEntryUI.setVisible(false);
		
		pnlApplicationFieldCats.setVisible(true);
		pnlPersonalDetails.setVisible(false);
		pnlContactDetails.setVisible(false);
		pnlTertiaryQualifications.setVisible(false);
		pnlProgrammeOfStudy.setVisible(true);
		pnlAdditionalDocumentation.setVisible(false);
		
		mntmPersonalDetails.setSelected(false);
		mntmContactDetails.setSelected(false);
		mntmTertiaryQual.setSelected(false);
		mntmProgrammeOfStudy.setSelected(true);
		mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.BOLD, 12));
		mntmRequiredDocumentation.setSelected(false);
		
		String studyProgram = cbxStudyProgram.getSelectedItem().toString();
		
		lblIfOtherSpecify.setVisible(studyProgram.equals("Other"));
		txtStudyProgramOther.setVisible(studyProgram.equals("Other"));
		
		lblPriorItExperience.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
		spnYearsITExperience.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
		lblLevelOfUndergraduate.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
		spnLevelUndergrad.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
		chckbxPreviousDegreeHadProjectThesis.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
		
		//
		if (!bApplicantSignedIn) //academic signed-in -> fields view only
		{
			cbxStudyProgram.setEditable(false);
			txtStudyProgramOther.setEditable(false);
			spnYearsITExperience.setEnabled(false);
			spnLevelUndergrad.setEnabled(false);
			txtAverageMathLevel1.setEditable(false);
			txtAverageMathLevel2.setEditable(false);
			txtAverageMathLevel3.setEditable(false);
			chckbxPreviousDegreeHadProjectThesis.setEnabled(false);
			txtrProvideBriefDescription.setEnabled(false);
			
			btnPdfOfApplication.setVisible(true);
			btnChangeStatus.setVisible(true);
			
		}
		else //applicant signed in
		{
			boolean bEditable = (appController.applicantionEditable(application.getApplicationNumber()));
			
			cbxStudyProgram.setEditable(bEditable);
			txtStudyProgramOther.setEditable(bEditable);
			spnYearsITExperience.setEnabled(bEditable);
			spnLevelUndergrad.setEnabled(bEditable);
			txtAverageMathLevel1.setEditable(bEditable);
			txtAverageMathLevel2.setEditable(bEditable);
			txtAverageMathLevel3.setEditable(bEditable);
			chckbxPreviousDegreeHadProjectThesis.setEnabled(bEditable);
			txtrProvideBriefDescription.setEnabled(bEditable);
			
			if (application.getApplicationStatus().getStatusCode().equalsIgnoreCase("CRTD")) //new application
			{
				btnSaveUpdate.setText("Save");
				btnSubmitReturn.setText("Submit");
			}
			else //existing application
			{
				btnSaveUpdate.setText("Update");
				btnSubmitReturn.setText("Return");
				
			}
		}
	}
	
	private void showAdditionalDocumentation()
	{
		btnNewButton.setEnabled(true);
		pnlSignInUI.setVisible(false);
		pnlApplicationUI.setVisible(true);
		pnlApplicantEntry.setVisible(false);
		pnlAcademicEntryUI.setVisible(false);
		
		pnlApplicationFieldCats.setVisible(true);
		pnlPersonalDetails.setVisible(false);
		pnlContactDetails.setVisible(false);
		pnlTertiaryQualifications.setVisible(false);
		pnlProgrammeOfStudy.setVisible(false);
		pnlAdditionalDocumentation.setVisible(true);
		
		mntmPersonalDetails.setSelected(false);
		mntmContactDetails.setSelected(false);
		mntmTertiaryQual.setSelected(false);
		mntmProgrammeOfStudy.setSelected(false);
		mntmRequiredDocumentation.setSelected(true);
		mntmRequiredDocumentation.setFont(new Font("Calibri", Font.BOLD, 12));
		
		btnNext.setEnabled(false);
		
		//
		if (!bApplicantSignedIn) //academic signed-in -> fields view only
		{
			btnChoosePDF.setVisible(false);
			btnUploadFile.setVisible(false);
			btnDownloadPDF.setVisible(true);
			
		}
		else //applicant signed in
		{
			boolean bEditable = (appController.applicantionEditable(application.getApplicationNumber()));
			btnChoosePDF.setVisible(bEditable);
			btnUploadFile.setVisible(bEditable);
			btnDownloadPDF.setVisible(!bEditable);
			
				
			if (application.getApplicationStatus().getStatusCode().equalsIgnoreCase("CRTD")) //new application
			{
				btnSaveUpdate.setText("Save");
				btnSubmitReturn.setText("Submit");
			}
			else //existing application
			{
				btnSaveUpdate.setText("Update");
				btnSubmitReturn.setText("Return");
			}
		}
	}
	
	private boolean checkPersonalDetails()
	{
		//needs logic!
		return true;
	}
	
	private boolean checkContactDetails()
	{
		//needs logic!
		return true;
	}
	
	private boolean checkQualificationDetails()
	{
		//needs logic!
		return true;
	}
	
	private boolean checkStudyProgramDetails()
	{
		//needs logic!
		return true;
	}
	
	private boolean checkAdditionalDocuments()
	{
		//needs logic!
		return true;
	}
	
	private void displayUndergradMathInputs(int level)
	{
		lblAverageMathLevel1.setVisible((level > 0));
		txtAverageMathLevel1.setVisible((level > 0));
		
		lblAverageMathLevel2.setVisible((level > 1));
		txtAverageMathLevel2.setVisible((level > 1));
		
		lblAverageMathLevel3.setVisible((level > 2));
		txtAverageMathLevel3.setVisible((level > 2));
	}
}
