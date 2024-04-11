package com.shivam.blogapplication.controllers;

import com.shivam.blogapplication.entities.EmailDetails;
import com.shivam.blogapplication.services.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-email")
    public ResponseEntity<Set<String>> sendEmailToMultipleRecipients(EmailDetails emailDetails) {
        setDetailsInEmail(emailDetails);
        return new ResponseEntity<>(emailService.sendEmails(emailDetails), HttpStatus.OK);
    }

    static void setDetailsInEmail(EmailDetails emailDetails){
        Set<String> emailSet = new HashSet<>();
        addMailInSet(emailSet);

        Set<String> newEmails = new HashSet<>();
        //newEmails.add("chandru.c@hcl.com"); // HCLTech Company
        newEmails.add("aisha@bigshyft.com");
        newEmails.add("careers@spericorn.com");

        /*

        tel:+919354314601 : hasStudioz call resume sent
        Ritika.jain@zeno.health
        jaiswalkamakshi1997@gmail.com
        poorva.shri@paramountpioneers.com
        Aditi.MORE@3ds.com
        agoel@fortinet.com
        Mithun.ravikiran@gmail.com
        rushikesh@primeconsulting-inc.com
        madhumitap497@gmail.com
        varma@SuthraTech.com
        shanmukhauppalapati08@gmail.com
        careers@cashkaro.com
        sksharini@gmail.com
        * */

        String subject = "Skilled Java & Full Stack Developer with 1.6 Years Experience";
        String body = "<html><body style='color: black;'>" +
                "<p>Dear Sir/Ma'am,</p>" +
                "<p>I trust this message finds you well.</p>" +
                "<p>I am writing to express my keen interest in the Java Developer position within your esteemed organization. With a solid foundation of 1 year and 6 months in Java development, coupled with hands-on experience in advanced technologies, I am eager to leverage my expertise to drive excellence within your team.</p>" +
                "<p>Here are some key highlights that underscore my qualifications:</p>" +
                "<ul>" +
                "<li>Proficiency in Java programming, complemented by a deep understanding of cutting-edge frameworks such as Spring and Hibernate.</li>" +
                "<li>Demonstrated mastery in object-oriented design principles and adept management of databases including MySQL and MongoDB.</li>" +
                "<li>A proven track record of fostering collaboration and innovation within cross-functional teams, resulting in enhanced productivity and successful project outcomes.</li>" +
                "</ul>" +
                "<p>My skill set encompasses:</p>" +
                "<ul>" +
                "<li>Java (with expertise in Spring Boot and Spring MVC)</li>" +
                "<li>Good knowledge of Data Structures and Algorithms</li>" +
                "<li>Database proficiency in MongoDB and MySQL</li>" +
                "<li>Proficiency in front-end technologies: HTML, CSS, and JavaScript</li>" +
                "<li>Experience with Version Control systems such as GitHub and Git</li>" +
                "<li>Strong problem-solving abilities</li>" +
                "<li>Familiarity with project management tools like JIRA</li>" +
                "</ul>" +
                "<p>I am genuinely excited about the prospect of contributing to your company's success and am available at your earliest convenience for further discussion or an interview. Please find my resume attached for your review.</p>" +
                "<p>Thank you for considering my application. I look forward to the opportunity to discuss how my skills and experiences align with the needs of your team.</p>" +
                "<p><b>Warm regards,</b><br/>" +
                "<b>Shivam</b><br/>" +
                "<b>shivamsorout8814@gmail.com</b><br/>" +
                "<b>8814848155</b></p>" +
                "</body></html>";

        emailDetails.setRecipient(newEmails);
        emailDetails.setSubject(subject);
        emailDetails.setMsgBody(body);
        emailDetails.setAttachment("D:\\My Office Work\\Shivam\\Shivam Documents\\ShivamResume.pdf");
    }

    private static void addMailInSet(Set<String> emailSet) {
        emailSet.add("deepak.n@pearlcons.com");
        emailSet.add("hardik.thapa@thewitslab.com");
        emailSet.add("arti.singh@esolglobal.com");  //replied
        emailSet.add("Vivek.opulentsoft@gmail.com");
        emailSet.add("talent.acquisition@yirontechnologies.com");
        emailSet.add("ayusingh@deloitte.com");
        emailSet.add("recruit@vsourcetalent.com");
        emailSet.add("shweta@snakescript.com");
        emailSet.add("career.cybrain@gmail.com");
        emailSet.add("manish22sinha@gmail.com");
        emailSet.add("rakesh.ramesh@apexon.com");
        emailSet.add("career@destinyhrgroup.com ");
        emailSet.add("dinesh.skyron.hr@gmail.com");
        emailSet.add("ayusingh@deloitte.com");
        emailSet.add("neha.pandey@bluethink.in");
        emailSet.add("priyanka@peoplestaff.in");
        emailSet.add("arun.kumar3@landmarkgroup.com");
        emailSet.add("neha.pandey@bluethink.in");
        emailSet.add("komal@arohatechnologies.com");
        emailSet.add("hr@clarity-medical.com");
        emailSet.add("hr@cybernative.in");
        emailSet.add("sailee.gaonkar@ril.com");
        emailSet.add("tanya@praxists.co.in");
        emailSet.add("bhupendrakumar.jain@gmail.com");
        emailSet.add("keerthi.jayakumar@puresoftware.com");
        emailSet.add("ayusingh@deloitte.com");
        emailSet.add("jobs-india@tagrem.com");
        emailSet.add("tech@sogdo.com");
        emailSet.add("rupalig@scalextechnologies.com");
        emailSet.add("neha.pandey@bluethink.in");
        emailSet.add("vaibhav.khunteta@marktine.com");
        emailSet.add("sravani@bridgenexus.com");
        emailSet.add("manisha.gouda@careernet.in");
        emailSet.add("shipalitheresa.dsilva@diamondpick.com");
        emailSet.add("shweta.malde@v2stech.com");
        emailSet.add("rajesh@dstechnologiesinc.com");
        emailSet.add("amit.p.choudhary@impetus.com");
        emailSet.add("divyani.ghadi@ril.com");
        emailSet.add("soudamini.raut@walmart.com");
        emailSet.add("Sarun.karunakaran@mastechdigital.com");
        emailSet.add("indumathi.m@betsol.com");
        emailSet.add("roselin@reveilletechnologies.com");
        emailSet.add("soudamini.raut@walmart.com");
        emailSet.add("rashi@huntingcube.com");
        emailSet.add("durga.p@techmahindra.com");
        emailSet.add("pagadala.madhavi@satincorp.co.in");
        emailSet.add("ahmed@burgeonits.net");
        emailSet.add("dipti.porje@ampcustech.com");
        emailSet.add("supriya.waghmare@bluethink.in");
        emailSet.add("ritu.r3@concentrix.com");
        emailSet.add("hr.veritasrm@gmail.com");
        emailSet.add("bhuvana.g@sellcraft.net");
        emailSet.add("akansha2@aliqan.com");
        emailSet.add("Bhavani@epeopletech.com");
        emailSet.add("srujanreddy@unifind.net");
        emailSet.add("aravindarlugala@gmail.com");
        emailSet.add("tej@xladvisors.co");
        emailSet.add("surya.prakash@quadranttechnologies.com");
        emailSet.add("aniket.raut@thinkitiv.com");
        emailSet.add("mounika.n@ivispl.com");
        emailSet.add("manasa@cygnuspro.com");
        emailSet.add("durga.p@techmahindra.com");
        emailSet.add("ankeet.pandey@envisiontechsol.com");
        emailSet.add("anshika@questhiring.com");
        emailSet.add("prabhdeep.kaur@mobileprogramming.c");
        emailSet.add("shivangini.seth@techmahindra.com");
        emailSet.add("uma@santosystems.com");
        emailSet.add("varshar@infinitiresearch.com");
        emailSet.add("ashwijashetty@deltek.com");
        emailSet.add("saimahesh.k@buzzworks.com");
        emailSet.add("soma@sapotsystems.com");
        emailSet.add("mfardeenhusain@teksystems.com");
        emailSet.add("rkumar8@teksystems.com");
        emailSet.add("naveena@nerdsandgeeks.in");
        emailSet.add("info@goldenhire.in");
        emailSet.add("cnaveen@nexwaveinc.com");
        emailSet.add("harshukk98@gmail.com");
        emailSet.add("swati.k@optivalue.com");
        emailSet.add("hr@nerdsandgeeks.in");
        emailSet.add("vedansh0390@gmail.com");
        emailSet.add("lekshmi@minecraftconsulting.in");
        emailSet.add("ragini.b@qmail.quesscorp.com");
        emailSet.add("rahul.anand@gspann.com");
        emailSet.add("saritha.n@costaffglobal.in");
        emailSet.add("Devshi@spruceinfotech.com");
        emailSet.add("tejas.kandale@neoquant.com");
        emailSet.add("rushali.shelar@impact-infotech.com");
        emailSet.add("alina@binarystarsearchx.com");
        emailSet.add("Devshi@spruceinfotech.com");
        emailSet.add("Shaik.s@numaware.com");
        emailSet.add("Azhagukumaran.mohan@relevantz.com");
        emailSet.add("shailesh@thetechgalore.com");
        emailSet.add("deepak@9dimensions.in");
        emailSet.add("Neha.Chourasiya@ltimindtree.com");
        emailSet.add("jananianandhan248@gmail.com");
        emailSet.add("mrunalik@heaptrace.net");
        emailSet.add("muskan@natalieconsultants.com");
        emailSet.add("akhil@atvsllc.com");
        emailSet.add("lavanya@leonztech.com");
        emailSet.add("shashi@leonztech.com");
        emailSet.add("career@sapientcodelabs.com");
        emailSet.add("ritika.mehta@buzzclan.com");
        emailSet.add("keerthi@techwizens.com");
        emailSet.add("ravi.k@s3staff.com");
        emailSet.add("Yaswanth@bigappleinfotech.com");
        emailSet.add("ashokkumars@newtglobalcorp.com");
        emailSet.add("srekha@teksystems.com");
        emailSet.add("suraj.b@veritis.com");
        emailSet.add("prachi@spruceinfotech.com");
        emailSet.add("sanngeetakhaloria@deltek.com");
        emailSet.add("shabeena@skillety.com");
        emailSet.add("rajiv.ryan@mindtickle.com");
        emailSet.add("sunny@archantstech.com");
        emailSet.add("raghu@summitglt.com");
        emailSet.add("balaji.v@sightspectrum.com");
        emailSet.add("thananjeyan.m@aroha.co.in");
        emailSet.add("sushmita.v@e-solutionsinc.com");
        emailSet.add("trastogi@symplr.com");
        emailSet.add("rahul.s@s3staff.com");
        emailSet.add("nagesh@global-tech.co.in");
        emailSet.add("hr@tetrain.com");
        emailSet.add("satyendra@annapurnafin.org");
        emailSet.add("Shubhamrana@azaakisolutions.com");
        emailSet.add("sudhaker@tranzeal.com");
        emailSet.add("Neha.Chourasiya@ltimindtree.com");
        emailSet.add("kvmanisha@deltek.com");
        emailSet.add("mansi.tmvus@gmail.com");
        emailSet.add("jparashar@vyzeinc.com");
        emailSet.add("vijay@magnustechnol.com");
        emailSet.add("kavya@zortechsolutions.ca");
        emailSet.add("karuna.ugale@mobikode.com");
        emailSet.add("ghulam.kashif@hexaviewtech.com");
        emailSet.add("Kanupriya.gupta.ban@gmail.com");
        emailSet.add("vishwajeet@questhiring.com");
        emailSet.add("vendor@bacancy.com");
        emailSet.add("natasha@itsabacus.om");
        emailSet.add("Harshita.sen@sutherlandglobal.com");
        emailSet.add("saniya@157ipl.com");
        emailSet.add("vandana.tripathi@amplesuccesshr.com");
        emailSet.add("sudipta.mahato@alikethoughts.com");
        emailSet.add("nagesh@global-tech.co.in");
        emailSet.add("gummadi.manikumar@rpainfotech.com");
        emailSet.add("mani.itrecruiter@zohomail.in");
        emailSet.add("HV00774316@techmahindra.com");
        emailSet.add("yogesh@tdnewton.com");
        emailSet.add("preeti@sierrasoln.com");
        emailSet.add("Neha.Chourasiya@ltimindtree.com");
        emailSet.add("hariharan.j@exaways.com");
        emailSet.add("Info@inspirationmanpower.co.in");
        emailSet.add("phani@atekit.com");
        emailSet.add("anusha@confluxsystems.com");
        emailSet.add("nick@hrpundits.com");
        emailSet.add("anusha@confluxsystems.com");
        emailSet.add("Ganashree@insightekgc.com");
        emailSet.add("syeda.p.banu@happiestminds.com");
        emailSet.add("priyadarshani@mindsoftindia.com");
        emailSet.add("Aryab.pal@247software.com");
        emailSet.add("soumyadeep@digitalaptech.com");
        emailSet.add("keshav@spruceinfotech.com");
        emailSet.add("vksinha1950@gmail.com");
        emailSet.add("kinshuk.swarnkar@velocis.co.in");
        emailSet.add("dataprotection@prescienthg.com");
        emailSet.add("jobs@Zettabolt.com");
        emailSet.add("hr@procure-net.com");
        emailSet.add("careers@energyaspects.com");
        emailSet.add("ankit@marketscope.in");
        emailSet.add("hemantkumar.vc@flipkart.com");
//        emailSet.add("careers@suesys.com");  //conversation start
        emailSet.add("madhumita.executive@nitsolution.in");
        emailSet.add("Divyani.Ghadi@ril.com");
        emailSet.add("Vaishali.Yadav1@genpact.com");
        emailSet.add("poornima.i@orbus.co.in");
        emailSet.add("sujala@conveytechlabs.com");
        emailSet.add("nitu@freebeez.in");
        emailSet.add("pooja.dhoot@orbus.co.in");
        emailSet.add("banita@cybrain.co.in");
        emailSet.add("vikas.nagalingu@expanz.in");
        emailSet.add("hr@75way.com");
        emailSet.add("hr@successpact.com");
        emailSet.add("hrpercept.simran@gmail.com");
        emailSet.add("kritika.srivastava@nethues.com");
        emailSet.add("techeruditehr@gmail.com");  //no vacancy
        emailSet.add("hiring.shreya@yahoo.com");
        emailSet.add("nikita.hiring@digitalify.in");
//        emailSet.add("hr.jayashree@digitalify.in");  job agency
        emailSet.add("sakshiwagh902@gmail.com");
        emailSet.add("b.shravya@cherictechnologies.com");
        emailSet.add("shyam.opulentsoft@gmail.com");
        emailSet.add("sathishkumar.m@vysystems.com");
        emailSet.add("Deepa.john@cgi.com");
        emailSet.add("sushma@nextgen-is.com");
        emailSet.add("mahammad@vellunta.com");
        emailSet.add("tengsal.sai@lor-venk.com");
        emailSet.add("hr@trialshopy.com");
        emailSet.add("ajithkumar.m@vysystems.com");
        emailSet.add("anushka@wuelev8.tech");
        emailSet.add("chandanavinnakota@gmail.com");
        emailSet.add("anagha.dabshede@ncircletech.com");
        emailSet.add("ganny.p@w2ssolutions.com");
        emailSet.add("venkatesh@nexwaveinc.com");
        emailSet.add("dawkhar.akshay@gmail.com");
        emailSet.add("keerthi@techwizens.com");
        emailSet.add("asoni@capritechnosys.com");
        emailSet.add("nireeksha@beqisoft.com");
        emailSet.add("ayushi@ntekco.com");
        emailSet.add("ram.bisht@stl.tech");
        emailSet.add("Krishna@talentboon.in");
        emailSet.add("percept.vidhib@gmail.com");
        emailSet.add("abhijitbhaduri@live.com");
        emailSet.add("Piyush.k@amberitstaffing.com");
        emailSet.add("it.rjtjobs@gmail.com");
        emailSet.add("srividya@nextgen-is.com");
        emailSet.add("smukherjee@aapnainfotech.com");
        emailSet.add("anjali@tanishasystems.com");
        emailSet.add("rjassi@enexusglobal.com");
        emailSet.add("dvmanoj@diamondpick.com");
        emailSet.add("surinder.kaur@amartam.com");
        emailSet.add("hephzibah@vysystems.com");
        emailSet.add("srividya@nextgen-is.com");
        emailSet.add("mani@confluxsystems.com");
        emailSet.add("sourcing@nexjob.in");
        emailSet.add("aditi@msoltechnology.com");
        emailSet.add("madhuri@spiceorb.com");
        emailSet.add("afreen.shaik@websynergies.com");
        emailSet.add("prathiksha.S@n2sglobal.com");
        emailSet.add("Mansi.Menghani@bajajallianz.co.in");
        emailSet.add("pragya@fxconsulting.in");
        emailSet.add("ajay.v@symplore.com");
        emailSet.add("mrunalik@heaptrace.net");
        emailSet.add("srushtishirwadkar@gmail.com");
        emailSet.add("jobs@mobisoftinfotech.com");
        emailSet.add("trapti@akinfolution.com");
        emailSet.add("digitalmkgt.rushabh@gmail.com");
        emailSet.add("sunil@techorbit.com");
        emailSet.add("sarath@nextgen-is.com");
        emailSet.add("manatelanganashow@gmail.com");
        emailSet.add("sunny@archantstech.com");
        emailSet.add("madhumita.executive@nitsolution.in");
        emailSet.add("sohail@yochana.com");
        emailSet.add("ishika@nettreesolutions.com");
        emailSet.add("sbose@bayonesolutions.com");
        emailSet.add("farheena.j@xpheno.com");
        emailSet.add("aftab@convextech.com");
        emailSet.add("avinash.chauhan@ascendion.com");
        emailSet.add("saniya@157ipl.com");
        emailSet.add("priyanka.mahajan@thedigitalgroup.com");
        emailSet.add("shivani.razdan@pathlock.com");
        emailSet.add("Sakthipriya@liveconnections.in");
        emailSet.add("nikita@tspls.com");
        emailSet.add("avinash.chauhan@ascendion.com");
        emailSet.add("shivani.razdan@pathlock.com");
        emailSet.add("jasmitha.y@soais.com");
        emailSet.add("nagaraju.p@avanceservices.com");
        emailSet.add("priya@trustklub.com");
        emailSet.add("praval@aekyainc.com");
        emailSet.add("akhil.kumar@codinglimits.com");
        emailSet.add("annie.antony@tcs.com");
        emailSet.add("anil@thetalentcommunity.com");
        emailSet.add("b.shravya@cherictechnologies.com");
        emailSet.add("meenakshi.joshi.ext@siemens-healthineers.com");
        emailSet.add("nisha.singh@suproinfo.com");
        emailSet.add("noxustech@hrexcel.in");
        emailSet.add("ritu.bansode@tcs.com");
        emailSet.add("shyam.opulentsoft@gmail.com");
        emailSet.add("tanya@sadupsoft.com");
        emailSet.add("ta2@innowrap.com");
        emailSet.add("umam@selsoftinc.com");
        emailSet.add("b.shravya@cherictechnologies.com");
        emailSet.add("shyam.opulentsoft@gmail.com");
        emailSet.add("hrpercept.simran@gmail.com");
        emailSet.add("sathishkumar.m@vysystems.com");
        emailSet.add("rakesh@dynasticx.com");
        emailSet.add("sribalaji@vysystems.com");
        emailSet.add("Deepa.john@cgi.com");
        emailSet.add("sushma@nextgen-is.com");
        emailSet.add("mahammad@vellunta.com");
        emailSet.add("tengsal.sai@lor-venk.com");
        emailSet.add("ajithkumar.m@vysystems.com");
        emailSet.add("dawkhar.akshay@gmail.com");
        emailSet.add("keerthi@techwizens.com");
        emailSet.add("asoni@capritechnosys.com");
        emailSet.add("saritha.n@costaffglobal.in");
        emailSet.add("nireeksha@beqisoft.com");
        emailSet.add("trapti@akinfolution.com");
        emailSet.add("sushmita.v@e-solutionsinc.com");
        emailSet.add("ram.bisht@stl.tech");
        emailSet.add("Krishna@talentboon.in");
        emailSet.add("percept.vidhib@gmail.com");
        emailSet.add("Piyush.k@amberitstaffing.com");
        emailSet.add("it.rjtjobs@gmail.com");
        emailSet.add("srividya@nextgen-is.com");
        emailSet.add("madhumita.executive@nitsolution.in");
        emailSet.add("srividya@nextgen-is.com");
        emailSet.add("ravi.k@s3staff.com");
        emailSet.add("ahalya.r@mapoutinc.com");
        emailSet.add("palak@cosettenetwork.com");
        emailSet.add("reena@isquaresoft.com");
        emailSet.add("kavita.kanyal@rtctek.com");
        emailSet.add("jyothi@costaffglobal.com");
        emailSet.add("mani@confluxsystems.com");
        emailSet.add("hari@psrtek.com");
        emailSet.add("sourcing@nexjob.in");
        emailSet.add("sneha@xladvisors.co");
        emailSet.add("aditi@msoltechnology.com");
        emailSet.add("ajay.v@symplore.com");
        emailSet.add("madhuri@spiceorb.com");
        emailSet.add("sathish.kr@diamondpick.com");
        emailSet.add("afreen.shaik@websynergies.com");
        emailSet.add("bansri.acumont@gmail.com");
        emailSet.add("prathiksha.S@n2sglobal.com");
        emailSet.add("ashok@sar-tech.net");
        emailSet.add("nupur.tiwari@ltimindtree.com");
        emailSet.add("chandni@titantechnology.co.in");
        emailSet.add("Mansi.Menghani@bajajallianz.co.in");
        emailSet.add("info@goldenhire.in");
        emailSet.add("pragya@fxconsulting.in");
        emailSet.add("madhuri@spiceorb.com");
        emailSet.add("ajay.v@symplore.com");
        emailSet.add("vishal.sharma3@publicissapient.com");
        emailSet.add("pallavi.singh@zenithinfotek.com");
        emailSet.add("mrunalik@heaptrace.net");
        emailSet.add("papatil91@gmail.com");
        emailSet.add("priya@trustklub.com");
        emailSet.add("hr@concettolabs.com");
        emailSet.add("srushtishirwadkar@gmail.com");
        emailSet.add("gayatri.gupta2@ltimindtree.com");
        emailSet.add("jobs@mobisoftinfotech.com");
        emailSet.add("supriya.singh@synechron.com");
        emailSet.add("sudipta.mahato@alikethoughts.com");
        emailSet.add("trapti@akinfolution.com");
        emailSet.add("ahmed@burgeonits.net");
        emailSet.add("thananjeyan.m@aroha.co.in");
        emailSet.add("digitalmkgt.rushabh@gmail.com");
        emailSet.add("Abishek.ilangovan@hcl.com");
        emailSet.add("sunil@techorbit.com");
        emailSet.add("vaishali.tyagi@impetus.com");
        emailSet.add("sarath@nextgen-is.com");
        emailSet.add("Sudip@nitsolution.in");
        emailSet.add("Vineeth@upstreamgs.com");
        emailSet.add("manatelanganashow@gmail.com");
        emailSet.add("sunny@archantstech.com");
        emailSet.add("Vinutha.v@cretalsolutions.com");
        emailSet.add("madhumita.executive@nitsolution.in");
        emailSet.add("sohail@yochana.com");
        emailSet.add("shivangini.seth@techmahindra.com");
        emailSet.add("sathishkumar@spruceinfotech.com");
        emailSet.add("ishika@nettreesolutions.com");
        emailSet.add("sbose@bayonesolutions.com");
        emailSet.add("deepak@9dimensions.in");
        emailSet.add("swati.devlal@publicissapient.com");
        emailSet.add("farheena.j@xpheno.com");
        emailSet.add("neelofer.hawawala@zemosolabs.com");
        emailSet.add("aftab@convextech.com");
        emailSet.add("avinash.chauhan@ascendion.com");
        emailSet.add("Nagam2@hexaware.com");
        emailSet.add("priyanka.mahajan@thedigitalgroup.com");
        emailSet.add("shivani.razdan@pathlock.com");
        emailSet.add("sravanig@fixitytech.com");
        emailSet.add("Sakthipriya@liveconnections.in");
        emailSet.add("manisha@theglove.co.in");
        emailSet.add("nikita@tspls.com");
        emailSet.add("deepamosur@commercecx.com");
        emailSet.add("Ishita.Nehra@axiomsoftwaresolutions.com");
        emailSet.add("ssharotri@compunnel.com");
        emailSet.add("ayushi.acumont@gmail.com");
        emailSet.add("manvi@natalieconsultants.com");
        emailSet.add("jasmitha.y@soais.com");
        emailSet.add("Vineeth@upstreamgs.com");
        emailSet.add("honey.lohani@awcsoftware.com");
        emailSet.add("nagaraju.p@avanceservices.com");
        emailSet.add("priya@trustklub.com");
        emailSet.add("mona.ujagare@ampcustech.com");
        emailSet.add("praval@aekyainc.com");
        emailSet.add("nikita@tspls.com");
        emailSet.add("avinash.chauhan@ascendion.com");
        emailSet.add("Ishita.Nehra@axiomsoftwaresolutions.com");
        emailSet.add("shivani.razdan@pathlock.com");
        emailSet.add("ssharotri@compunnel.com");
        emailSet.add("nikita@tspls.com");
        emailSet.add("ayushi.acumont@gmail.com");
        emailSet.add("manvi@natalieconsultants.com");
        emailSet.add("jasmitha.y@soais.com");
        emailSet.add("Vineeth@upstreamgs.com");
        emailSet.add("honey.lohani@awcsoftware.com");
        emailSet.add("nagaraju.p@avanceservices.com");
        emailSet.add("priya@trustklub.com");
        emailSet.add("mona.ujagare@ampcustech.com");
        emailSet.add("praval@aekyainc.com");
        emailSet.add("nikita@tspls.com");
        emailSet.add("deepamosur@commercecx.com");
        emailSet.add("avinash.chauhan@ascendion.com");
        emailSet.add("Ishita.Nehra@axiomsoftwaresolutions.com");
        emailSet.add("shivani.razdan@pathlock.com");
        emailSet.add("ssharotri@compunnel.com");
        emailSet.add("nikita@tspls.com");
        emailSet.add("ayushi.acumont@gmail.com");
        emailSet.add("manvi@natalieconsultants.com");
        emailSet.add("jasmitha.y@soais.com");
        emailSet.add("Vineeth@upstreamgs.com");
        emailSet.add("mahalakshmi@zweizag.com");
        emailSet.add("s.murli89@gmail.com");
        emailSet.add("Krishna@talentboon.in");
        emailSet.add("mahesh@perfectjobaccord.com");
        emailSet.add("ritu.bansode@tcs.com");
        emailSet.add("noxustech@hrexcel.in");
        emailSet.add("singht@tower-research.com");
        emailSet.add("renuwadhwa@trackingpath.com");
        emailSet.add("indumathi.m@betsol.com");
        emailSet.add("nadia.taha@dxc.com");
        emailSet.add("rajesh@dstechnologiesinc.com");
        emailSet.add("amit.p.choudhary@impetus.com");
        emailSet.add("divyani.ghadi@ril.com");
        emailSet.add("soudamini.raut@walmart.com");
        emailSet.add("Sarun.karunakaran@mastechdigital.com");
        emailSet.add("roselin@reveilletechnologies.com");
        emailSet.add("soudamini.raut@walmart.com");
        emailSet.add("rashi@huntingcube.com");
        emailSet.add("durga.p@techmahindra.com");
        emailSet.add("pagadala.madhavi@satincorp.co.in");
        emailSet.add("ahmed@burgeonits.net");
        emailSet.add("dipti.porje@ampcustech.com");
        emailSet.add("supriya.waghmare@bluethink.in");
        emailSet.add("ritu.r3@concentrix.com");
        emailSet.add("hr.veritasrm@gmail.com");
        emailSet.add("bhuvana.g@sellcraft.net");
        emailSet.add("akansha2@aliqan.com");
        emailSet.add("Bhavani@epeopletech.com");
        emailSet.add("srujanreddy@unifind.net");
        emailSet.add("aravindarlugala@gmail.com");
        emailSet.add("tej@xladvisors.co");
        emailSet.add("surya.prakash@quadranttechnologies.com");
        emailSet.add("aniket.sawant@changepond.com");
        emailSet.add("hr@adlergroup.in");
        emailSet.add("anderson@bigswordconsulting.com");
        emailSet.add("sarun.karunakaran@mastechdigital.com");
        emailSet.add("indu.r@axiomtech.in");
        emailSet.add("hr@qrghealthcity.com");
        emailSet.add("santhosh.v@neufvasi.com");
        emailSet.add("rajshekhar@uwsinc.com");
        emailSet.add("ibrahim.madha@impressico.com");
        emailSet.add("hr@elearningmind.com");
        emailSet.add("rushabh@areteventure.com");
        emailSet.add("arjunkumar@softenger.com");
        emailSet.add("pratham.mishra@quadlabs.com");
        emailSet.add("anil.singh@oasys.co.in");
        emailSet.add("arnab.saha@genpact.com");
        emailSet.add("veronica@techinnovations.in");
        emailSet.add("rk2@cubictree.com");
        emailSet.add("vishal.s@ideaminefield.com");
        emailSet.add("prabhjot@xceltrait.com");
        emailSet.add("anshumanm@ayantek.com");
        emailSet.add("hriday@cubictree.com");
        emailSet.add("prasad@lkcs.com");
        emailSet.add("shafi@teamplus.co.in");
        emailSet.add("kothapally.saikumar@syntrino.net");
        emailSet.add("mahesh.bhujbal@radiantinfo.com");
        emailSet.add("shridhar.kopparapu@skilora.com");
        emailSet.add("karthikarudra@gmail.com");
        emailSet.add("anubha@imperialsoftech.com");
        //emailSet.add("madhushree@itcsystems.com"); // mail does not exist
        emailSet.add("manju@alisonsi.com");
        emailSet.add("hr@odcaksh.com");
        emailSet.add("shaliniranjan@karyalaya.com");
        emailSet.add("hr@dakshasetu.com");
        emailSet.add("satyendra.singh@indusos.com");
        emailSet.add("shalini@knowledgelens.com");
        emailSet.add("mohit.arora@panasonic.com");
        emailSet.add("payal.tyagi@rxcatalyst.com");
        emailSet.add("nikita@valorant.com");
        emailSet.add("balakarthikeya.g@mnexponential.com");
        emailSet.add("jignesh.ghariya@mobinius.com");
        emailSet.add("aftab@convextech.com");
        emailSet.add("avinash.chauhan@ascendion.com");
        emailSet.add("Nagam2@hexaware.com");
        emailSet.add("priyanka.mahajan@thedigitalgroup.com");
        emailSet.add("shivani.razdan@pathlock.com");
        emailSet.add("sravanig@fixitytech.com");
        emailSet.add("Sakthipriya@liveconnections.in");
        emailSet.add("manisha@theglove.co.in");
        emailSet.add("nikita@tspls.com");
        emailSet.add("deepamosur@commercecx.com");
        emailSet.add("Ishita.Nehra@axiomsoftwaresolutions.com");
        emailSet.add("ssharotri@compunnel.com");
        emailSet.add("ayushi.acumont@gmail.com");
        emailSet.add("manvi@natalieconsultants.com");
        emailSet.add("jasmitha.y@soais.com");
        emailSet.add("Vineeth@upstreamgs.com");
        emailSet.add("honey.lohani@awcsoftware.com");
        emailSet.add("nagaraju.p@avanceservices.com");
        emailSet.add("priya@trustklub.com");
        emailSet.add("mona.ujagare@ampcustech.com");
        emailSet.add("praval@aekyainc.com");
        emailSet.add("nikita@tspls.com");
        emailSet.add("avinash.chauhan@ascendion.com");
        emailSet.add("Ishita.Nehra@axiomsoftwaresolutions.com");
        emailSet.add("shivani.razdan@pathlock.com");
        emailSet.add("ssharotri@compunnel.com");
        emailSet.add("nikita@tspls.com");
        emailSet.add("ayushi.acumont@gmail.com");
        emailSet.add("manvi@natalieconsultants.com");
        emailSet.add("jasmitha.y@soais.com");
        emailSet.add("Vineeth@upstreamgs.com");
        emailSet.add("honey.lohani@awcsoftware.com");
        emailSet.add("nagaraju.p@avanceservices.com");
        emailSet.add("priya@trustklub.com");
        emailSet.add("mona.ujagare@ampcustech.com");
        emailSet.add("praval@aekyainc.com");
        emailSet.add("nikita@tspls.com");
        emailSet.add("deepamosur@commercecx.com");
        emailSet.add("avinash.chauhan@ascendion.com");
        emailSet.add("Ishita.Nehra@axiomsoftwaresolutions.com");
        emailSet.add("shivani.razdan@pathlock.com");
        emailSet.add("ssharotri@compunnel.com");
        emailSet.add("nikita@tspls.com");
        emailSet.add("ayushi.acumont@gmail.com");
        emailSet.add("manvi@natalieconsultants.com");
        emailSet.add("jasmitha.y@soais.com");
        emailSet.add("Vineeth@upstreamgs.com");
        emailSet.add("mahalakshmi@zweizag.com");
        emailSet.add("s.murli89@gmail.com");
        emailSet.add("Krishna@talentboon.in");
        emailSet.add("mahesh@perfectjobaccord.com");
        emailSet.add("ritu.bansode@tcs.com");
        emailSet.add("noxustech@hrexcel.in");
        emailSet.add("singht@tower-research.com");
        emailSet.add("renuwadhwa@trackingpath.com");
        emailSet.add("indumathi.m@betsol.com");
        emailSet.add("nadia.taha@dxc.com");
    }
}
