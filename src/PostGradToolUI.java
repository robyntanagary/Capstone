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
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
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
	private String[] titles;
	private String[] races;
	private String[] citizenships;
	private String[] degrees;
	private String[] NQF;
	private JCheckBox chkbxFundingStatement;
	private JTextField txtSignEmail;
	private boolean bApplicantSignedIn;
	private JComboBox cbxApplicationApplicationStatus;
	private JComboBox cbxApplicationStatusReason;
	
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
		appController = new ApplicationController();
		userController = new UserController();
		bSignIn = true;
		initialize();
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
		
		pnlApplicationUI = new JPanel();
		pnlApplicationUI.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlApplicationUI.setBounds(0, 0, 718, 390);
		frmSchoolOfIt.getContentPane().add(pnlApplicationUI);
		pnlApplicationUI.setLayout(null);
		
		pnlProgrammeOfStudy = new JPanel();
		pnlProgrammeOfStudy.setBounds(235, 86, 459, 282);
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
		pnlProgrammeOfStudy.add(txtStudyProgramOther);
		
		lblIfOtherSpecify = new JLabel("If Other, Specify:");
		lblIfOtherSpecify.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblIfOtherSpecify.setBounds(10, 46, 124, 24);
		pnlProgrammeOfStudy.add(lblIfOtherSpecify);
		
		cbxStudyProgram = new JComboBox<String>();
		cbxStudyProgram.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				String studyProgram = cbxStudyProgram.getSelectedItem().toString();
				
				lblIfOtherSpecify.setVisible(studyProgram.equals("Other"));
				txtStudyProgramOther.setVisible(studyProgram.equals("Other"));
				
				lblPriorItExperience.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
				spnYearsITExperience.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
				lblLevelOfUndergraduate.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
				spnLevelUndergrad.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
				chckbxPreviousDegreeHadProjectThesis.setVisible(studyProgram.equals("Masters in Information Technology (MIT)"));
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
			}
		});
		txtAverageMathLevel1.setBounds(219, 175, 50, 20);
		pnlProgrammeOfStudy.add(txtAverageMathLevel1);
		txtAverageMathLevel1.setColumns(10);
		
		txtAverageMathLevel2 = new JTextField();
		txtAverageMathLevel2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		txtAverageMathLevel2.setBounds(279, 175, 50, 20);
		pnlProgrammeOfStudy.add(txtAverageMathLevel2);
		txtAverageMathLevel2.setColumns(10);
		
		txtAverageMathLevel3 = new JTextField();
		txtAverageMathLevel3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
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
			}
		});
		spnYearsITExperience.setFont(new Font("Calibri", Font.PLAIN, 12));
		spnYearsITExperience.setBounds(219, 85, 30, 20);
		pnlProgrammeOfStudy.add(spnYearsITExperience);
		
		chckbxPreviousDegreeHadProjectThesis = new JCheckBox("Previous Degree had Project or Thesis Component");
		chckbxPreviousDegreeHadProjectThesis.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
			}
		});
		chckbxPreviousDegreeHadProjectThesis.setBounds(10, 206, 269, 23);
		pnlProgrammeOfStudy.add(chckbxPreviousDegreeHadProjectThesis);
		
		txtrProvideBriefDescription = new JTextArea();
		txtrProvideBriefDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
			@Override
			public void focusLost(FocusEvent e) {
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
		lblPdfOfAdditional.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPdfOfAdditional.setBounds(10, 170, 204, 23);
		pnlAdditionalDocumentation.add(lblPdfOfAdditional);
		
		btnChoosePDF = new JButton("Choose File");
		btnChoosePDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPDFName.setText(appController.showChosenPDF());
				btnUploadFile.setVisible(true);
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
				appController.downloadPDF(lblPDFName.getText().trim());
			}
		});
		btnDownloadPDF.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnDownloadPDF.setBounds(330, 192, 119, 23);
		pnlAdditionalDocumentation.add(btnDownloadPDF);
		
		chkbxFundingStatement = new JCheckBox("Funding Statement");
		chkbxFundingStatement.setFont(new Font("Calibri", Font.PLAIN, 12));
		chkbxFundingStatement.setEnabled(false);
		chkbxFundingStatement.setBounds(10, 95, 141, 23);
		pnlAdditionalDocumentation.add(chkbxFundingStatement);
		
		pnlPersonalDetails = new JPanel();
		pnlPersonalDetails.setBounds(235, 87, 459, 282);
		pnlApplicationUI.add(pnlPersonalDetails);
		pnlPersonalDetails.setLayout(null);
		
		txtApplicantNumber = new JTextField();
		txtApplicantNumber.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
			}
		});
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
		cbxCitizenship.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
				//if South African, set cbxCountry to South Africa
			}
		});
		cbxCitizenship.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxCitizenship.setBounds(160, 151, 188, 22);
		pnlPersonalDetails.add(cbxCitizenship);
		
		cbxRace = new JComboBox<String>();
		cbxRace.setVisible(false);
		cbxRace.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
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
		cbxCountry.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
			}
		});
		cbxCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxCountry.setBounds(160, 185, 188, 22);
		pnlPersonalDetails.add(cbxCountry);
		
		pnlContactDetails = new JPanel();
		pnlContactDetails.setBounds(235, 86, 459, 282);
		pnlApplicationUI.add(pnlContactDetails);
		pnlContactDetails.setLayout(null);
		
		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblEmail.setBounds(10, 11, 125, 25);
		pnlContactDetails.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
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
		cbxResCountry.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		cbxResCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxResCountry.setBounds(160, 192, 190, 22);
		pnlContactDetails.add(cbxResCountry);
		
		pnlTertiaryQualifications = new JPanel();
		pnlTertiaryQualifications.setBounds(235, 87, 459, 282);
		pnlApplicationUI.add(pnlTertiaryQualifications);
		pnlTertiaryQualifications.setLayout(null);
		
		lbldegCountry = new JLabel("Country where Previous Degree was Obtained:");
		lbldegCountry.setFont(new Font("Calibri", Font.PLAIN, 12));
		lbldegCountry.setBounds(10, 12, 262, 25);
		pnlTertiaryQualifications.add(lbldegCountry);
		
		txtDegCountryOther = new JTextField();
		txtDegCountryOther.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
			}
		});
		txtDegCountryOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtDegCountryOther.setColumns(10);
		txtDegCountryOther.setBounds(267, 48, 182, 25);
		pnlTertiaryQualifications.add(txtDegCountryOther);
		
		lblPreviousDegree = new JLabel("If Other, Specify:");
		lblPreviousDegree.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPreviousDegree.setBounds(10, 46, 124, 24);
		pnlTertiaryQualifications.add(lblPreviousDegree);
		
		cbxDegCountry = new JComboBox<String>();
		cbxDegCountry.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
			}
		});
		cbxDegCountry.setBounds(267, 11, 182, 22);
		pnlTertiaryQualifications.add(cbxDegCountry);
		
		lblPreviousDegree_1 = new JLabel("Previous Degree:");
		lblPreviousDegree_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblPreviousDegree_1.setBounds(10, 82, 262, 25);
		pnlTertiaryQualifications.add(lblPreviousDegree_1);
		
		cbxDegree = new JComboBox<String>();
		cbxDegree.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
			}
		});
		cbxDegree.setBounds(267, 81, 182, 22);
		pnlTertiaryQualifications.add(cbxDegree);
		
		txtDegOther = new JTextField();
		txtDegOther.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
			}
		});
		txtDegOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtDegOther.setColumns(10);
		txtDegOther.setBounds(267, 118, 182, 25);
		pnlTertiaryQualifications.add(txtDegOther);
		
		lblDegOther = new JLabel("If Other, Specify:");
		lblDegOther.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblDegOther.setBounds(10, 116, 124, 24);
		pnlTertiaryQualifications.add(lblDegOther);
		
		lblNqfEquivalentOf = new JLabel("NQF Equivalent of Previous Degree:");
		lblNqfEquivalentOf.setFont(new Font("Calibri", Font.PLAIN, 12));
		lblNqfEquivalentOf.setBounds(10, 155, 262, 25);
		pnlTertiaryQualifications.add(lblNqfEquivalentOf);
		
		cbxNQF = new JComboBox<String>();
		cbxNQF.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent e) {
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
			}
		});
		txtDegUniversity.setFont(new Font("Calibri", Font.PLAIN, 12));
		txtDegUniversity.setColumns(10);
		txtDegUniversity.setBounds(267, 224, 182, 25);
		pnlTertiaryQualifications.add(txtDegUniversity);
		
		pnlApplicationFieldCats = new JPanel();
		pnlApplicationFieldCats.setBounds(32, 76, 193, 162);
		pnlApplicationUI.add(pnlApplicationFieldCats);
		pnlApplicationFieldCats.setLayout(null);
		
		mntmPersonalDetails = new JMenuItem("Personal Details");
		mntmPersonalDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmPersonalDetails.setBounds(0, 0, 190, 26);
		mntmPersonalDetails.setIcon(null);
		pnlApplicationFieldCats.add(mntmPersonalDetails);
		mntmPersonalDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		
		mntmContactDetails = new JMenuItem("Contact Details");
		mntmContactDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmContactDetails.setBounds(0, 30, 190, 26);
		mntmContactDetails.setHorizontalAlignment(SwingConstants.LEFT);
		mntmContactDetails.setFont(new Font("Calibri", Font.PLAIN, 12));
		pnlApplicationFieldCats.add(mntmContactDetails);
		
		mntmTertiaryQual = new JMenuItem("Tertiary Qualifications");
		mntmTertiaryQual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmTertiaryQual.setBounds(-1, 61, 191, 26);
		mntmTertiaryQual.setHorizontalAlignment(SwingConstants.LEFT);
		mntmTertiaryQual.setFont(new Font("Calibri", Font.PLAIN, 12));
		pnlApplicationFieldCats.add(mntmTertiaryQual);
		
		mntmProgrammeOfStudy = new JMenuItem("Programme of Study");
		mntmProgrammeOfStudy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmProgrammeOfStudy.setBounds(-1, 98, 191, 26);
		mntmProgrammeOfStudy.setHorizontalAlignment(SwingConstants.LEFT);
		mntmProgrammeOfStudy.setFont(new Font("Calibri", Font.PLAIN, 12));
		pnlApplicationFieldCats.add(mntmProgrammeOfStudy);
		
		mntmRequiredDocumentation = new JMenuItem("Additional Documentation");
		mntmRequiredDocumentation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmRequiredDocumentation.setHorizontalAlignment(SwingConstants.LEFT);
		mntmRequiredDocumentation.setFont(new Font("Calibri", Font.PLAIN, 12));
		mntmRequiredDocumentation.setBounds(0, 131, 190, 26);
		pnlApplicationFieldCats.add(mntmRequiredDocumentation);
		
		btnNewButton = new JButton("Previous");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnNewButton.setBounds(42, 249, 89, 23);
		pnlApplicationUI.add(btnNewButton);
		
		btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					userController.insertOrUpdateInternationalApplicant(intApplicant);
				}
				else
				{
					userController.insertOrUpdateSouthAfricanApplicant(rsaApplicant);
				}
				
				appController.insertOrUpdateApplication(application);
			}
		});
		btnSaveUpdate.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnSaveUpdate.setBounds(42, 283, 89, 23);
		pnlApplicationUI.add(btnSaveUpdate);
		
		btnSubmitReturn = new JButton("Submit / Return");
		btnSubmitReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (application.getApplicationStatus().getStatusCode().equalsIgnoreCase("CRTD")) //new application -> submit
				{
					if (applicant.getCitizenship().equals(""))
					{
						userController.insertOrUpdateApplicant(applicant);
					}
					else if (applicant.getCitizenship().equals("International"))
					{
						userController.insertOrUpdateInternationalApplicant(intApplicant);
					}
					else
					{
						userController.insertOrUpdateSouthAfricanApplicant(rsaApplicant);
					}
					
					appController.submitApplication(application);
				}
				else //existing application
				{
					showApplicantEntryInterface();
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
		
		cbxApplicationApplicationStatus = new JComboBox();
		cbxApplicationApplicationStatus.setFont(new Font("Calibri", Font.PLAIN, 11));
		cbxApplicationApplicationStatus.setBounds(232, 34, 273, 22);
		cbxApplicationApplicationStatus.setVisible(false);
		pnlApplicationUI.add(cbxApplicationApplicationStatus);
		
		cbxApplicationStatusReason = new JComboBox();
		cbxApplicationStatusReason.setFont(new Font("Calibri", Font.PLAIN, 11));
		cbxApplicationStatusReason.setBounds(232, 59, 273, 22);
		cbxApplicationStatusReason.setVisible(false);
		pnlApplicationUI.add(cbxApplicationStatusReason);
		
		pnlApplicantEntry = new JPanel();
		pnlApplicantEntry.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlApplicantEntry.setBounds(0, 0, 718, 390);
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
			}
		});
		btnViewApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnViewApplication.setBounds(281, 220, 141, 23);
		pnlApplicantEntry.add(btnViewApplication);
		
		btnEditApplication = new JButton("Edit Application");
		btnEditApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnEditApplication.setBounds(281, 260, 141, 23);
		pnlApplicantEntry.add(btnEditApplication);
		
		btnRemoveApplication = new JButton("Remove Application");
		btnRemoveApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveApplication.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnRemoveApplication.setBounds(281, 294, 141, 23);
		pnlApplicantEntry.add(btnRemoveApplication);
		
		pnlAcademicEntryUI = new JPanel();
		pnlAcademicEntryUI.setBackground(UIManager.getColor("InternalFrame.inactiveTitleGradient"));
		pnlAcademicEntryUI.setBounds(0, 0, 718, 390);
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
		tblApplications.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Application #", "Country of Citizenship", "Previous Qualification", "Programme of Study", "Reason for Status", "Applicant #", "Application Status"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tblApplications.getColumnModel().getColumn(0).setPreferredWidth(89);
		tblApplications.getColumnModel().getColumn(3).setPreferredWidth(116);
		tblApplications.getColumnModel().getColumn(4).setPreferredWidth(106);
		tblApplications.getColumnModel().getColumn(5).setResizable(false);
		tblApplications.getColumnModel().getColumn(6).setPreferredWidth(103);
		tblApplications.setBounds(33, 36, 661, 220);
		pnlAcademicEntryUI.add(tblApplications);
		
		btnChooseCSV = new JButton("Choose CSV");
		btnChooseCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChooseCSV.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnChooseCSV.setBounds(33, 333, 246, 23);
		pnlAcademicEntryUI.add(btnChooseCSV);
		
		lblUploadCSVMessage = new JLabel("Upload CSV to Notify Potential Applicants to Apply:");
		lblUploadCSVMessage.setBounds(33, 304, 258, 14);
		pnlAcademicEntryUI.add(lblUploadCSVMessage);
		
		btnUploadCsv = new JButton("Upload CSV");
		btnUploadCsv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		cbxStudyPrograms.setBounds(537, 277, 157, 22);
		pnlAcademicEntryUI.add(cbxStudyPrograms);
		
		lblStudyProgram = new JLabel("Study Program:");
		lblStudyProgram.setBounds(412, 281, 282, 14);
		pnlAcademicEntryUI.add(lblStudyProgram);
		
		cbxLevel = new JComboBox<String>();
		cbxLevel.setFont(new Font("Calibri", Font.PLAIN, 12));
		cbxLevel.setBounds(537, 304, 157, 22);
		pnlAcademicEntryUI.add(cbxLevel);
		
		cbxApplicationStatus = new JComboBox<String>();
		cbxApplicationStatus.setBounds(537, 331, 157, 22);
		pnlAcademicEntryUI.add(cbxApplicationStatus);
		
		lblNameOfCSVFile = new JLabel("");
		lblNameOfCSVFile.setBounds(287, 333, 98, 23);
		pnlAcademicEntryUI.add(lblNameOfCSVFile   );
		
		JButton btnViewApplication_1 = new JButton("View Application");
		btnViewApplication_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnViewApplication_1.setFont(new Font("Calibri", Font.PLAIN, 12));
		btnViewApplication_1.setBounds(33, 267, 246, 23);
		pnlAcademicEntryUI.add(btnViewApplication_1);
		
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
		
		lblNewMessage = new JLabel("New to School of IT Application System? Click Sign-Up.");
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
				String number = txtSignInApplicantNumber.getText().toString(); //get number repressing username
				String password = pswPassword.getPassword().toString(); //get password
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
						applicant = userController.getApplicant(number);
						userController.setApplicantOfFocus(applicant);
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
		txtrApplicantNumberWarning.setText("Please note all potential applicants: One needs to apply first at UCT Online Applications to receive an Applicant Number, unless you already have a UCT Student Nuber.");
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
		
		chckbxCertifiedTranscript.setSelected(theirApplication.getStudyProgram().isRequireTranscript());
		chckbxCurriculumVitaecv.setSelected(theirApplication.getStudyProgram().isRequireCV());
		chckbxResearchStatement.setSelected(theirApplication.getStudyProgram().isRequireResearchStatement());
		chckbxRefereesNames.setSelected(theirApplication.getStudyProgram().isRequireRefereesNames());
		chkbxFundingStatement.setSelected(theirApplication.getStudyProgram().isRequireFundingStatement());
		chckbxMotivation.setSelected(theirApplication.getStudyProgram().isRequireMotivation());
		//lblPDFName
		
		//Determine if South African or International Applicant
		if (applicant.equals("International")) //International Applicant
		{
			intApplicant = userController.getInternationalApplicant(anApplicant.getApplicantNumber());
			userController.setInternationalApplicantOfFocus(intApplicant);
			lblIdPassport.setText("Passport Number:");
			lblIdPassport.setVisible(true);
			txtIDPassport.setText(intApplicant.getPassport());	
			
		}
		else //South African Applicant
		{
			rsaApplicant = userController.getSouthAfricanApplicant(anApplicant.getApplicantNumber());
			userController.setSouthAfricanApplicantOfFocus(rsaApplicant);
			lblIdPassport.setText("ID number:");
			lblIdPassport.setVisible(true);
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
				txtAverageMathLevel1.setText(String.valueOf(((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getUndergradMaths()[1].getAvarage()));
			}
			if (((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getHighestLevelUndergradMathematcs() > 1)
			{
				lblAverageMathLevel2.setVisible(true);
				txtAverageMathLevel2.setText(String.valueOf(((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getUndergradMaths()[2].getAvarage()));
			}
			if (((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getHighestLevelUndergradMathematcs() > 2)
			{
				lblAverageMathLevel2.setVisible(true);
				txtAverageMathLevel3.setText(String.valueOf(((TertiaryQualificationForMIT) anApplicant.getPreviousQualification()).getUndergradMaths()[3].getAvarage()));
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
	}
	
	private void populateComboBox(JComboBox comboBox, String fileName)
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
	
	private boolean itemListedInComboBox(String item, JComboBox comboBox)
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
		mntmContactDetails.setSelected(false);
		mntmTertiaryQual.setSelected(false);
		mntmProgrammeOfStudy.setSelected(false);
		mntmRequiredDocumentation.setSelected(false);
		
		
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
		mntmTertiaryQual.setSelected(false);
		mntmProgrammeOfStudy.setSelected(false);
		mntmRequiredDocumentation.setSelected(false);
		
		//
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
	
	private void showTertiaryQualifications()
	{
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
		mntmProgrammeOfStudy.setSelected(false);
		mntmRequiredDocumentation.setSelected(false);
	}
	
	private void showStudyProgram()
	{
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
		mntmRequiredDocumentation.setSelected(false);
		
		//
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
	
	private void showAdditionalDocumentation()
	{
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
	
	private String checkPersonalDetails()
	{
		//needs logic!
		return "";
	}
	
	private String checkContactDetails()
	{
		//needs logic!
		return "";
	}
	
	private String checkQualificationDetails()
	{
		//needs logic!
		return "";
	}
	
	private String checkStudyProgramDetails()
	{
		//needs logic!
		return "";
	}
	
	private String checkAdditionalDocuments()
	{
		//needs logic!
		return "";
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
