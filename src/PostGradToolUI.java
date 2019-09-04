import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JPanel;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
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
import javax.swing.event.ChangeEvent;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

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
	private JButton btnPrevious;
	private JButton btnNext;
	private String[] appStatuses;
	private String[] appReasons;
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
	private FOacademic academic;
	private Application application;
	private JCheckBox chkbxFundingStatement;
	private JTextField txtSignEmail;
	private boolean bApplicantSignedIn;
	private JComboBox<String> cbxApplicationApplicationStatus;
	private JComboBox<String> cbxApplicationStatusReason;
	private UndergraduateMathematics[] undMaths;
	private DataReaderWriter data;
	public boolean bNewApplicationStarted;
	private JButton btnMoreApplications;
	private JButton btnPrevApplications;
	private int startIndex; //record in table
	private int endIndex; //record in table
	private DefaultTableModel model;
	private JTextField txtResCountryOther;
	JLabel lblResCountryOther;
	private boolean bEdit;
	private JLabel lblPleaseWaitUntilApplicantsNotified;
	private JLabel lblPleaseWaitPDFGenerated;
	private JLabel lblPleaseWaitPDFDownloaded;
	private JLabel lblPleaseWaitCSVGenerated;
	private File CSVforUpload;
	
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
	 * Prepare application by initiating controllers and setting up form and panels.
	 */
	public PostGradToolUI() {
		bNewApplicationStarted = false;
		bSignIn = true;
		startIndex = 0;
		endIndex = 12;
		populateLists();
		data = new DataReaderWriter();
		appController = new ApplicationController(data);
		userController = new UserController(data);
		
		initialize();
	}

	/**
	 * General infoBox to act as pop-up messages
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
		frmSchoolOfIt.setBounds(100, 100, 978, 468);
		frmSchoolOfIt.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSchoolOfIt.getContentPane().setLayout(null);
	
		cbxApplicationApplicationStatus = new JComboBox<String>();
		cbxApplicationStatusReason = new JComboBox<String>();
		
		pnlAcademicEntryUI = new JPanel();
		pnlAcademicEntryUI.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlAcademicEntryUI.setBounds(0, 0, 952, 429);
		pnlAcademicEntryUI.setVisible(false);
		
		pnlApplicantEntry = new JPanel();
		pnlApplicantEntry.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlApplicantEntry.setBounds(0, 0, 972, 442);
		pnlApplicantEntry.setVisible(false);
		
		pnlApplicationUI = new JPanel();
		pnlApplicationUI.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlApplicationUI.setBounds(0, 0, 972, 429);
		pnlApplicationUI.setVisible(false);
		
		//Sign-In and Sign-Up UI & all its components
		pnlSignInUI = new JPanel();
		pnlSignInUI.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlSignInUI.setBounds(0, 0, 972, 442);
		frmSchoolOfIt.getContentPane().add(pnlSignInUI);
		pnlSignInUI.setLayout(null);
		
		lblSignInApplicantNumber = new JLabel("UCT Applicant / Student Number:");
		lblSignInApplicantNumber.setBounds(276, 176, 195, 14);
		lblSignInApplicantNumber.setFont(new Font("Calibri", Font.PLAIN, 12));
		pnlSignInUI.add(lblSignInApplicantNumber);
		
		txtSignInApplicantNumber = new JTextField();
		txtSignInApplicantNumber.setBounds(498, 171, 214, 20);
		pnlSignInUI.add(txtSignInApplicantNumber);
		txtSignInApplicantNumber.setColumns(10);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPassword.setBounds(276, 242, 195, 14);
		pnlSignInUI.add(lblPassword);
		
		pswPassword = new JPasswordField();
		pswPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		pswPassword.setBounds(498, 237, 214, 20);
		pnlSignInUI.add(pswPassword);
		
		pswConfirmPassword = new JPasswordField();
		pswConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		pswConfirmPassword.setBounds(498, 268, 214, 20);
		pswConfirmPassword.setVisible(false);
		pnlSignInUI.add(pswConfirmPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblConfirmPassword.setBounds(276, 271, 195, 14);
		lblConfirmPassword.setVisible(false);
		pnlSignInUI.add(lblConfirmPassword);
		
		lblNewMessage = new JLabel("New to the School of IT Application System? Click Sign-Up.");
		lblNewMessage.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNewMessage.setBounds(276, 132, 350, 14);
		pnlSignInUI.add(lblNewMessage);
		
		btnGoToSignUpProcess = new JButton("Sign-Up");
		btnGoToSignUpProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prepareSignUp();
			}
		});
		btnGoToSignUpProcess.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnGoToSignUpProcess.setBounds(623, 126, 89, 23);
		pnlSignInUI.add(btnGoToSignUpProcess);
		
		btnSign = new JButton("Sign-In");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = txtSignInApplicantNumber.getText().toString(); //get number representing username
				String email = txtSignEmail.getText().trim();
				String password = String.valueOf(pswPassword.getPassword()); //get password
				String passwordConfirmed = String.valueOf(pswConfirmPassword.getPassword());
				
				btnPdfOfApplication.setVisible(false);
				btnChangeStatus.setVisible(false);
				
				if (bSignIn) //Need to sign in applicant / academic.
				{
					if (userController.isApplicant(number, password, email)) //in the case of an applicant
					{
						System.out.println("Applicant Sign In");
						applicant = userController.getApplicant(number); //fetch applicant
						userController.setApplicantOfFocus(applicant);
						bApplicantSignedIn = true;
						pnlSignInUI.setVisible(false); //leave current interface
						
						application = appController.getApplicationOfApplicant(number); //fetch their application
						appController.setApplicationOfFocus(application);
						btnSubmitReturn.setText("Return");
						btnSubmitReturn.setText("Submit");
						
						populateApplicationFields(applicant, application);
						showApplicantEntryInterface();
					}
					else if (userController.isFOacademic(number, password, email)) //in the case of an academic
					{
						btnPdfOfApplication.setVisible(true); //only an academic can download application details
						btnChangeStatus.setVisible(true); //only an academic can change status
						academic = userController.getFOacademic(number); //fetch academic
						userController.setFOAcademicEvaluating(academic);
						btnSubmitReturn.setText("Return");
						bApplicantSignedIn = false;
						bEdit = false;
						showAcademicEntryInterface();
						
					}
					else //error during sign-in
					{
						txtSignInApplicantNumber.setText("");
						txtSignEmail.setText("");
						pswPassword.setText("");
						pswConfirmPassword.setText("");
						bApplicantSignedIn = false;
						infoBox("Please ensure ALL fields are valid.", "Error");
					}
				}
				else //need to sign up applicant (and return to sign in in stage 4)
				{
					applicant = userController.registerNewApplicant(number, email, password, passwordConfirmed);
					
					if(number.equals(""))
					{
						infoBox("Please provide a valid applicant number.", "Error");
					}
					
					else if(!email.contains("@") || email.equals(""))
					{
						txtSignEmail.setText("");
						infoBox("Please provide a valid email address.", "Error");
					}
					
					else if(password.equals(""))
					{
						infoBox("Please provide a valid password.", "Error");
					}
					
					else if(applicant != null)
					{	
						try
						{
					    	frmSchoolOfIt.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					    	bNewApplicationStarted = true;
							application = appController.createNewApplication(number);
							
							populateApplicationFields(applicant, application);
							bEdit = true;
							showPersonalDetails();
							appController.confirmEmail(applicant.getFirstName(), applicant.getSurname(), applicant.getApplicantNumber(), applicant.getApplicantNumber() + "@myUCT.ac.za");
					    }
					    finally
					    {
					    	frmSchoolOfIt.setCursor(Cursor.getDefaultCursor());
					    }
					}
					else
					{
						pswPassword.setText("");
						pswConfirmPassword.setText("");
						infoBox("Your password was repeated incorrectly.", "Error");
					}
		
				}
			}
		});
		btnSign.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnSign.setBounds(623, 304, 89, 23);
		pnlSignInUI.add(btnSign);
		
		txtSignEmail = new JTextField();
		txtSignEmail.setColumns(10);
		txtSignEmail.setBounds(498, 201, 214, 20);
		pnlSignInUI.add(txtSignEmail);
		
		JLabel lblSignEmail = new JLabel("Email:");
		lblSignEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblSignEmail.setBounds(276, 206, 195, 14);
		pnlSignInUI.add(lblSignEmail);
		frmSchoolOfIt.getContentPane().add(pnlApplicationUI);
		pnlApplicationUI.setLayout(null);
		
		pnlAdditionalDocumentation = new JPanel();
		pnlAdditionalDocumentation.setBounds(235, 87, 660, 295);
		pnlAdditionalDocumentation.setVisible(false);
		
		pnlProgrammeOfStudy = new JPanel();
		pnlProgrammeOfStudy.setBounds(235, 86, 660, 296);
		pnlProgrammeOfStudy.setVisible(false);
		
		pnlTertiaryQualifications = new JPanel();
		pnlTertiaryQualifications.setBounds(235, 87, 660, 295);
		pnlTertiaryQualifications.setVisible(false);
		
		pnlContactDetails = new JPanel();
		pnlContactDetails.setBounds(235, 86, 660, 296);
		pnlContactDetails.setVisible(false);
		
		pnlPersonalDetails = new JPanel();
		pnlPersonalDetails.setBounds(235, 87, 660, 295);
		pnlApplicationUI.add(pnlPersonalDetails);
		pnlPersonalDetails.setLayout(null);
		
		txtApplicantNumber = new JTextField();
		txtApplicantNumber.setEditable(false);
		txtApplicantNumber.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtApplicantNumber.setBounds(160, 10, 437, 25);
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
		txtSurname.setBounds(160, 46, 437, 25);
		pnlPersonalDetails.add(txtSurname);
		
		txtFirstName = new JTextField();
		txtFirstName.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.setFirstName(txtFirstName.getText().toString().trim());
			}
		});
		txtFirstName.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(160, 82, 437, 25);
		pnlPersonalDetails.add(txtFirstName);
		
		cbxTitle = new JComboBox<String>();
		populateComboBox(cbxTitle, "Titles.txt");
		cbxTitle.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (cbxTitle.getSelectedIndex() > -1)
		    	{
		    		applicant.setTitle(cbxTitle.getSelectedItem().toString().trim());
		    	}
		    }
		});
		cbxTitle.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxTitle.setBounds(160, 118, 437, 22);
		pnlPersonalDetails.add(cbxTitle);
		
		txtIDPassport = new JTextField();
		txtIDPassport.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				if (applicant.getCitizenship().equals("International"))
				{
					((InternationalApplicant)applicant).setPassport(txtIDPassport.getText().toString().trim());
				}
				else
				{
					((SouthAfricanApplicant)applicant).setID(txtIDPassport.getText().toString().trim());
				}
			}
		});
		txtIDPassport.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtIDPassport.setColumns(10);
		txtIDPassport.setBounds(160, 213, 437, 25);
		txtIDPassport.setVisible(false);
		pnlPersonalDetails.add(txtIDPassport);
		
		cbxCitizenship = new JComboBox<String>();
		populateComboBox(cbxCitizenship, "Citizenship.txt");
		cbxCitizenship.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (cbxCitizenship.getSelectedIndex() > -1)  //if selection made
	    		{
		    		applicant.setCitizenship(cbxCitizenship.getSelectedItem().toString().trim()); //set citizenship of applicant

		    		if (cbxCitizenship.getSelectedItem().toString().contains("South African")) { //if SA citizenship selected
		    			if (!(applicant instanceof SouthAfricanApplicant)) {
		    				applicant = new SouthAfricanApplicant(applicant); //cast the applicant to an SA applicant
		    				userController.setApplicantOfFocus(applicant);
		    				txtIDPassport.setText(null);
		    			}
		    			cbxCountry.setSelectedItem("South Africa"); //set country selection to SA and disable country selection
		    			cbxCountry.setEnabled(false);
		    			applicant.setCitizenshipCountry("South African"); //set the country of the applicant
		    			lblIdPassport.setText("ID"); //change labels/inputs
		    			lblIdPassport.setVisible(true);
			    		txtIDPassport.setVisible(true);
			    		lblRace.setVisible(true);
			    		cbxRace.setVisible(true);
		    		} else if (cbxCitizenship.getSelectedItem().toString().trim().equals("International")) { //if international selected
		    			applicant = new InternationalApplicant(applicant); //cast the applicant to an international applicant
		    			userController.setApplicantOfFocus(applicant);
		    			if (cbxCountry.getSelectedIndex() > -1 && cbxCountry.getSelectedItem().toString().trim().equals("South Africa")) { //if country selection is SA, set to null
		    				cbxCountry.setSelectedIndex(-1); //null the selection
		    				applicant.setCitizenshipCountry(null); //null the country of the applicant
		    			}
		    			cbxCountry.setEnabled(true); //enable country selection
		    			lblIdPassport.setText("Passport"); //change labels/inputs
		    			lblIdPassport.setVisible(true);
		    			txtIDPassport.setVisible(true);
		    			txtIDPassport.setText(null);
		    			lblRace.setVisible(false);
		    			cbxRace.setVisible(false);
		    			cbxRace.setSelectedIndex(-1);
		    		} 		    		
		    	} 
		    	else 
		    	{
		    		lblIdPassport.setVisible(false); //change labels/inputs
		    		txtIDPassport.setVisible(false);
		    		lblRace.setVisible(false);
		    		cbxRace.setVisible(false);
		    		applicant = new Applicant(applicant);
	    			userController.setApplicantOfFocus(applicant);
		    	}
			}
		});
		cbxCitizenship.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxCitizenship.setBounds(160, 151, 437, 22);
		pnlPersonalDetails.add(cbxCitizenship);
		
		cbxRace = new JComboBox<String>();
		populateComboBox(cbxRace, "Races.txt");
		cbxRace.setVisible(false);
		cbxRace.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) { 
		    	if (cbxRace.getSelectedIndex() > -1)
		    	{
		    		((SouthAfricanApplicant)applicant).setRace(cbxRace.getSelectedItem().toString().trim());
		    	}
		    }
		});
		cbxRace.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxRace.setBounds(160, 249, 437, 22);
		pnlPersonalDetails.add(cbxRace);
		
		lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCountry.setBounds(11, 185, 124, 24);
		pnlPersonalDetails.add(lblCountry);
		
		cbxCountry = new JComboBox<String>();
		populateComboBox(cbxCountry, "Countries.txt");
		cbxCountry.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (cbxCountry.getSelectedIndex() > -1)  //if selection made
		    	{
		    		if (cbxCitizenship.getSelectedIndex() > -1) //check if the user has selected a citizenship
		    		{
		    			if (cbxCitizenship.getSelectedItem().toString().contains("South African")) { //if SA citizenship selected
		    				cbxCountry.setSelectedItem("South Africa"); //set country selection to SA and disable country selection
			    			cbxCountry.setEnabled(false);
			    			applicant.setCitizenshipCountry("South African"); //set the country of the applicant
		    			} else if (cbxCitizenship.getSelectedItem().toString().trim().equals("International")) { //if international citizenship selected
		    				if (cbxCountry.getSelectedItem().toString().trim().equals("South Africa")) { //if SA country selected
		    					cbxCountry.setSelectedIndex(-1); //null the selection
		    					applicant.setCitizenshipCountry(null); //null the country of the applicant
		    				} else { //if any other country selected
		    					applicant.setCitizenshipCountry(cbxCountry.getSelectedItem().toString().trim());
		    				}
		    			}
		    		}
		    		else //if no citizenship selected
		    		{
		    			applicant.setCitizenshipCountry(cbxCountry.getSelectedItem().toString().trim());
		    		}
		    	} 
			}
		});
		cbxCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxCountry.setBounds(160, 185, 437, 22);
		pnlPersonalDetails.add(cbxCountry);
		pnlApplicationUI.add(pnlContactDetails);
		pnlContactDetails.setLayout(null);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblEmail.setBounds(10, 11, 125, 25);
		pnlContactDetails.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtEmail.setEditable(false);
		txtEmail.setBounds(160, 10, 490, 25);
		pnlContactDetails.add(txtEmail);
		txtEmail.setColumns(10);
		
		lblCellphone = new JLabel("Cell-phone:");
		lblCellphone.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblCellphone.setBounds(10, 45, 125, 25);
		pnlContactDetails.add(lblCellphone);
		
		txtCellphone = new JTextField();
		txtCellphone.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtCellphone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				applicant.setCellPhone(txtCellphone.getText().toString().trim());
			}
		});
		txtCellphone.setColumns(10);
		txtCellphone.setBounds(160, 46, 490, 25);
		pnlContactDetails.add(txtCellphone);
		
		lblResidenceLineAddress = new JLabel("Residence line address:");
		lblResidenceLineAddress.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblResidenceLineAddress.setBounds(10, 81, 147, 25);
		pnlContactDetails.add(lblResidenceLineAddress);
		
		txtrLineAddress = new JTextArea();
		txtrLineAddress.setEditable(true);
		txtrLineAddress.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.getResidenceAddress().setLineAddress(txtrLineAddress.getText().toString().trim());
			}
		});
		txtrLineAddress.setWrapStyleWord(true);
		txtrLineAddress.setLineWrap(true);
		txtrLineAddress.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtrLineAddress.setBounds(160, 82, 490, 100);
		pnlContactDetails.add(txtrLineAddress);
		
		lblResidenceCountry = new JLabel("Residence country:");
		lblResidenceCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblResidenceCountry.setBounds(10, 193, 147, 25);
		pnlContactDetails.add(lblResidenceCountry);
		
		
		txtResCountryOther = new JTextField();
		txtResCountryOther.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.getResidenceAddress().setCountry(txtResCountryOther.getText().toString().trim());
			}
		});
		txtResCountryOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtResCountryOther.setColumns(10);
		txtResCountryOther.setBounds(160, 225, 490, 25);
		txtResCountryOther.setVisible(false);
		pnlContactDetails.add(txtResCountryOther);
		
		lblResCountryOther = new JLabel("If Other, Specify:");
		lblResCountryOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblResCountryOther.setBounds(10, 225, 124, 24);
		lblResCountryOther.setVisible(false);
		pnlContactDetails.add(lblResCountryOther);
		
		cbxResCountry = new JComboBox<String>();
		populateComboBox(cbxResCountry, "Countries.txt");
		cbxResCountry.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (cbxResCountry.getSelectedIndex() > -1)
		    	{
		    		String sResCountry = cbxResCountry.getSelectedItem().toString().trim();
		    		applicant.getResidenceAddress().setCountry(sResCountry);
		    		if (!nullOrBlank(sResCountry))
		    		{
		    			txtResCountryOther.setVisible(sResCountry.equals("Other"));
		    			lblResCountryOther.setVisible(sResCountry.equals("Other"));
		    		}
		    	}
		    }
		});
		cbxResCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxResCountry.setBounds(160, 192, 490, 22);
		pnlContactDetails.add(cbxResCountry);
		pnlApplicationUI.add(pnlTertiaryQualifications);
		pnlTertiaryQualifications.setLayout(null);
		
		lbldegCountry = new JLabel("Country where Previous Degree was Obtained:");
		lbldegCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		lbldegCountry.setBounds(10, 12, 262, 25);
		pnlTertiaryQualifications.add(lbldegCountry);
		
		txtDegCountryOther = new JTextField();
		txtDegCountryOther.setVisible(false);
		txtDegCountryOther.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.getPreviousQualification().setCountry(txtDegCountryOther.getText().toString().trim());
			}
		});
		txtDegCountryOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtDegCountryOther.setColumns(10);
		txtDegCountryOther.setBounds(267, 48, 383, 25);
		pnlTertiaryQualifications.add(txtDegCountryOther);
		
		lblPreviousDegree = new JLabel("If Other, Specify:");
		lblPreviousDegree.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPreviousDegree.setBounds(10, 46, 124, 24);
		lblPreviousDegree.setVisible(false);
		pnlTertiaryQualifications.add(lblPreviousDegree);
		
		cbxDegCountry = new JComboBox<String>();
		cbxDegCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		populateComboBox(cbxDegCountry, "Countries.txt");
		cbxDegCountry.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (cbxDegCountry.getSelectedIndex() > -1)
		    	{
		    		String sDegCountry = cbxDegCountry.getSelectedItem().toString().trim();
		    		applicant.getPreviousQualification().setCountry(sDegCountry);
		    		if (!nullOrBlank(sDegCountry))
		    		{
		    			txtDegCountryOther.setVisible(sDegCountry.equals("Other"));
		    			lblPreviousDegree.setVisible(sDegCountry.equals("Other"));
		    		}
		    	}
		    }
		});
		cbxDegCountry.setBounds(267, 11, 383, 22);
		pnlTertiaryQualifications.add(cbxDegCountry);
		
		lblPreviousDegree_1 = new JLabel("Previous Degree:");
		lblPreviousDegree_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPreviousDegree_1.setBounds(10, 82, 262, 25);
		pnlTertiaryQualifications.add(lblPreviousDegree_1);
		
		cbxDegree = new JComboBox<String>();
		cbxDegree.setFont(new Font("Calibri", Font.PLAIN, 12));
		populateComboBox(cbxDegree, "Degrees.txt");
		cbxDegree.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (cbxDegree.getSelectedIndex() > -1)
		    	{
		    		String sDegree = cbxDegree.getSelectedItem().toString().trim();
		    		if (!sDegree.equals("Other")) { //If the selected item is not "Other", set the applicants degree to the selected option.
		    			applicant.getPreviousQualification().setDegree(sDegree);
		    		} 
		    		txtDegOther.setVisible(sDegree.equals("Other"));
		    		lblDegOther.setVisible(sDegree.equals("Other"));
		    	}
			}
		});
		cbxDegree.setBounds(267, 81, 383, 22);
		pnlTertiaryQualifications.add(cbxDegree);
		
		txtDegOther = new JTextField();
		txtDegOther.setVisible(false);
		txtDegOther.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				applicant.getPreviousQualification().setDegree(txtDegOther.getText().toString().trim());
			}
		});
		txtDegOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtDegOther.setColumns(10);
		txtDegOther.setBounds(267, 118, 383, 25);
		txtDegOther.setVisible(false);
		pnlTertiaryQualifications.add(txtDegOther);
		
		lblDegOther = new JLabel("If Other, Specify:");
		lblDegOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDegOther.setBounds(10, 116, 124, 24);
		lblDegOther.setVisible(false);
		pnlTertiaryQualifications.add(lblDegOther);
		
		lblNqfEquivalentOf = new JLabel("NQF Equivalent of Previous Degree:");
		lblNqfEquivalentOf.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNqfEquivalentOf.setBounds(10, 155, 262, 25);
		pnlTertiaryQualifications.add(lblNqfEquivalentOf);
		
		cbxNQF = new JComboBox<String>();
		cbxNQF.setFont(new Font("Calibri", Font.PLAIN, 12));
		populateComboBox(cbxNQF, "NQF.txt");
		cbxNQF.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (cbxNQF.getSelectedIndex() > -1)
		    	{
		    		String sNQF = cbxNQF.getSelectedItem().toString().trim();
		    		applicant.getPreviousQualification().setNQFEquivalence(sNQF);
		    	}
			}
		});
		cbxNQF.setBounds(267, 154, 383, 22);
		pnlTertiaryQualifications.add(cbxNQF);
		
		lblMinDurationOf = new JLabel("Min Duration of Previous Degree:");
		lblMinDurationOf.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblMinDurationOf.setBounds(10, 191, 233, 24);
		pnlTertiaryQualifications.add(lblMinDurationOf);
		
		spnMinDuration = new JSpinner();
		spnMinDuration.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				applicant.getPreviousQualification().setMinDuration((int) spnMinDuration.getValue());
			}
		});
		spnMinDuration.setModel(new SpinnerNumberModel(1, 1, 8, 1));
		spnMinDuration.setFont(new Font("Calibri", Font.PLAIN, 12));
		spnMinDuration.setBounds(267, 191, 45, 20);
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
		txtDegUniversity.setBounds(267, 224, 383, 25);
		pnlTertiaryQualifications.add(txtDegUniversity);
		pnlApplicationUI.add(pnlProgrammeOfStudy);
		pnlProgrammeOfStudy.setLayout(null);
		
		lblProgrammeOfStudy = new JLabel("Programme of Study:");
		lblProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblProgrammeOfStudy.setBounds(10, 12, 125, 25);
		pnlProgrammeOfStudy.add(lblProgrammeOfStudy);
		
		txtStudyProgramOther = new JTextField();
		txtStudyProgramOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtStudyProgramOther.setColumns(10);
		txtStudyProgramOther.setBounds(219, 46, 431, 25);
		txtStudyProgramOther.setVisible(false);
		txtStudyProgramOther.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				application.setStudyProgram(appController.getStudyProgram(txtStudyProgramOther.toString().trim()));
			}
		});
		pnlProgrammeOfStudy.add(txtStudyProgramOther);
		
		lblIfOtherSpecify = new JLabel("If Other, Specify:");
		lblIfOtherSpecify.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIfOtherSpecify.setBounds(10, 46, 124, 24);
		lblIfOtherSpecify.setVisible(false);
		pnlProgrammeOfStudy.add(lblIfOtherSpecify);
		
		cbxStudyProgram = new JComboBox<String>();
		populateComboBox(cbxStudyProgram, "Degrees.txt");
		cbxStudyProgram.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if (cbxStudyProgram.getSelectedIndex() > -1)
		    	{
		    		String studyProgram = cbxStudyProgram.getSelectedItem().toString();
		    		
		    		if (studyProgram.contains("MIT") && (applicant.getPreviousQualification().getDegree().contains("Computer") || applicant.getPreviousQualification().getDegree().contains("Technology") || applicant.getPreviousQualification().getDegree().contains("Systems")))
		    		{ //Reset if MIT selected and previous qualification is inconsistent
		    			JOptionPane.showMessageDialog(frmSchoolOfIt, "Not eligible to apply for MIT", "Not Eligible", JOptionPane.ERROR_MESSAGE);
		    			cbxStudyProgram.setSelectedIndex(-1);
		    			lblIfOtherSpecify.setVisible(false);
		    			txtStudyProgramOther.setVisible(false);
		    		} 
		    		else if (studyProgram.contains("Other"))
		    		{ //if Other was selected, make the "if other, specify" field visible
		    			lblIfOtherSpecify.setVisible(true);
		    			txtStudyProgramOther.setVisible(true);
		    		}
		    		else
		    		{ //otherwise, set the study program of the applicant, and set checkboxes.
		    			application.setStudyProgram(appController.getStudyProgram(studyProgram));
		    			lblIfOtherSpecify.setVisible(false);
		    			txtStudyProgramOther.setVisible(false);
						
		    			chckbxCertifiedTranscript.setSelected(appController.getStudyProgram(studyProgram).requireTranscript());
		    			chckbxCurriculumVitaecv.setSelected(appController.getStudyProgram(studyProgram).requireCV());
		    			chckbxResearchStatement.setSelected(appController.getStudyProgram(studyProgram).requireResearchStatement());
		    			chckbxRefereesNames.setSelected(appController.getStudyProgram(studyProgram).requireRefereesNames());
		    			chkbxFundingStatement.setSelected(appController.getStudyProgram(studyProgram).requireFundingStatement());
		    			chckbxMotivation.setSelected(appController.getStudyProgram(studyProgram).requireMotivation());
		    			
		    			if (studyProgram.contains("MIT")) 
		    			{ //If the study program is MIT related, cast the previousQual to TertiaryQualificationForMIT
		    				applicant.setPreviousQualification(new TertiaryQualificationForMIT(applicant.getPreviousQualification()));
		    			} else
		    			{ //If not, cast the previousQual to TertiaryQualification
		    				applicant.setPreviousQualification(new TertiaryQualification(applicant.getPreviousQualification()));
		    			}
		    			
		    			lblPriorItExperience.setVisible(studyProgram.contains("(MIT)"));
						spnYearsITExperience.setVisible(studyProgram.contains("(MIT)"));
						lblLevelOfUndergraduate.setVisible(studyProgram.contains("(MIT)"));
						spnLevelUndergrad.setVisible(studyProgram.contains("(MIT)"));
						chckbxPreviousDegreeHadProjectThesis.setVisible(studyProgram.contains("(MIT)"));
				}}
			}
		});
		cbxStudyProgram.setBounds(219, 11, 431, 22);
		pnlProgrammeOfStudy.add(cbxStudyProgram);
		
		lblPriorItExperience = new JLabel("Years of Prior IT Experience:");
		lblPriorItExperience.setVisible(false);
		lblPriorItExperience.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPriorItExperience.setBounds(10, 83, 150, 24);
		pnlProgrammeOfStudy.add(lblPriorItExperience);
		
		lblLevelOfUndergraduate = new JLabel("Level of Undergraduate Mathematics:");
		lblLevelOfUndergraduate.setVisible(false);
		lblLevelOfUndergraduate.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblLevelOfUndergraduate.setBounds(10, 128, 209, 24);
		pnlProgrammeOfStudy.add(lblLevelOfUndergraduate);
		
		spnLevelUndergrad = new JSpinner();
		spnLevelUndergrad.setVisible(false);
		spnLevelUndergrad.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtAverageMathLevel1.setText("");
				txtAverageMathLevel2.setText("");
				txtAverageMathLevel3.setText("");
				int high = (int) spnLevelUndergrad.getValue();
				undMaths = new UndergraduateMathematics[high];
				((TertiaryQualificationForMIT) applicant.getPreviousQualification()).setHighestLevelUndergradMathematcs(high);
				displayUndergradMathInputs(high);
			}
		});
		spnLevelUndergrad.setModel(new SpinnerNumberModel(0, 0, 3, 1));
		spnLevelUndergrad.setFont(new Font("Calibri", Font.PLAIN, 12));
		spnLevelUndergrad.setBounds(219, 130, 30, 20);
		pnlProgrammeOfStudy.add(spnLevelUndergrad);
		
		lblAveragesPerMathematics = new JLabel("Averages per Mathematics Level:");
		lblAveragesPerMathematics.setVisible(false);
		lblAveragesPerMathematics.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAveragesPerMathematics.setBounds(10, 175, 209, 24);
		pnlProgrammeOfStudy.add(lblAveragesPerMathematics);
		
		txtAverageMathLevel1 = new JTextField();
		txtAverageMathLevel1.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtAverageMathLevel1.setVisible(false);
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
		txtAverageMathLevel2.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtAverageMathLevel2.setVisible(false);
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
		txtAverageMathLevel3.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtAverageMathLevel3.setVisible(false);
		txtAverageMathLevel3.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				undMaths[2] = new UndergraduateMathematics(1, Double.valueOf(txtAverageMathLevel3.getText().toString().trim()));
				if (undMaths.length == 3) {((TertiaryQualificationForMIT) applicant.getPreviousQualification()).setUndergradMaths(undMaths);}	
			}
		});
		txtAverageMathLevel3.setBounds(339, 175, 50, 20);
		pnlProgrammeOfStudy.add(txtAverageMathLevel3);
		txtAverageMathLevel3.setColumns(10);
		
		lblAverageMathLevel1 = new JLabel("Level 1");
		lblAverageMathLevel1.setVisible(false);
		lblAverageMathLevel1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAverageMathLevel1.setBounds(219, 153, 50, 21);
		pnlProgrammeOfStudy.add(lblAverageMathLevel1);
		
		spnYearsITExperience = new JSpinner();
		spnYearsITExperience.setVisible(false);
		spnYearsITExperience.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				((TertiaryQualificationForMIT) applicant.getPreviousQualification()).setPriorITExperience((int) spnYearsITExperience.getValue());
			}
		});
		spnYearsITExperience.setFont(new Font("Calibri", Font.PLAIN, 12));
		spnYearsITExperience.setBounds(219, 85, 30, 20);
		pnlProgrammeOfStudy.add(spnYearsITExperience);
		
		chckbxPreviousDegreeHadProjectThesis = new JCheckBox("Previous Degree had Project or Thesis Component");
		chckbxPreviousDegreeHadProjectThesis.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxPreviousDegreeHadProjectThesis.setEnabled(true);
		chckbxPreviousDegreeHadProjectThesis.setVisible(false);
		chckbxPreviousDegreeHadProjectThesis.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if (applicant.getPreviousQualification().getClass().equals(TertiaryQualificationForMIT.class))
				{
					((TertiaryQualificationForMIT) applicant.getPreviousQualification()).PresenceProjectThesisPresent(chckbxPreviousDegreeHadProjectThesis.isSelected());
					txtrProvideBriefDescription.setVisible(chckbxPreviousDegreeHadProjectThesis.isSelected());
				}
			}
		});
		chckbxPreviousDegreeHadProjectThesis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (applicant.getPreviousQualification().getClass().equals(TertiaryQualificationForMIT.class))
				{
					((TertiaryQualificationForMIT) applicant.getPreviousQualification()).PresenceProjectThesisPresent(chckbxPreviousDegreeHadProjectThesis.isSelected());
					txtrProvideBriefDescription.setVisible(chckbxPreviousDegreeHadProjectThesis.isSelected());

				}
			}
		});

		chckbxPreviousDegreeHadProjectThesis.setBounds(10, 206, 359, 23);
		pnlProgrammeOfStudy.add(chckbxPreviousDegreeHadProjectThesis);
		
		txtrProvideBriefDescription = new JTextArea();
		txtrProvideBriefDescription.setVisible(false);
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
		txtrProvideBriefDescription.setBounds(10, 232, 640, 50);
		pnlProgrammeOfStudy.add(txtrProvideBriefDescription);
		
		lblAverageMathLevel2 = new JLabel("Level 2");
		lblAverageMathLevel2.setVisible(false);
		lblAverageMathLevel2.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAverageMathLevel2.setBounds(279, 153, 50, 24);
		pnlProgrammeOfStudy.add(lblAverageMathLevel2);
		
		lblAverageMathLevel3 = new JLabel("Level 3");
		lblAverageMathLevel3.setVisible(false);
		lblAverageMathLevel3.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblAverageMathLevel3.setBounds(339, 153, 50, 24);
		pnlProgrammeOfStudy.add(lblAverageMathLevel3);
		pnlApplicationUI.add(pnlAdditionalDocumentation);
		pnlAdditionalDocumentation.setLayout(null);
		
		txtrTheFollowingDocuments = new JTextArea();
		txtrTheFollowingDocuments.setBackground(SystemColor.menu);
		txtrTheFollowingDocuments.setText("The following documents (which are ticked) needs to be uploaded as a single PDF:");
		txtrTheFollowingDocuments.setWrapStyleWord(true);
		txtrTheFollowingDocuments.setLineWrap(true);
		txtrTheFollowingDocuments.setFont(new Font("Calibri", Font.BOLD, 12));
		txtrTheFollowingDocuments.setBounds(10, 9, 439, 29);
		pnlAdditionalDocumentation.add(txtrTheFollowingDocuments);
		
		chckbxCertifiedTranscript = new JCheckBox("Certified Transcript");
		chckbxCertifiedTranscript.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxCertifiedTranscript.setEnabled(false);
		chckbxCertifiedTranscript.setBounds(10, 45, 141, 23);
		pnlAdditionalDocumentation.add(chckbxCertifiedTranscript);
		
		chckbxCurriculumVitaecv = new JCheckBox("Curriculum Vitae (CV)");
		chckbxCurriculumVitaecv.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxCurriculumVitaecv.setEnabled(false);
		chckbxCurriculumVitaecv.setBounds(232, 45, 141, 23);
		pnlAdditionalDocumentation.add(chckbxCurriculumVitaecv);
		
		chckbxResearchStatement = new JCheckBox("Research Statement");
		chckbxResearchStatement.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxResearchStatement.setEnabled(false);
		chckbxResearchStatement.setBounds(10, 71, 141, 23);
		pnlAdditionalDocumentation.add(chckbxResearchStatement);
		
		chckbxRefereesNames = new JCheckBox("Referees' Names");
		chckbxRefereesNames.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxRefereesNames.setEnabled(false);
		chckbxRefereesNames.setBounds(232, 69, 141, 23);
		pnlAdditionalDocumentation.add(chckbxRefereesNames);
		
		chckbxMotivation = new JCheckBox("Motivation");
		chckbxMotivation.setFont(new Font("Calibri", Font.PLAIN, 12));
		chckbxMotivation.setEnabled(false);
		chckbxMotivation.setBounds(232, 95, 141, 23);
		pnlAdditionalDocumentation.add(chckbxMotivation);
		
		lblPdfOfAdditional = new JLabel("PDF of Additional Documentation:");
		lblPdfOfAdditional.setFont(new Font("Calibri", Font.BOLD, 12));
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
				if (!appController.uploadPDF(application.getApplicationNumber(), lblPDFName.getText()))
				{
					infoBox("An error occurred while uploading the file. Please ensure that the file you supplied is a PDF file. ", "Error");
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
				    try
				    {
				    	lblPleaseWaitPDFDownloaded.setVisible(true);
				    	frmSchoolOfIt.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				    	if (!appController.downloadPDF(application.getApplicationNumber(), fileToSave)) {
				    		infoBox("An error occurred while downloading the file. Please ensure that the file name you supplied included "
				    				+ "the \".pdf\" extension. Otherwise, the requested PDF may not be contained in the database.", "Error");
				    	}
				    }
				    finally
				    {
				    	frmSchoolOfIt.setCursor(Cursor.getDefaultCursor());
				    	lblPleaseWaitPDFDownloaded.setVisible(false);
				    }
				}
			}
		});
		btnDownloadPDF.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnDownloadPDF.setBounds(330, 192, 119, 23);
		pnlAdditionalDocumentation.add(btnDownloadPDF);
		

		lblPleaseWaitPDFDownloaded = new JLabel("Downloading PDF... Please Wait");
		lblPleaseWaitPDFDownloaded.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblPleaseWaitPDFDownloaded.setVisible(false);
		lblPleaseWaitPDFDownloaded.setBounds(330, 130, 298, 14);
		pnlAdditionalDocumentation.add(lblPleaseWaitPDFDownloaded);
		
		
		chkbxFundingStatement = new JCheckBox("Funding Statement");
		chkbxFundingStatement.setFont(new Font("Calibri", Font.PLAIN, 12));
		chkbxFundingStatement.setEnabled(false);
		chkbxFundingStatement.setBounds(10, 95, 141, 23);
		pnlAdditionalDocumentation.add(chkbxFundingStatement);
		
		pnlApplicationFieldCats = new JPanel();
		pnlApplicationFieldCats.setBounds(32, 87, 193, 162);
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
				mntmPersonalDetails.setSelected(true);
				mntmContactDetails.setSelected(false);
				mntmTertiaryQual.setSelected(false);
				mntmProgrammeOfStudy.setSelected(false);
				mntmRequiredDocumentation.setSelected(false);
				
				if (pnlPersonalDetails.isVisible())
				{
					if (checkPersonalDetails())
					{
						showPersonalDetails();
					}
				}
				else if (pnlContactDetails.isVisible())
				{
					if (checkContactDetails())
					{
						showPersonalDetails();
					}
					
				}
				else if (pnlTertiaryQualifications.isVisible())
				{
					if (checkQualificationDetails())
					{
						showPersonalDetails();
					}
				}
				else if (pnlProgrammeOfStudy.isVisible())
				{
					if (checkStudyProgramDetails())
					{
						showPersonalDetails();
					}
				}
				else if (pnlAdditionalDocumentation.isVisible())
				{
					if (checkAdditionalDocuments())
					{
						showPersonalDetails();
					}
				}
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
				mntmPersonalDetails.setSelected(false);
				mntmContactDetails.setSelected(true);
				mntmTertiaryQual.setSelected(false);
				mntmProgrammeOfStudy.setSelected(false);
				mntmRequiredDocumentation.setSelected(false);
				
				if (pnlPersonalDetails.isVisible())
				{
					if (checkPersonalDetails())
					{
						showContactDetails();
					}
				}
				else if (pnlContactDetails.isVisible())
				{
					if (checkContactDetails())
					{
						showContactDetails();
					}
					
				}
				else if (pnlTertiaryQualifications.isVisible())
				{
					if (checkQualificationDetails())
					{
						showContactDetails();
					}
				}
				else if (pnlProgrammeOfStudy.isVisible())
				{
					if (checkStudyProgramDetails())
					{
						showContactDetails();
					}
				}
				else if (pnlAdditionalDocumentation.isVisible())
				{
					if (checkAdditionalDocuments())
					{
						showContactDetails();
					}
				}
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
				mntmPersonalDetails.setSelected(false);
				mntmContactDetails.setSelected(false);
				mntmTertiaryQual.setSelected(true);
				mntmProgrammeOfStudy.setSelected(false);
				mntmRequiredDocumentation.setSelected(false);
				
				if (pnlPersonalDetails.isVisible())
				{
					if (checkPersonalDetails())
					{
						showTertiaryQualifications();
					}
				}
				else if (pnlContactDetails.isVisible())
				{
					if (checkContactDetails())
					{
						showTertiaryQualifications();
					}
					
				}
				else if (pnlTertiaryQualifications.isVisible())
				{
					if (checkQualificationDetails())
					{
						showTertiaryQualifications();
					}
				}
				else if (pnlProgrammeOfStudy.isVisible())
				{
					if (checkStudyProgramDetails())
					{
						showTertiaryQualifications();
					}
				}
				else if (pnlAdditionalDocumentation.isVisible())
				{
					if (checkAdditionalDocuments())
					{
						showTertiaryQualifications();
					}
				}
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
				mntmPersonalDetails.setSelected(false);
				mntmContactDetails.setSelected(false);
				mntmTertiaryQual.setSelected(false);
				mntmProgrammeOfStudy.setSelected(true);
				mntmRequiredDocumentation.setSelected(false);
				
				if (pnlPersonalDetails.isVisible())
				{
					if (checkPersonalDetails())
					{
						showStudyProgram();
					}
				}
				else if (pnlContactDetails.isVisible())
				{
					if (checkContactDetails())
					{
						showStudyProgram();
					}
					
				}
				else if (pnlTertiaryQualifications.isVisible())
				{
					if (checkQualificationDetails())
					{
						showStudyProgram();
					}
				}
				else if (pnlProgrammeOfStudy.isVisible())
				{
					if (checkStudyProgramDetails())
					{
						showStudyProgram();
					}
				}
				else if (pnlAdditionalDocumentation.isVisible())
				{
					if (checkAdditionalDocuments())
					{
						showStudyProgram();
					}
				}
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
				mntmPersonalDetails.setSelected(false);
				mntmContactDetails.setSelected(false);
				mntmTertiaryQual.setSelected(false);
				mntmProgrammeOfStudy.setSelected(false);
				mntmRequiredDocumentation.setSelected(true);
				
				if (pnlPersonalDetails.isVisible())
				{
					if (checkPersonalDetails())
					{
						showAdditionalDocumentation();
					}
				}
				else if (pnlContactDetails.isVisible())
				{
					if (checkContactDetails())
					{
						showAdditionalDocumentation();
					}
					
				}
				else if (pnlTertiaryQualifications.isVisible())
				{
					if (checkQualificationDetails())
					{
						showAdditionalDocumentation();
					}
				}
				else if (pnlProgrammeOfStudy.isVisible())
				{
					if (checkStudyProgramDetails())
					{
						showAdditionalDocumentation();
					}
				}
				else if (pnlAdditionalDocumentation.isVisible())
				{
					if (checkAdditionalDocuments())
					{
						showAdditionalDocumentation();
					}
				}
			}
		});
		mntmRequiredDocumentation.setHorizontalAlignment(SwingConstants.LEFT);
		mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmRequiredDocumentation.setBounds(0, 131, 190, 26);
		pnlApplicationFieldCats.add(mntmRequiredDocumentation);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
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
		btnPrevious.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnPrevious.setBounds(42, 260, 89, 23);
		pnlApplicationUI.add(btnPrevious);
		
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
		btnNext.setEnabled(true);
		btnNext.setBounds(136, 260, 89, 23);
		pnlApplicationUI.add(btnNext);
		
		btnSubmitReturn = new JButton("Submit");
		btnSubmitReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (bApplicantSignedIn || bNewApplicationStarted) //new application -> submit
				{
					data.updateApplicationRecord(new ApplicantApplicationReference(applicant, application));
				
					bNewApplicationStarted = false;
					showApplicantEntryInterface();
				}
				else
				{
					showAcademicEntryInterface();
				}
			}
		});
		btnSubmitReturn.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnSubmitReturn.setBounds(136, 294, 89, 23);
		pnlApplicationUI.add(btnSubmitReturn);
		
		btnChangeStatus = new JButton("Change Status");
		btnChangeStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String appStatus = (String) JOptionPane.showInputDialog(frmSchoolOfIt.getContentPane(), "Choose new application status", "Application Status", JOptionPane.QUESTION_MESSAGE,  null, appStatuses, appStatuses[0]);
				String reason = (String) JOptionPane.showInputDialog(frmSchoolOfIt.getContentPane(), "Reason for application change:", "Reason for New Status", JOptionPane.QUESTION_MESSAGE,  null, appReasons, appReasons[0]);
				
				application.setApplicationStatus(new ApplicationStatus(appStatus.trim(), reason.trim()));
				
				data.updateApplicationRecord(new ApplicantApplicationReference(applicant, application));
				populateApplicationFields(applicant, application);
				
				tblApplications.setModel(appController.populateApplicationsTable(model, getSubArrayList(data.getApplicantsAndTheirApplications(), startIndex, endIndex)));
				btnMoreApplications.setVisible(true);
				btnPrevApplications.setVisible(false);

			}
		});
		btnChangeStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnChangeStatus.setBounds(44, 360, 181, 23);
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
				    try
				    {
				    	lblPleaseWaitPDFGenerated.setVisible(true);
						frmSchoolOfIt.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
				    	if (!appController.requestPDFofApplicantDetails(applicant.getApplicantNumber(), appController.getApplicationOfApplicant(applicant.getApplicantNumber()).getApplicationNumber(), fileToSave)) {
				    		infoBox("An error occurred while generating the file. Please ensure that the file name you supplied included "
				    				+ "the \".pdf\" extension.", "Error");
				    	}
				    }
				    finally
				    {
				    	lblPleaseWaitPDFGenerated.setVisible(false);
				    	frmSchoolOfIt.setCursor(Cursor.getDefaultCursor());
				    }
				}
				
			}
		});
		btnPdfOfApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnPdfOfApplication.setBounds(44, 326, 181, 23);
		pnlApplicationUI.add(btnPdfOfApplication);
		
		lblPleaseWaitPDFGenerated = new JLabel("Generating PDF... Please Wait");
		lblPleaseWaitPDFGenerated.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblPleaseWaitPDFGenerated.setVisible(false);
		lblPleaseWaitPDFGenerated.setBounds(44, 356, 298, 14);
		pnlApplicationUI.add(lblPleaseWaitPDFGenerated);
		
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
		txtApplicantApplicationNumber.setBounds(231, 11, 673, 20);
		pnlApplicantEntry.add(txtApplicantApplicationNumber);
		
		txtApplicantApplicationStatus = new JTextField();
		txtApplicantApplicationStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtApplicantApplicationStatus.setEditable(false);
		txtApplicantApplicationStatus.setColumns(10);
		txtApplicantApplicationStatus.setBounds(231, 41, 673, 20);
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
		txtStatusReason.setBounds(231, 62, 673, 20);
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
				bEdit = false;
				showPersonalDetails();
				
			}
		});
		btnViewApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnViewApplication.setBounds(415, 220, 141, 23);
		pnlApplicantEntry.add(btnViewApplication);
		
		btnEditApplication = new JButton("Edit Application");
		btnEditApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateApplicationFields(applicant, application);
				bEdit = true;
				showPersonalDetails();
				
			}
		});
		btnEditApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnEditApplication.setBounds(415, 260, 141, 23);
		pnlApplicantEntry.add(btnEditApplication);
		
		btnRemoveApplication = new JButton("Remove Application");
		btnRemoveApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				application.setApplicationStatus(new ApplicationStatus("Withdrawn", "Applicant withdraws application"));
				data.updateApplicationRecord(new ApplicantApplicationReference(applicant, application));
				populateApplicationFields(applicant, application);
				showSignInInterface();
			}
		});
		btnRemoveApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnRemoveApplication.setBounds(415, 294, 141, 23);
		pnlApplicantEntry.add(btnRemoveApplication);
		
		JButton btnLogOut_1 = new JButton("Log Out");
		btnLogOut_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnLogOut_1.setBounds(415, 328, 141, 23);
		btnLogOut_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				academic = null;
				applicant = null;
				application = null;
				showSignInInterface();
			}
		});
		pnlApplicantEntry.add(btnLogOut_1);
		frmSchoolOfIt.getContentPane().add(pnlAcademicEntryUI);
		pnlAcademicEntryUI.setLayout(null);
		
		
		btnChooseCSV = new JButton("Choose CSV");
		btnChooseCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(); //create a file chooser
				fileChooser.setFileFilter(new FileExtensionFilter(".csv"));
				int returnVal = fileChooser.showOpenDialog(frmSchoolOfIt); //show file chooser for selecting file
				if (returnVal == JFileChooser.APPROVE_OPTION)  //user has selected file
				{
					CSVforUpload = fileChooser.getSelectedFile(); //fetch file chosen
					String fileName = CSVforUpload.getName(); //get name of file
					lblNameOfCSVFile.setText(fileName); //name of file
					appController.chosenCSV(CSVforUpload); //prepare file for upload
					btnUploadCsv.setVisible(true);
				}
			}
		});
		btnChooseCSV.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnChooseCSV.setBounds(33, 333, 246, 23);
		pnlAcademicEntryUI.add(btnChooseCSV);
		
		lblUploadCSVMessage = new JLabel("Upload CSV to Notify Potential Applicants to Apply:");
		lblUploadCSVMessage.setFont(new Font("Calibri", Font.BOLD, 12));
		lblUploadCSVMessage.setBounds(36, 310, 298, 14);
		pnlAcademicEntryUI.add(lblUploadCSVMessage);
		
		btnUploadCsv = new JButton("Upload CSV");
		btnUploadCsv.setVisible(false);
		btnUploadCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					lblPleaseWaitUntilApplicantsNotified.setVisible(true);
					frmSchoolOfIt.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					if (!appController.notifyApplicants(CSVforUpload)) {
						infoBox("An error occurred while notifying applicants.", "Error");
					}
				}
				finally
				{
					frmSchoolOfIt.setCursor(Cursor.getDefaultCursor());
					btnUploadCsv.setVisible(false);
					lblPleaseWaitUntilApplicantsNotified.setVisible(false);
					
				}
			}
		});
		btnUploadCsv.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnUploadCsv.setBounds(33, 367, 246, 23);
		pnlAcademicEntryUI.add(btnUploadCsv);
		
		lblPleaseWaitUntilApplicantsNotified = new JLabel("Notifying Applicants... Please Wait");
		lblPleaseWaitUntilApplicantsNotified.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblPleaseWaitUntilApplicantsNotified.setVisible(false);
		lblPleaseWaitUntilApplicantsNotified.setBounds(36, 44, 298, 14);
		pnlAcademicEntryUI.add(lblPleaseWaitUntilApplicantsNotified);
		
		lblSelectFieldValues = new JLabel("Select Field Values to Generate CSV:");
		lblSelectFieldValues.setFont(new Font("Calibri", Font.BOLD, 12));
		lblSelectFieldValues.setBounds(402, 264, 282, 14);
		pnlAcademicEntryUI.add(lblSelectFieldValues);
		
		btnGenerateCsv = new JButton("Generate CSV");
		btnGenerateCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				{
					if (cbxLevel.getSelectedIndex()>-1 && cbxStudyPrograms.getSelectedIndex()>-1) {
						cbxLevel.setSelectedIndex(-1);
						cbxStudyPrograms.setSelectedIndex(-1);
						infoBox("You can only select either a Level or a Study Program, not both.", "Error");
						return;
					}
					JFileChooser fileChooser = new JFileChooser(); //create JFileChooser for user to indicate location to save file.
					fileChooser.setDialogTitle("Specify location to save CSV of Applicants");  
					fileChooser.setFileFilter(new FileExtensionFilter(".csv"));
					
					int returnVal = fileChooser.showSaveDialog(frmSchoolOfIt); //show save dialog
					 
					if (returnVal == JFileChooser.APPROVE_OPTION) {//if the user has selected a location and filename
					    File fileToSave = fileChooser.getSelectedFile(); //get information about file
					    
					    try
					    {
					    	lblPleaseWaitCSVGenerated.setVisible(true);
							frmSchoolOfIt.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
					    	
					    	String sp;
					    	String level;
					    	String appStatus;
					    	if (cbxStudyPrograms.getSelectedIndex()>-1)
					    	{
					    		sp = cbxStudyPrograms.getSelectedItem().toString().trim();
					    	}
					    	else
					    	{
					    		sp = "%";
					    	}
					    	if (cbxLevel.getSelectedIndex()>-1)
					    	{
					    		level = cbxLevel.getSelectedItem().toString().trim();
					    	}
					    	else
					    	{
					    		level = "%";
					    	}
					    	if (cbxApplicationStatus.getSelectedIndex()>-1)
					    	{
					    		appStatus = cbxApplicationStatus.getSelectedItem().toString().trim();
					    	}
					    	else
					    	{
					    		appStatus = "%";
					    	}
					    	 if (!appController.getFilteredApplicantListAsCSV(appController.getFilteredList(sp, level, appStatus), fileToSave)) {
					    		 infoBox("An error occurred while generating the CSV.", "Error");
					    	 }
					    }
					finally
					{
						frmSchoolOfIt.setCursor(Cursor.getDefaultCursor());
						lblPleaseWaitCSVGenerated.setVisible(false); 
					}
					}
				}
			}
		});
		btnGenerateCsv.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnGenerateCsv.setBounds(664, 367, 246, 23);
		pnlAcademicEntryUI.add(btnGenerateCsv);
		
		lblPleaseWaitCSVGenerated = new JLabel("Generating CSV... Please Wait");
		lblPleaseWaitCSVGenerated.setFont(new Font("Calibri", Font.ITALIC, 12));
		lblPleaseWaitCSVGenerated.setVisible(false);
		lblPleaseWaitCSVGenerated.setBounds(664, 397, 298, 14);
		pnlAcademicEntryUI.add(lblPleaseWaitCSVGenerated);
		
		lblApplicationStatus = new JLabel("Application Status");
		lblApplicationStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblApplicationStatus.setBounds(402, 335, 107, 14);
		pnlAcademicEntryUI.add(lblApplicationStatus);
		
		lblLevelOfStudy = new JLabel("Level of Study Program:");
		lblLevelOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblLevelOfStudy.setBounds(402, 310, 137, 14);
		pnlAcademicEntryUI.add(lblLevelOfStudy);
		
		lblAcademicEntryMessage = new JLabel("Select an applicant to view its details:");
		lblAcademicEntryMessage.setFont(new Font("Calibri", Font.BOLD, 12));
		lblAcademicEntryMessage.setBounds(33, 11, 341, 23);
		pnlAcademicEntryUI.add(lblAcademicEntryMessage);
		
		cbxStudyPrograms = new JComboBox<String>();
		cbxStudyPrograms.setFont(new Font("Calibri", Font.PLAIN, 12));
		populateComboBox(cbxStudyPrograms, "DegreesForFilters.txt");
		cbxStudyPrograms.setBounds(537, 277, 367, 22);
		pnlAcademicEntryUI.add(cbxStudyPrograms);
		
		lblStudyProgram = new JLabel("Study Program:");
		lblStudyProgram.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblStudyProgram.setBounds(402, 281, 282, 14);
		pnlAcademicEntryUI.add(lblStudyProgram);
		
		cbxLevel = new JComboBox<String>();
		populateComboBox(cbxLevel, "Levels.txt");
		cbxLevel.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxLevel.setBounds(537, 304, 367, 22);
		pnlAcademicEntryUI.add(cbxLevel);
		
		cbxApplicationStatus = new JComboBox<String>();
		cbxApplicationStatus.setFont(new Font("Calibri", Font.PLAIN, 12));
		populateComboBox(cbxApplicationStatus, "ApplicationStatusesForFilters.txt");
		cbxApplicationStatus.setBounds(537, 333, 367, 22);
		pnlAcademicEntryUI.add(cbxApplicationStatus);
		
		lblNameOfCSVFile = new JLabel("");
		lblNameOfCSVFile.setBounds(287, 333, 98, 23);
		pnlAcademicEntryUI.add(lblNameOfCSVFile   );
		
		JButton btnViewApplication_1 = new JButton("View Application");
		btnViewApplication_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				populateApplicationFields(applicant, application);
				bEdit = false;
				showPersonalDetails();
				
			}
		});
		btnViewApplication_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnViewApplication_1.setBounds(33, 260, 246, 23);
		pnlAcademicEntryUI.add(btnViewApplication_1);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnLogOut.setBounds(797, 11, 107, 23);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				academic = null;
				applicant = null;
				application = null;
				showSignInInterface();
			}
		});
		pnlAcademicEntryUI.add(btnLogOut);
		
		btnMoreApplications = new JButton(">>>");
		btnMoreApplications.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnMoreApplications.setBounds(663, 11, 107, 23);
		btnMoreApplications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPrevApplications.setVisible(true);
				
				startIndex = endIndex;
				endIndex = startIndex + 12;
				if (endIndex > data.getApplicantsAndTheirApplications().size()) {endIndex = data.getApplicantsAndTheirApplications().size();}
				
				tblApplications.setModel(appController.populateApplicationsTable(model, getSubArrayList(data.getApplicantsAndTheirApplications(), startIndex, endIndex)));
				
				if (endIndex == data.getApplicantsAndTheirApplications().size())
				{
					btnMoreApplications.setVisible(false);
				}
			}
		});	
		pnlAcademicEntryUI.add(btnMoreApplications);
		
		btnPrevApplications = new JButton("<<<");
		btnPrevApplications.setVisible(false);
		btnPrevApplications.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnPrevApplications.setBounds(546, 11, 107, 23);
		btnPrevApplications.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMoreApplications.setVisible(true);
				
				endIndex = startIndex;
				startIndex = endIndex - 12;
				if (startIndex < 0) {endIndex = 0;}
				
				tblApplications.setModel(appController.populateApplicationsTable(model, getSubArrayList(data.getApplicantsAndTheirApplications(), startIndex, endIndex)));
				
				if (endIndex == data.getApplicantsAndTheirApplications().size())
				{
					btnMoreApplications.setVisible(false);
				}
			}
		});	
		pnlAcademicEntryUI.add(btnPrevApplications);
		
		populateComboBox(cbxApplicationApplicationStatus, "ApplicationStatusesForCombo.txt");
		cbxApplicationApplicationStatus.setFont(new Font("Calibri", Font.PLAIN, 11));
		cbxApplicationApplicationStatus.setBounds(232, 34, 273, 22);
		cbxApplicationApplicationStatus.setEditable(true);
		populateComboBox(cbxApplicationStatusReason, "StatusReasonsForCombo.txt");
		cbxApplicationStatusReason.setFont(new Font("Calibri", Font.PLAIN, 11));
		cbxApplicationStatusReason.setBounds(232, 59, 273, 22);
		cbxApplicationStatusReason.setEditable(true);
		JScrollPane scrollBars = new JScrollPane();
		frmSchoolOfIt.getContentPane().add(scrollBars);
		
		tblApplications = new JTable();
		scrollBars.setViewportView(tblApplications);
		scrollBars.setVisible(true);
		scrollBars.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		 
		tblApplications.setFont(new Font("Calibri", Font.PLAIN, 12));
		model = new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Application #", "Applicant #", "Application Status", "Previous Qualification", "Instituition of Previous Qualification", "Programme of Study"  
				}
			); 
		tblApplications.setModel(appController.populateApplicationsTable(model, getSubArrayList(data.getApplicantsAndTheirApplications(), startIndex, 12)));
		tblApplications.getColumnModel().getColumn(0).setPreferredWidth(89);
		tblApplications.getColumnModel().getColumn(3).setPreferredWidth(116);
		tblApplications.getColumnModel().getColumn(4).setPreferredWidth(106);
		tblApplications.getColumnModel().getColumn(5).setResizable(false);
		tblApplications.setBounds(33, 36, 871, 220);
		tblApplications.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (tblApplications.getSelectedRow() > 0)
				{
					applicant = userController.getApplicant(tblApplications.getValueAt(tblApplications.getSelectedRow(), 1).toString().trim());
					userController.setApplicantOfFocus(applicant);
					application = appController.getApplicationOfApplicant(applicant.getApplicantNumber());
					appController.setApplicationOfFocus(application);
				}
			}
		});
		pnlAcademicEntryUI.add(tblApplications);
	}
	
	/**
	 * Method sets form such as to allow for sign up.
	 */
	public void prepareSignUp()
	{
		bSignIn = false;
		lblNewMessage.setVisible(false); 
		btnGoToSignUpProcess.setVisible(false);
		lblConfirmPassword.setVisible(true);
		pswConfirmPassword.setVisible(true);
		btnSign.setText("Sign-Up");
		JOptionPane.showMessageDialog(frmSchoolOfIt,"To all potential applicants:" + "\n" + "If one does not already have a UCT Student Number," + "\n" + "then one needs to first apply at UCT Online Applications " + "\n" + "-one will then receive an Applicant number" + "\n" + "and the School of IT will notify you once you can apply.");
	}
	
	/**
	 * Method populates application field values with the current information of the applicant and their application
	 * @param anApplicant Specified Applicant whose fields/characteristics should be used to populate UI fields.
	 * @param theirApplication Specified Application of the Applicant that will be used to populate UI Fields.
	 */
	public void populateApplicationFields(Applicant anApplicant, Application theirApplication)
	{
		/*
		Applicant temp;
		if (anApplicant instanceof InternationalApplicant) {
			temp = new InternationalApplicant(anApplicant);
		} else if (anApplicant instanceof SouthAfricanApplicant) {
			temp = new SouthAfricanApplicant(anApplicant);
		} else {
			temp = new Applicant(anApplicant);
		}
		clearApplicationFields();
		if (temp instanceof InternationalApplicant) {
			anApplicant = new InternationalApplicant(temp);
		} else if (temp instanceof SouthAfricanApplicant) {
			anApplicant = new SouthAfricanApplicant(temp);
		} else {
			anApplicant = new Applicant(temp);
		}*/
		
		txtApplicationNumber.setText(theirApplication.getApplicationNumber());
		txtApplicationStatus.setText(theirApplication.getApplicationStatus().getStatusDescripition());
		txtApplicationReasonStatus.setText(theirApplication.getApplicationStatus().getReasonDescription());
		txtApplicantApplicationNumber.setText(theirApplication.getApplicationNumber());
		txtApplicantApplicationStatus.setText(theirApplication.getApplicationStatus().getStatusDescripition());
		txtStatusReason.setText(theirApplication.getApplicationStatus().getReasonDescription());
		txtrMessage.setText(theirApplication.getApplicationStatus().generateMessageForApplicant());
		
		txtApplicantNumber.setText(anApplicant.getApplicantNumber());
		String surname = anApplicant.getSurname();
		if (!nullOrBlank(surname))
		{
			txtSurname.setText(surname);
		}
		
		String firstName = anApplicant.getFirstName();
		if (!nullOrBlank(firstName))
		{
			txtFirstName.setText(firstName);
		}
		String title = anApplicant.getTitle();
		if (!nullOrBlank(title))
		{
			cbxTitle.setSelectedItem(title);
		}
		
		String citizenship = anApplicant.getCitizenship();
		if (!nullOrBlank(citizenship))
		{
			cbxCitizenship.setSelectedItem(citizenship);
			String citCountry = anApplicant.getCitizenshipCountry();
			if (citizenship.contains("South African")) {
				if (!nullOrBlank(citCountry)) {
					cbxCountry.setSelectedItem(citCountry);
				} else {
					anApplicant.setCitizenshipCountry("South Africa");
					cbxCountry.setSelectedItem("South Africa");
				}
			}
		}
		
		String email = anApplicant.getEmail();
		if (!nullOrBlank(email))
		{
			txtEmail.setText(email);
		}
		
		String cell = anApplicant.getCellPhone();
		if (!nullOrBlank(cell))
		{
			txtCellphone.setText(cell);
		}

		String line = anApplicant.getResidenceAddress().getLineAddress();
		if (!nullOrBlank(line))
		{
			txtrLineAddress.setText(line);
		}
		
		String resCountry = anApplicant.getResidenceAddress().getCountry();
		if (itemListedInComboBox(resCountry, cbxResCountry)) 
		{
			cbxResCountry.setSelectedItem(resCountry);
		}
		else if (!nullOrBlank(resCountry))
		{
			cbxResCountry.setSelectedItem("Other");
			lblResCountryOther .setVisible(true);
			txtResCountryOther.setText(resCountry);
		}

		String degUni = anApplicant.getPreviousQualification().getTertiaryInstitution();
		if (!nullOrBlank(degUni))
		{
			txtDegUniversity.setText(degUni);
		}
		
		if (itemListedInComboBox(anApplicant.getPreviousQualification().getCountry(), cbxDegCountry))
		{
			cbxDegCountry.setSelectedItem(anApplicant.getPreviousQualification().getCountry());
		}
		else if (!nullOrBlank(anApplicant.getPreviousQualification().getCountry()))
		{
			cbxDegCountry.setSelectedItem("Other");
			lbldegCountry.setVisible(true);
			txtDegCountryOther.setText(anApplicant.getPreviousQualification().getCountry());
			
		}
		if (itemListedInComboBox(anApplicant.getPreviousQualification().getDegree(), cbxDegree)) 
		{
			cbxDegree.setSelectedItem(anApplicant.getPreviousQualification().getDegree());
		}
		else if (!nullOrBlank(anApplicant.getPreviousQualification().getDegree()))
		{
			cbxDegree.setSelectedItem("Other");
			lblDegOther.setVisible(true);
			txtDegOther.setText(anApplicant.getPreviousQualification().getDegree());
		}

		if (!nullOrBlank(anApplicant.getPreviousQualification().getNQFEquivalence()))
		{
			cbxNQF.setSelectedItem(anApplicant.getPreviousQualification().getNQFEquivalence());
		}
		
		if (Integer.valueOf(anApplicant.getPreviousQualification().getMinDuration()) != null)
		{
			spnMinDuration.setValue(anApplicant.getPreviousQualification().getMinDuration());
		}
		
		if (itemListedInComboBox(theirApplication.getStudyProgram().getAcademicQualification(), cbxStudyProgram))
		{
			cbxStudyProgram.setSelectedItem(theirApplication.getStudyProgram().getAcademicQualification());
		}
		else
		{
			if (!nullOrBlank(theirApplication.getStudyProgram().getAcademicQualification()))
			{
				cbxStudyProgram.setSelectedItem("Other");
				lblIfOtherSpecify.setVisible(true);
				txtStudyProgramOther.setText(theirApplication.getStudyProgram().getAcademicQualification());
			}
		}
		
		chckbxCertifiedTranscript.setSelected(theirApplication.getStudyProgram().requireTranscript());
		chckbxCurriculumVitaecv.setSelected(theirApplication.getStudyProgram().requireCV());
		chckbxResearchStatement.setSelected(theirApplication.getStudyProgram().requireResearchStatement());
		chckbxRefereesNames.setSelected(theirApplication.getStudyProgram().requireRefereesNames());
		chkbxFundingStatement.setSelected(theirApplication.getStudyProgram().requireFundingStatement());
		chckbxMotivation.setSelected(theirApplication.getStudyProgram().requireMotivation());
		
		if (!nullOrBlank(application.getPdfName()))
		{
			lblPDFName.setText(application.getPdfName());
		}
		
		//Determine if South African or International Applicant
		if (applicant.getCitizenship().equals("International")) //International Applicant
		{
			applicant = userController.getApplicant(anApplicant.getApplicantNumber());
			userController.setApplicantOfFocus(applicant);
			
			
			lblIdPassport.setText("Passport Number:");
			lblIdPassport.setVisible(true);
			String passport = ((InternationalApplicant)applicant).getPassport();
			if (nullOrBlank(passport))
			{
				txtIDPassport.setText("");
			}
			else
			{
				txtIDPassport.setText(passport);
			}
		}
		else if (applicant.getCitizenship().contains("South African"))//South African Applicant
		{
			applicant = userController.getApplicant(anApplicant.getApplicantNumber());
			userController.setApplicantOfFocus(applicant);
			lblIdPassport.setText("ID number:");
			lblIdPassport.setVisible(true);
			
			String id = ((SouthAfricanApplicant)applicant).getID();
			if (nullOrBlank(id))
			{
				txtIDPassport.setText("");
			}
			else
			{
				txtIDPassport.setText(id);
			}
			
			lblRace.setVisible(true);
			
			String race = ((SouthAfricanApplicant)applicant).getRace();
			if (!nullOrBlank(race))
			{
				cbxRace.setSelectedItem(race);
			}
		}
		
		//check for MIT application
		if (theirApplication.getStudyProgram().getAcademicQualification().contains("(MIT)"))
		{
			lblPriorItExperience.setVisible(true);
			
			int priorIT = ((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getPriorITExperience();
			if (Integer.valueOf(priorIT) != null)
			{
				spnYearsITExperience.setValue(priorIT);
			}
			
			lblLevelOfUndergraduate.setVisible(true);
			lblAveragesPerMathematics.setVisible(false);
			lblAverageMathLevel1.setVisible(false);
			lblAverageMathLevel2.setVisible(false);
			lblAverageMathLevel3.setVisible(false);
			txtAverageMathLevel1.setVisible(false);
			txtAverageMathLevel2.setVisible(false);
			txtAverageMathLevel3.setVisible(false);
			
			int highMath = ((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getHighestLevelUndergradMathematcs();
			if (Integer.valueOf(highMath) != null)
			{
				
				spnLevelUndergrad.setValue(highMath);
				if (highMath > 0)
				{	
					lblAveragesPerMathematics.setVisible(true);
					double average = ((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getUndergradMaths()[0].getAverage();
					lblAverageMathLevel1.setVisible(true);
					txtAverageMathLevel1.setText(String.valueOf(average));
					txtAverageMathLevel1.setVisible(true);
				}
				if (highMath > 1)
				{
					double average = ((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getUndergradMaths()[1].getAverage();
					lblAverageMathLevel2.setVisible(true);
					txtAverageMathLevel2.setText(String.valueOf(average));
					txtAverageMathLevel2.setVisible(true);
				}
				if (highMath > 2)
				{
					double average = ((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getUndergradMaths()[2].getAverage();
					lblAverageMathLevel3.setVisible(true);
					txtAverageMathLevel3.setText(String.valueOf(average));
					txtAverageMathLevel3.setVisible(true);
				}	
			}
				
			if (((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).hasProjectThesis())
			{
				
				chckbxPreviousDegreeHadProjectThesis.setSelected(true);
				txtrProvideBriefDescription.setText(((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getDescriptionProjectThesis());
				
				txtrProvideBriefDescription.setVisible(true);
			}
			else
			{
				
				chckbxPreviousDegreeHadProjectThesis.setSelected(false);
				txtrProvideBriefDescription.setVisible(false);
			}
		}	

		String pdf = theirApplication.getPdfName();
		if (!nullOrBlank(pdf))
		{
			lblPDFName.setText(pdf);
		}
	}
	
	/**
	 * Method clears all application interface fields.
	 */
	public void clearApplicationFields()
	{
		txtApplicationNumber.setText("");
		txtApplicationStatus.setText("");
		txtApplicationReasonStatus.setText("");
		txtApplicantApplicationNumber.setText("");
		txtApplicantApplicationStatus.setText("");
		txtStatusReason.setText("");
		txtrMessage.setText("");
		
		txtApplicantNumber.setText("");
		txtSurname.setText("");
		txtFirstName.setText("");
		cbxTitle.setSelectedIndex(-1);
		cbxCitizenship.setSelectedIndex(-1);
		cbxCountry.setSelectedIndex(-1);

		txtEmail.setText("");
		txtCellphone.setText("");
		txtrLineAddress.setText("");
		cbxResCountry.setSelectedIndex(-1);
		lblResCountryOther.setVisible(false);
		txtResCountryOther.setText("");
		txtResCountryOther.setVisible(false);

		txtDegUniversity.setText("");
		cbxDegCountry.setSelectedIndex(-1);
		txtDegCountryOther.setText("");
		txtDegCountryOther.setVisible(false);
		cbxDegree.setSelectedIndex(-1);
		lblDegOther.setVisible(false);
		txtDegOther.setText("");
		cbxNQF.setSelectedIndex(-1);
		spnMinDuration.setValue(Integer.valueOf(1));
		cbxStudyProgram.setSelectedIndex(-1);
		lblIfOtherSpecify.setVisible(false);
		txtStudyProgramOther.setText("");
		txtStudyProgramOther.setVisible(false);

		chckbxCertifiedTranscript.setSelected(true);
		chckbxCurriculumVitaecv.setSelected(true);
		chckbxResearchStatement.setSelected(true);
		chckbxRefereesNames.setSelected(true);
		chkbxFundingStatement.setSelected(true);
		chckbxMotivation.setSelected(true);
		
		lblPDFName.setText("");
		
		lblIdPassport.setText("");
		lblIdPassport.setVisible(false);
		txtIDPassport.setText("");
		txtIDPassport.setVisible(false);
		lblRace.setVisible(false);
		cbxRace.setSelectedIndex(-1);
		cbxRace.setVisible(false);

		lblPriorItExperience.setVisible(false);
		spnYearsITExperience.setValue(Integer.valueOf(0));
		spnYearsITExperience.setVisible(false);
		spnLevelUndergrad.setValue(Integer.valueOf(0));
		spnLevelUndergrad.setVisible(false);
		lblLevelOfUndergraduate.setVisible(true);
		lblAveragesPerMathematics.setVisible(false);
		lblAverageMathLevel1.setVisible(false);
		lblAverageMathLevel2.setVisible(false);
		lblAverageMathLevel3.setVisible(false);
		txtAverageMathLevel1.setVisible(false);
		txtAverageMathLevel2.setVisible(false);
		txtAverageMathLevel3.setVisible(false);
		txtAverageMathLevel1.setText("");
		txtAverageMathLevel2.setText("");
		txtAverageMathLevel3.setText("");
		txtrProvideBriefDescription.setText("");
		chckbxPreviousDegreeHadProjectThesis.setSelected(false);
		txtrProvideBriefDescription.setVisible(false);
		chckbxPreviousDegreeHadProjectThesis.setVisible(false);
		
		lblPDFName.setText("");		
	}
	
	/**
	 * Populates the given combo box using the given text file.
	 * @param comboBox The combo box to be populated.
	 * @param fileName The text file to populate the combo box with.
	 */
	private void populateComboBox(JComboBox<String> comboBox, String fileName)
	{
		//clean combo box to avoid duplicates
		comboBox.removeAllItems();
		
		//read items
		Scanner comboItems = null;
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
			System.out.println("Error populating combo box.");
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
	
	/**
	 * Check if a specific item is listed in a given combo box.
	 * @param item The item to search for in the combo box.
	 * @param comboBox The combo box to be searched.
	 * @return Whether or not a specific item is listed in a given combo box.
	 */
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
	
	/**
	 * Show the sign in interface.
	 */
	private void showSignInInterface()
	{
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
		
		bSignIn = true;
		btnGoToSignUpProcess.setVisible(true);
		lblConfirmPassword.setVisible(false);
		pswConfirmPassword.setVisible(false);
		btnSign.setText("Sign-In");
	}
	
	/**
	 * Show the interface that the academics first see when entering the system.
	 */
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
		
		startIndex=0;
		tblApplications.setModel(appController.populateApplicationsTable(model, getSubArrayList(data.getApplicantsAndTheirApplications(), startIndex, 12)));
		btnPrevApplications.setVisible(false);
		btnMoreApplications.setVisible(true);
	}
	
	/**
	 * Show the interface that returning applicants first see when entering the system.
	 */
	private void showApplicantEntryInterface()
	{
		bApplicantSignedIn = true; 
		bNewApplicationStarted = false;
		
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
		
		
		if (appController.applicationEditable(application.getApplicationNumber()))
		{
			btnEditApplication.setVisible(true);
		}
		else
		{
			btnEditApplication.setVisible(false);
		}
		
		if (application.getApplicationStatus().getStatusDescripition().contains("Withdrawn"))
		{
			btnRemoveApplication.setVisible(false);
		}
		else
		{
			btnRemoveApplication.setVisible(true);
		}
	}
	
	/**
	 * Show the personal details application interface.
	 */
	private void showPersonalDetails()
	{
		btnNext.setEnabled(true);
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
		
		mntmPersonalDetails.setFont(new Font("Calibri", Font.BOLD, 12));
		mntmContactDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmTertiaryQual.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		btnPrevious.setEnabled(false);
		
		boolean bInternational = applicant.getCitizenship().equals("International");
		boolean bRSA = applicant.getCitizenship().contains("South African");
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
		
		txtSurname.setEditable(bEdit);
		txtFirstName.setEditable(bEdit);
		cbxTitle.setEnabled(bEdit);
		cbxCitizenship.setEnabled(bEdit);
		if (cbxCitizenship.getSelectedIndex() > -1 && cbxCitizenship.getSelectedItem().toString().contains("South Africa")) {
			cbxCountry.setEnabled(false);
		} else cbxCountry.setEnabled(bEdit);
		txtIDPassport.setEditable(bEdit);
		cbxRace.setEnabled(bEdit);
		
		if (bApplicantSignedIn) //for application process completion
		{
			btnSubmitReturn.setVisible(false);
		} 
		else
		{
			btnSubmitReturn.setVisible(true);
		}
	}
	
	/**
	 * Show the contact details application interface.
	 */
	private void showContactDetails()
	{
		btnPrevious.setEnabled(true);
		btnNext.setEnabled(true);
		
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
		
		mntmPersonalDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmContactDetails.setFont(new Font("Calibri", Font.BOLD, 12));
		mntmTertiaryQual.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		txtEmail.setEditable(bEdit);
		txtCellphone.setEditable(bEdit);
		txtrLineAddress.setEditable(bEdit);
		cbxResCountry.setEnabled(bEdit);
		txtResCountryOther.setEditable(bEdit);
			
		if (application.getApplicationStatus().getStatusCode().equalsIgnoreCase("CRTD")) //new application
		{
			btnSubmitReturn.setText("Submit");
		}
		else //existing application
		{
			btnSubmitReturn.setText("Return");
		}

		if (bApplicantSignedIn) //for application process completion
		{
			btnSubmitReturn.setVisible(false);
		} 
		else
		{
			btnSubmitReturn.setVisible(true);
		}
	}
	
	/**
	 * Show the tertiary qualifications application interface.
	 */
	private void showTertiaryQualifications()
	{
		btnPrevious.setEnabled(true);
		btnNext.setEnabled(true);
		
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
		
		mntmPersonalDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmContactDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmTertiaryQual.setFont(new Font("Calibri", Font.BOLD, 12));
		mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		txtDegUniversity.setEditable(bEdit);
		cbxDegCountry.setEnabled(bEdit);
		txtDegCountryOther.setEditable(bEdit);
		cbxDegree.setEnabled(bEdit);
		txtDegOther.setEditable(bEdit);
		cbxNQF.setEnabled(bEdit);
		spnMinDuration.setEnabled(bEdit);
			
		if (application.getApplicationStatus().getStatusCode().equalsIgnoreCase("CRTD")) //new application
		{
			btnSubmitReturn.setText("Submit");
		}
		else //existing application
		{
			btnSubmitReturn.setText("Return");
		}
		
		if (bApplicantSignedIn) //for application process completion
		{
			btnSubmitReturn.setVisible(false);
		}
		else 
		{
			btnSubmitReturn.setVisible(true);
		}
	}
	
	/**
	 * Show the study program application interface.
	 */
	private void showStudyProgram()
	{
		btnPrevious.setEnabled(true);
		btnNext.setEnabled(true);
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
		
		mntmPersonalDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmContactDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmTertiaryQual.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.BOLD, 12));
		mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		cbxStudyProgram.setEnabled(bEdit);
		txtStudyProgramOther.setEditable(bEdit);
		spnYearsITExperience.setEnabled(bEdit);
		txtAverageMathLevel1.setEditable(bEdit);
		txtAverageMathLevel2.setEditable(bEdit);
		txtAverageMathLevel3.setEditable(bEdit);
		spnLevelUndergrad.setEnabled(bEdit);
		txtAverageMathLevel1.setEditable(bEdit);
		txtAverageMathLevel2.setEditable(bEdit);
		txtAverageMathLevel3.setEditable(bEdit);
		chckbxPreviousDegreeHadProjectThesis.setEnabled(bEdit);
		txtrProvideBriefDescription.setEditable(bEdit);
		
		if (cbxStudyProgram.getSelectedIndex() > -1)
		{
			String studyProgram = cbxStudyProgram.getSelectedItem().toString();
		
			lblIfOtherSpecify.setVisible(studyProgram.contains("Other"));
			txtStudyProgramOther.setVisible(studyProgram.contains("Other"));
		
			lblPriorItExperience.setVisible(studyProgram.contains("(MIT)"));
			spnYearsITExperience.setVisible(studyProgram.contains("(MIT)"));
			lblLevelOfUndergraduate.setVisible(studyProgram.contains("(MIT)"));
			spnLevelUndergrad.setVisible(studyProgram.contains("(MIT)"));
			chckbxPreviousDegreeHadProjectThesis.setVisible(studyProgram.contains("(MIT)"));
		}
		else
		{
			lblIfOtherSpecify.setVisible(false);
			txtStudyProgramOther.setVisible(false);
		
			lblPriorItExperience.setVisible(false);
			spnYearsITExperience.setVisible(false);
			lblLevelOfUndergraduate.setVisible(false);
			spnLevelUndergrad.setVisible(false);
			chckbxPreviousDegreeHadProjectThesis.setVisible(false);
		
		}
		
		if (application.getApplicationStatus().getStatusCode().equalsIgnoreCase("CRTD")) //new application
		{
			btnSubmitReturn.setText("Submit");
		}
		else //existing application
		{
			btnSubmitReturn.setText("Return");
		}
		
		if (bApplicantSignedIn) //for application process completion
		{
			btnSubmitReturn.setVisible(false);
		}
		else 
		{
			btnSubmitReturn.setVisible(true);
		}
	}
	
	/**
	 * Show the additional documentation application interface.
	 */
	private void showAdditionalDocumentation()
	{
		btnPrevious.setEnabled(true);
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
		
		mntmPersonalDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmContactDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmTertiaryQual.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmRequiredDocumentation.setFont(new Font("Calibri", Font.BOLD, 12));
		
		
		btnNext.setEnabled(false);
		
		if (bApplicantSignedIn) {  //for application process completion
			btnSubmitReturn.setVisible(true);
		} else {
			btnSubmitReturn.setVisible(true);
		}
		
		//
		if ((!bApplicantSignedIn) && bSignIn) //academic signed-in -> fields view only
		{
			btnChoosePDF.setVisible(false);
			btnUploadFile.setVisible(false);
			btnDownloadPDF.setVisible(true);
			
		}
		else //applicant signed in
		{
			//Editable if application is editable and user selected edit mode.
			boolean bEditable = ((appController.applicationEditable(application.getApplicationNumber()) && bEdit) || bNewApplicationStarted); 
			btnChoosePDF.setVisible(bEditable);
			btnUploadFile.setVisible(bEditable);
			btnDownloadPDF.setVisible(!bEditable);
				
			if (application.getApplicationStatus().getStatusCode().equalsIgnoreCase("CRTD")) //new application
			{
				btnSubmitReturn.setText("Submit");
			}
			else //existing application
			{
				btnSubmitReturn.setText("Return");
			}
		}
	}
	
	/**
	 * Checks if all the personal details fields have all been populated and are all acceptable.
	 * @return True if details acceptable, false otherwise.
	 */
	private boolean checkPersonalDetails()
	{
		if (nullOrBlank(txtSurname.getText().toString().trim()))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide surname by clicking next to the label.", "Field not completed", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (nullOrBlank(txtFirstName.getText().toString().trim()))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide first name by clicking next to the label.", "Field not completed", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (cbxTitle.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select title.", "Item not selected", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		

		if (!(cbxCitizenship.getSelectedIndex() > -1))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select a citizenship.", "Item not selected", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (cbxCitizenship.getSelectedItem().toString().contains("International"))
		{
			if (!(cbxCountry.getSelectedIndex() > -1)) 
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select a country.", "Item not selected", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if (cbxCountry.getSelectedItem().toString().trim().contains("South Africa"))
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please either select South African citizenship or select a different country.", "Inconsistent information", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			if (nullOrBlank(txtIDPassport.getText().toString().trim()))
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide passport by clicking next to the label.", "Field not completed", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		else if (cbxCitizenship.getSelectedItem().toString().contains("South Africa"))
		{
			if (!(cbxCountry.getSelectedIndex() > -1)) 
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select a country.", "Item not selected", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			if (cbxCountry.getSelectedItem().toString().trim().contains("citizen") && (!(cbxCountry.getSelectedItem().toString().trim().contains("South Africa"))))
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please either change citizenship or select a different country.", "Inconsistent information", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			if (nullOrBlank(txtIDPassport.getText().toString().trim()))
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide an ID number by clicking next to the label.", "Field not completed", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			if (cbxRace.getSelectedIndex() == -1)
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select a race.", "Item not selected", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		else
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt,  "Please select a citizenship status.", "Item not selected",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (cbxCountry.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select a country.", "Item not selected",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	/**
	 * Checks if all the contact details fields have all been populated and are all acceptable.
	 * @return True if details acceptable, false otherwise.
	 */
	private boolean checkContactDetails()
	{
		if (nullOrBlank(txtEmail.getText().toString().trim()))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide email by clicking next to the label.", "Field not completed", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (!txtEmail.getText().toString().trim().contains("@"))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Email must contain @.", "Field cannot be read", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (nullOrBlank(txtCellphone.getText().toString().trim()))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide cell phone by clicking next to the label.", "Field not completed", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if ((txtCellphone.getText().toString().trim().charAt(0) == '+') && (txtCellphone.getText().toString().trim().length() != 12))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Phone number should either start with code or 0, i.e. +27762613100 or 0762613100", "Field cannot be read", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if ((txtCellphone.getText().toString().trim().charAt(0) == '0') && (txtCellphone.getText().toString().trim().length() != 10))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Phone number should either start with code or 0, i.e. +27762613100 or 0762613100", "Field cannot be read", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if ((txtCellphone.getText().toString().trim().charAt(0) != '0') && (txtCellphone.getText().toString().trim().charAt(0) != '+'))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Phone number should either start with code or 0, i.e. +27762613100 or 0762613100", "Field cannot be read", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (nullOrBlank(txtrLineAddress.getText().toString().trim()))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide line address", "Field not completed", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (cbxResCountry.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select country of residence.", "Item not selected", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (cbxResCountry.getSelectedItem().toString().trim().contains("Other"))
		{
			if (nullOrBlank(txtResCountryOther.getText().toString().trim()))
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide country of residence by clicking next to the label requesting you to specify.", "Field not completed", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else if ((cbxCitizenship.getSelectedItem().toString().trim().contains("South African permanent resident")) && (!(txtResCountryOther.getText().toString().trim().contains("South Africa"))))
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please either change citizenship or select South Africa as country of residence.", "Inconsistent information", JOptionPane.ERROR_MESSAGE);
				return false;		
			}
		}
		else if ((cbxCitizenship.getSelectedItem().toString().trim().contains("South African permanent resident")) && (!(cbxResCountry.getSelectedItem().toString().trim().contains("South Africa"))))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please either change citizenship or select South Africa as country of residence.", "Inconsistent information", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	/**
	 * Checks if all the qualification details fields have all been populated and are all acceptable.
	 * @return True if details acceptable, false otherwise.
	 */
	private boolean checkQualificationDetails()
	{
		if (cbxDegCountry.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select country where previous degree had been obtained.", "Item not selected", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if ((cbxDegCountry.getSelectedItem().toString().trim().contains("Other")) && (nullOrBlank(txtDegCountryOther.getText().toString().trim())))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide country where previous degree has been obtained by clicking next to the label requesting you to specify.", "Field not completed", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (cbxDegree.getSelectedIndex() == -1)
		{
			
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select a previous degree.", "Item not selected", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if ((cbxDegree.getSelectedItem().toString().trim().contains("Other")) && (nullOrBlank(txtDegOther.getText().toString().trim())))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide previous degree by clicking next to the label requesting you to specify.", "Field not completed", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (cbxNQF.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select NQF of previous degree.", "Item not selected", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (nullOrBlank(spnMinDuration.getValue().toString().trim()))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide minimum time that were needed to complete the previous degree", "Field not completed", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		if (nullOrBlank(txtDegUniversity.getText().toString().trim()))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide university that awarded previous degree.", "Field not completed", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	/**
	 * Checks if all the study program details fields have all been populated and are all acceptable.
	 * @return True if details acceptable, false otherwise.
	 */
	private boolean checkStudyProgramDetails()
	{		
		if (cbxStudyProgram.getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please select study programme.", "Item not selected", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (cbxStudyProgram.getSelectedItem().toString().trim().contains("Other"))
		{
			if (nullOrBlank(txtStudyProgramOther.getText().toString().trim()))
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide study prgramme for which you are applying next to the label requesting you to specify.", "Field not completed", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}
		else if (cbxStudyProgram.getSelectedItem().toString().trim().contains("MIT"))
		{	
			if (nullOrBlank(spnYearsITExperience.getValue().toString()))
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide the number of years of IT experience that you have.", "Field not completed", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			
			int level = (int) spnLevelUndergrad.getValue();
			
			if (level > 0)
			{
				String average = txtAverageMathLevel1.getText().toString().trim();
				if (nullOrBlank(average))
				{
					JOptionPane.showMessageDialog(frmSchoolOfIt,"Please provide average for Undergraduate Mathematics 1",  "Field not completed", JOptionPane.ERROR_MESSAGE);
					return false;
				}
				else
				{
					try 
					{
			            double avg = Double.parseDouble(average);
			            if ((avg<0) || (avg>100))
			            {
			            	JOptionPane.showMessageDialog(frmSchoolOfIt, "Please enter an average between 0 and 100.", "Out of bounds value", JOptionPane.ERROR_MESSAGE);
			            }
			        } 
					catch (NumberFormatException e) 
					{
						JOptionPane.showMessageDialog(frmSchoolOfIt, "Please enter an average as an integer or decimal number, i.e 80 or 80.0 or 80.00 for 80%", "Incorrect format or type", JOptionPane.ERROR_MESSAGE);
						return false;
			        }
					
				}
			}
			
			if (level > 1)
			{
				String average = txtAverageMathLevel2.getText().toString().trim();
				if (nullOrBlank(average))
				{
					JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide average for Undergraduate Mathematics 2", "Field not completed", JOptionPane.ERROR_MESSAGE);
					return false;
				}
				else
				{
					try 
					{
						double avg = Double.parseDouble(average);
			            if ((avg<0) || (avg>100))
			            {
			            	JOptionPane.showMessageDialog(frmSchoolOfIt, "Please enter an average between 0 and 100.", "Out of bounds value", JOptionPane.ERROR_MESSAGE);
			            }
			        } 
					catch (NumberFormatException e) 
					{
						JOptionPane.showMessageDialog(frmSchoolOfIt, "Incorrect format or type", "Please enter an average as an integer or decimal number, i.e 80 or 80.0 or 80.00 for 80%", JOptionPane.ERROR_MESSAGE);
						return false;
			        }
					
				}
			}
			
			if (level > 2)
			{
				String average = txtAverageMathLevel3.getText().toString().trim();
				if (nullOrBlank(average))
				{
					JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide average for Undergraduate Mathematics 3", "Field not completed", JOptionPane.ERROR_MESSAGE);
					return false;
				}
				else
				{
					try 
					{
						double avg = Double.parseDouble(average);
			            if ((avg<0) || (avg>100))
			            {
			            	JOptionPane.showMessageDialog(frmSchoolOfIt, "Please enter an average between 0 and 100.", "Out of bounds value", JOptionPane.ERROR_MESSAGE);
			            }
			        } 
					catch (NumberFormatException e) 
					{
						JOptionPane.showMessageDialog(frmSchoolOfIt, "Please enter an average as an integer or decimal number, i.e 80 or 80.0 or 80.00 for 80%", "Incorrect format or type", JOptionPane.ERROR_MESSAGE);
						return false;
			        }
					
				}
			}
			
			if ((chckbxPreviousDegreeHadProjectThesis.isSelected()) && (nullOrBlank(txtrProvideBriefDescription.getText().toString().trim()) || (txtrProvideBriefDescription.getText().toString().trim().equals("Provide Brief Description of Project or Thesis Component"))))
			{
				JOptionPane.showMessageDialog(frmSchoolOfIt, "Please provide description of thesis component.", "Field not completed", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}	
		return true;
	}
	
	/**
	 * Checks if the user has uploaded additional documents.
	 * @return True if additional documents uploaded, false otherwise. 
	 */
	private boolean checkAdditionalDocuments()
	{		
		if (nullOrBlank(lblPDFName.getText().toString().trim()))
		{
			JOptionPane.showMessageDialog(frmSchoolOfIt, "Please choose a single PDF with all required documents and then upload it.", "PDF not uploaded", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	/**
	 * Displays the inputs for the undergraduate math averages.
	 * @param level The number of undergraduate math inputs to display.
	 */
	private void displayUndergradMathInputs(int level)
	{
		lblAveragesPerMathematics.setVisible((level > 0));
		lblAverageMathLevel1.setVisible((level > 0));
		txtAverageMathLevel1.setVisible((level > 0));
		
		lblAverageMathLevel2.setVisible((level > 1));
		txtAverageMathLevel2.setVisible((level > 1));
		
		lblAverageMathLevel3.setVisible((level > 2));
		txtAverageMathLevel3.setVisible((level > 2));
	}
	
	/**
	 * Checks if the given string is null or blank.
	 * @param input The given string.
	 * @return Whether the given string is null or blank. 
	 */
	private boolean nullOrBlank(String input)
	{
		return input.equals(null) || input.isEmpty() || input.equals("") || input.equals(" ");
	}
	
	/**
	 * Populates the lists for application statuses and status change reasons.
	 */
	private void populateLists()
	{
		//read items
		Scanner reader = null;
		ArrayList<String> statuses = new ArrayList<String>();
		ArrayList<String> reasons = new ArrayList<String>();
		try
		{
			reader = new Scanner(new FileReader("ApplicationStatusesForCombo.txt"));
					
					
			while (reader.hasNextLine())
			{
				statuses.add(reader.nextLine().trim());
			}
			
			reader = new Scanner(new FileReader("StatusReasonsForCombo.txt"));
			
			
			while (reader.hasNextLine())
			{
				reasons.add(reader.nextLine().trim());
			}
		}
		catch(IOException e)
		{
			System.out.println("Error in populating combo box.");
		}
		finally
		{
			if (reader != null)
			{
				reader.close();
			}
		}
		
		statuses.trimToSize();
		reasons.trimToSize();
		
		appStatuses = new String[statuses.size()];
		appReasons = new String[reasons.size()];
		
		appStatuses = statuses.toArray(appStatuses);
		appReasons = reasons.toArray(appReasons);
	}
	
	/**
	 * Get a sub array from an original array.
	 * @param arrayList The original array.
	 * @param startIncl The start index of the sub array (inclusive).
	 * @param endExcl The end index of the sub array (exclusive).
	 * @return The sub array.
	 */
	private ArrayList<ApplicantApplicationReference> getSubArrayList(ArrayList<ApplicantApplicationReference> arrayList, int startIncl, int endExcl)
	{
		arrayList.trimToSize();
		if (startIncl < 0) {startIncl = 0;}
		if (endExcl > arrayList.size()) {endExcl = arrayList.size();}
		List<ApplicantApplicationReference> sub = (List<ApplicantApplicationReference>) arrayList.subList(startIncl, endExcl);
		ArrayList<ApplicantApplicationReference> tmp = new ArrayList<ApplicantApplicationReference>(sub);
		tmp.trimToSize();
		return tmp;
	}
	
}
