package com.something.fishy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.something.fishy.databinding.ActivityMainBinding;

import java.math.BigInteger;
import java.util.Random;

@SuppressWarnings("unused")
public class MainActivity extends AppCompatActivity {
  static {
    System.loadLibrary("fishy");
  }

  ActivityMainBinding binding = null;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    binding.buttonn.setOnClickListener(view -> {
      Random rand = new Random();
      Toast.makeText(
          this,
          calc(
              binding.editt.getText().toString(),
              rand.nextInt(299), MainActivity.this
          ),
          Toast.LENGTH_SHORT).show();
    });
  }

  private String calc0(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("18846681827743754117695903626016774037204453128592171638568885579103176130988517184888839259731107")).toString(), pos + 64, this);
  }

  private String calc1(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("145")).toString(), 62, this);
  }

  private String calc2(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("170")).toString(), 123, this);
  }

  private String calc3(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("2")).toString(), pos + 181, this);
  }

  private String calc4(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("28")).toString(), 245, this);
  }

  private String calc5(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("14768648924452395978215825047581620770008029437332115060117377319817638142034070336511305667280449")).toString(), 67, this);
  }

  private String calc6(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("249")).toString(), 10, this);
  }

  private String calc7(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-849502460417209203587761403722232731337691060484977808632142627801435129361280922100459529868913874")).toString(), pos + 121, this);
  }

  private String calc8(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("42450395791845320068324193356549227831964482118465683640796583669541025751101124201929457460524883")).toString(), pos + 292, this);
  }

  private String calc9(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("171")).toString(), 299, this);
  }

  private String calc10(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("7")).toString(), 11, this);
  }

  private String calc11(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-304808406082448761709519241097356738516861238798416873631249327480292464886945770644218907226960255")).toString(), pos + 61, this);
  }

  private String calc12(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("210")).toString(), pos + 121, this);
  }

  private String calc13(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("213")).toString(), 194, this);
  }

  private String calc14(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("107346522620783263593862712469270276940950198526963312244640369882595017014928311058364450417750963")).toString(), pos + 3, this);
  }

  private String calc15(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("87993924572785387150028885014956857847635308947697371659947707262753942835988162954556533938119053")).toString(), 16, this);
  }

  private String calc16(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("70943964792452441986037668940660371001300041923732251584549380613452812180725155975470909064681290")).toString(), pos + 182, this);
  }

  private String calc17(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("7908341114284137056367701320366190200186303021210672496628604524847266131653860031116545215757620")).toString(), pos + 121, this);
  }

  private String calc18(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("195")).toString(), 199, this);
  }

  private String calc19(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("2857389287946721606860110818267911388760736810720783517729225108766620294364494372370830149329175")).toString(), 261, this);
  }

  private String calc20(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("3444529119932052920018930024684664437024665082159968301319329796981597602809384500213302785588555")).toString(), 21, this);
  }

  private String calc21(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("42168310444770834010646307767327573339146867857122969636607732284538557773742188779511019296278230")).toString(), 203, this);
  }

  private String calc22(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-1652353570798114968728412867575735277848117707613865368760469608850656497046882510557787669281174400")).toString(), 265, this);
  }

  private String calc23(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("34")).toString(), pos + 181, this);
  }

  private String calc24(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("37971773265514036056639728678185276598390509011939617227326695862045411043412919665408197764186979")).toString(), 266, this);
  }

  private String calc25(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("17671038873953628595267082120169363298406307512573154088693515584881317949414311689847050377273028")).toString(), pos + 1, this);
  }

  private String calc26(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("16292443113480790239940259772589926367593835006267941441698613545506044798004910431281986070931750")).toString(), 89, this);
  }

  private String calc27(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("52641748380937653478240052797738477977180812414063311432131479744024354689157186757506869077790308")).toString(), 148, this);
  }

  private String calc28(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("3")).toString(), 209, this);
  }

  private String calc29(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("106")).toString(), 270, this);
  }

  private String calc30(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("47259135189376087349491683929270283606270894727260098523254926245700613442392495760044864537953852")).toString(), pos + 62, this);
  }

  private String calc31(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("244")).toString(), 213, this);
  }

  private String calc32(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-620063099934433197052532705184191590071494293579145679072896515945755121213209318430457372431797243")).toString(), 153, this);
  }

  private String calc33(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("56")).toString(), pos + 181, this);
  }

  private String calc34(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("6308863598824166685180948363160085665520962348705022144803538016151801612055496163410986708079397")).toString(), 275, this);
  }

  private String calc35(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("16286272698366059083414413760025454635514974211468398270732532488148724387589422449699387244522875")).toString(), pos + 62, this);
  }

  private String calc36(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("234")).toString(), 40, this);
  }

  private String calc37(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("98024553838055545752347436734907039877804317110253913033889631878847530608979962970594146760168921")).toString(), 158, this);
  }

  private String calc38(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("16")).toString(), pos + 181, this);
  }

  private String calc39(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("5407075716509477299429397509549768287685023741509647120743354086153729489669490570219740568401273")).toString(), 280, this);
  }

  private String calc40(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("10")).toString(), pos + 1, this);
  }

  private String calc41(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-1553135536409365343950538325666253780237890396370574984001050731299493710917046034977342072692143120")).toString(), pos + 182, this);
  }

  private String calc42(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("124")).toString(), 285, this);
  }

  private String calc43(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("2")).toString(), 224, this);
  }

  private String calc44(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("45274963825538123220732202479749108964004296897261320997984896318975553086142398144578815804776806")).toString(), pos + 124, this);
  }

  private String calc45(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("81")).toString(), 51, this);
  }

  private String calc46(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("99385402113679331358108493077646727476904991809670569946387599938025702254850044902848596909483131")).toString(), pos + 61, this);
  }

  private String calc47(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("81")).toString(), 290, this);
  }

  private String calc48(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("196")).toString(), pos + 181, this);
  }

  private String calc49(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("78927920664259075607209065963126803697640234329284826187050112117819274041887969040910091130468789")).toString(), pos + 242, this);
  }

  private String calc50(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("39926983636962528233052277943874228772141668381291563195862059033837558658034215461855248024154831")).toString(), 112, this);
  }

  private String calc51(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("10")).toString(), pos + 63, this);
  }

  private String calc52(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("47101266867521596718467791717599888809701196366861515135447397369086336634682112267768295396638448")).toString(), 173, this);
  }

  private String calc53(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("158")).toString(), pos + 181, this);
  }

  private String calc54(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("57486497875231915600663281643127946591189309587597125719888541496393741312645277584876486612598167")).toString(), pos + 241, this);
  }

  private String calc55(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("10")).toString(), pos + 1, this);
  }

  private String calc56(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("190")).toString(), 117, this);
  }

  private String calc57(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("97369290894998088744739522633692400276859749518614538078815414703096163368694037924190043570110359")).toString(), 178, this);
  }

  private String calc58(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("223")).toString(), 239, this);
  }

  private String calc59(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("339684124813164677409663550455803534976226516258325126103985240190252702412200556193851780205142141")).toString(), 1, this);
  }

  private String calc60(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("7318701862961009362940495579174886148690070698869433851994648166878875607989935894134573298798221")).toString(), pos + 183, this);
  }

  private String calc61(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("5")).toString(), 122, this);
  }

  private String calc62(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("145")).toString(), pos + 121, this);
  }

  private String calc63(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("233")).toString(), 244, this);
  }

  private String calc64(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("106316835519490288697888666071201944657233717175584395765900862591508310972105745230769196945603302")).toString(), pos + -59, this);
  }

  private String calc65(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("10071887985642637193506131208232152854765978585400657487968759492577108421809187691112519805298127")).toString(), pos + 1, this);
  }

  private String calc66(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("91213577996723234481340782853475744802843751313799584623346347080636524859986617605991695454290260")).toString(), pos + 5, this);
  }

  private String calc67(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("69427809879995527081290711627524483432591196929042691013914253729117660396055712866544334834792343")).toString(), 188, this);
  }

  private String calc68(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("51")).toString(), 249, this);
  }

  private String calc69(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("15730779278823072537370861008452248581275856199684970979119683272438980083552615531917268362838116")).toString(), 15, this);
  }

  private String calc70(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("7818321089121585096311309968091536969372289135257420175220411323233521209524443458406223218472902")).toString(), pos + 183, this);
  }

  private String calc71(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("3952125086744809981246785389443825379693092877244528264563674770032586785266029829539640232246011")).toString(), pos + 61, this);
  }

  private String calc72(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("7")).toString(), 193, this);
  }

  private String calc73(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("153")).toString(), pos + 181, this);
  }

  private String calc74(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("80")).toString(), pos + 3, this);
  }

  private String calc75(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("42228777310630980247048579972956146316454801988646265042442758241182278945576898515519800121336118")).toString(), 258, this);
  }

  private String calc76(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("75")).toString(), 137, this);
  }

  private String calc77(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("140082849862566174735555775969090728524606147515632456681627918151573583584492464958649774089049040")).toString(), pos + 5, this);
  }

  private String calc78(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("19")).toString(), pos + 181, this);
  }

  private String calc79(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("65898723468358596425111420999463908905073240206792584473276337988915965904652149758399044038067298")).toString(), 20, this);
  }

  private String calc80(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("9640798777531786618491046588382392611493066346224559186720996174597183266395796431918382090889767")).toString(), 81, this);
  }

  private String calc81(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("52903853811057458034783094731172411608077727964756963050510972409979951527449555548715303602886076")).toString(), 142, this);
  }

  private String calc82(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("2")).toString(), pos + 2, this);
  }

  private String calc83(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("5")).toString(), 264, this);
  }

  private String calc84(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-89379069284824182409854527519436892153892594896300127391252055317505105735414637824543026790023368")).toString(), 87, this);
  }

  private String calc85(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("68780807511811684372633979559090454738133028133926056790942444561904716140574583794738960497209412")).toString(), 86, this);
  }

  private String calc86(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("106327686279889017921596102061803712757742751428877073369693412586239234580405849806896413508052880")).toString(), pos + 61, this);
  }

  private String calc87(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("2")).toString(), pos + 121, this);
  }

  private String calc88(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("101")).toString(), pos + 181, this);
  }

  private String calc89(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("73816452134218668816910327666900667560019881611879007689750051181797846367817329948534151953686488")).toString(), 30, this);
  }

  private String calc90(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("88525627039160571706842335772241979043913941750315561096272162264362646417170021502594435422461864")).toString(), pos + 1, this);
  }

  private String calc91(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("104757523890638400144279986600674147487698145899226498665578189142144265585586730146861531944955900")).toString(), pos + 61, this);
  }

  private String calc92(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("49772847609741420065362423852847981425954401657174193608071696971611487727815878730150079404504396")).toString(), pos + 2, this);
  }

  private String calc93(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("76")).toString(), pos + 181, this);
  }

  private String calc94(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("96848267032304039905448502410887565751820665247876416723932800066872164261341535976317547004047806")).toString(), pos + -59, this);
  }

  private String calc95(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("32445589369097989988663372741932026825624633263960886255849421132514832329575014719140985874307128")).toString(), 96, this);
  }

  private String calc96(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("4")).toString(), pos + 61, this);
  }

  private String calc97(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("14980935723811528251428558338730992320072463914967120476219439774641938218769209210467597347616983")).toString(), pos + 121, this);
  }

  private String calc98(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("58")).toString(), pos + 181, this);
  }

  private String calc99(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("68326917495868338931930879215996621431332335974388155954300708648540888321472626847235090830351146")).toString(), pos + 3, this);
  }

  private String calc100(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("89276614921411072008047868341670359461716503789083195986754112934464482270681519399762967374809707")).toString(), pos + 62, this);
  }

  private String calc101(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("135")).toString(), 164, this);
  }

  private String calc102(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("94089383465991654500049564555226213993304464262174114950508481613923092401112440317122569767795430")).toString(), pos + -56, this);
  }

  private String calc103(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("248")).toString(), 284, this);
  }

  private String calc104(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("81")).toString(), 45, this);
  }

  private String calc105(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("146")).toString(), pos + 1, this);
  }

  private String calc106(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("146")).toString(), pos + 61, this);
  }

  private String calc107(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("50620847299065435425499237144303219800429529976807281599626974600144869838510434222042075370220776")).toString(), 228, this);
  }

  private String calc108(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("116")).toString(), 289, this);
  }

  private String calc109(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("83941982345151455602113818021500466447043018922745760899931680826271183175492129448090620721805240")).toString(), 50, this);
  }

  private String calc110(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("74038075697623571010543166700939165710617406295247282028127887791680735621692201721140795393363611")).toString(), 111, this);
  }

  private String calc111(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("76249223104991782531604821149986559557742010421597579729920467278925237387189760478858313064390623")).toString(), pos + 61, this);
  }

  private String calc112(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("54618668777928645727596136195048152088024756809677014407356898366160545385143880446245068019327730")).toString(), pos + 121, this);
  }

  private String calc113(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("3")).toString(), 294, this);
  }

  private String calc114(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-1692100511397145781170088542662214724797938898143305663771844424155004958623275220924706472683922070")).toString(), pos + -59, this);
  }

  private String calc115(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("79395897087230474114234135158915231371996971991555291821472963545312257226173679925278693284404585")).toString(), 177, this);
  }

  private String calc116(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("8")).toString(), pos + 4, this);
  }

  private String calc117(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("190")).toString(), 238, this);
  }

  private String calc118(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("204371373370997392728245146936443967625360717235971279213721466907199546013828529373652048890322469")).toString(), pos + 132, this);
  }

  private String calc119(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("12")).toString(), 61, this);
  }

  private String calc120(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-1909534754731534353970372862718317135817046195505187487869653918529834950577645036159499391572945928")).toString(), 182, this);
  }

  private String calc121(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("35633744726153120496644054370607256078236597537102985774864313060509874582830152772979918117979752")).toString(), 8, this);
  }

  private String calc122(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-649074186532604871026883311551832923663028416559845854319662443481604800957852683425475535094043380")).toString(), 127, this);
  }

  private String calc123(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("14976683344058192657818968402853972223071484873579655085917660182771661881034925832629998787961572")).toString(), 4, this);
  }

  private String calc124(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("29857067293746581058619686015482074587435674608403643721274329301243355942797453638184093449502058")).toString(), pos + -59, this);
  }

  private String calc125(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("2")).toString(), pos + 1, this);
  }

  private String calc126(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("222")).toString(), 187, this);
  }

  private String calc127(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("5")).toString(), 248, this);
  }

  private String calc128(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("9")).toString(), pos + -119, this);
  }

  private String calc129(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("72")).toString(), pos + -59, this);
  }

  private String calc130(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("235")).toString(), pos + 1, this);
  }

  private String calc131(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("235")).toString(), pos + 61, this);
  }

  private String calc132(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("45783519821751670273139562516126012721303924188169710071963453315803419918556030176223657724328451")).toString(), pos + 2, this);
  }

  private String calc133(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("85966858207748282446540282203350471548282778952419604170572354876584845609519182198741855601763417")).toString(), 255, this);
  }

  private String calc134(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("90061429289751204836505471267240218229925115744110948949472902054974518026472307207167818073055966")).toString(), 75, this);
  }

  private String calc135(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("8")).toString(), pos + 1, this);
  }

  private String calc136(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-1126561165793093931463110836068898550965759677153561652874416302487914675864464870948010547623683256")).toString(), 197, this);
  }

  private String calc137(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("2")).toString(), 139, this);
  }

  private String calc138(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("33268191635811673882770764773536657396990800068975091611285260293537317719334098103171161432345859")).toString(), pos + 122, this);
  }

  private String calc139(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-153329344986218091117316104409247154797419474976091594696503140103533847416838176020242591372728592")).toString(), pos + 124, this);
  }

  private String calc140(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("176730473695331843035267653590281497186188545570180333293078081932766490372097407096700651505272090")).toString(), pos + 1, this);
  }

  private String calc141(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("86")).toString(), 202, this);
  }

  private String calc142(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("4938302259913032242020889619209123319491932039977258289309821210325608608991375405254549960722141")).toString(), 85, this);
  }

  private String calc143(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("73177659060743331497580240612949313496798274841958646711780831061302953744565906702672051547262202")).toString(), 24, this);
  }

  private String calc144(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("8790514040066467741240295335350993970917693531711651676533298978283379357207839941886633995362518")).toString(), 149, this);
  }

  private String calc145(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("191176087269377919858937741824548799913711396960862506971568924971085374268905521744103440081070878")).toString(), pos + 1, this);
  }

  private String calc146(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("63")).toString(), 207, this);
  }

  private String calc147(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("68191738711621763297653172545738919207132178976792787815446176504649682670502444908975383072773173")).toString(), pos + 121, this);
  }

  private String calc148(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("20098104219423767004777799498613685920934346376801937032774845133129522390100676138015964933376823")).toString(), 276, this);
  }

  private String calc149(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("34")).toString(), 273, this);
  }

  private String calc150(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("3")).toString(), pos + 1, this);
  }

  private String calc151(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("133")).toString(), 212, this);
  }

  private String calc152(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("96844240229795072598790410290079698817117860132191982887760148051079013731366923843536647008486047")).toString(), pos + 126, this);
  }

  private String calc153(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("3")).toString(), pos + -119, this);
  }

  private String calc154(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("141054433590527780235955120137387118412716431091117604814821744645700569539109783591955457643776133")).toString(), pos + -59, this);
  }

  private String calc155(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("106813809584652977768169599179836393668393612975071595830571937872419761691403452267007126095517905")).toString(), pos + 1, this);
  }

  private String calc156(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("172")).toString(), 217, this);
  }

  private String calc157(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("4")).toString(), pos + 2, this);
  }

  private String calc158(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("3985024649985234578163181653269310669120333815638660399922726226807774394693562362164933199556339")).toString(), pos + -119, this);
  }

  private String calc159(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("135")).toString(), pos + -58, this);
  }

  private String calc160(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("163624430908331448426249978692044502094104867156106223183786877576699088254472915801866472614917245")).toString(), 161, this);
  }

  private String calc161(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("2")).toString(), 222, this);
  }

  private String calc162(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("35073112330891560795702458996176009885068273640851457365028875202796706609096948866043583456669644")).toString(), 283, this);
  }

  private String calc163(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("75279589748079754547598288525032071574895818404754626275540942411415001300919048627922866416926475")).toString(), pos + -119, this);
  }

  private String calc164(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("184532767961583047352672466989547924025127446683444999698174820517420396068898424347049349882232959")).toString(), 105, this);
  }

  private String calc165(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("137")).toString(), pos + 1, this);
  }

  private String calc166(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("601251288056313289116552786121776005528597561029463131979369133335909768961304752066740128052372188")).toString(), pos + 61, this);
  }

  private String calc167(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("1937136307658149782455693999480857761406105427559571833985582763073622721812879592441027683437611")).toString(), 288, this);
  }

  private String calc168(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("29797449058972638764729381630135387361972398013941640539904952925788135160086889274978899810628066")).toString(), pos + -119, this);
  }

  private String calc169(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("15010703356796987885214573265027147816327978994024755653271231776741975296607032620560706099978113")).toString(), pos + -59, this);
  }

  private String calc170(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("56")).toString(), 171, this);
  }

  private String calc171(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("1123225945590635317668090928347412296735693109025333448805763983943194265780917621886189217532564")).toString(), pos + 61, this);
  }

  private String calc172(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("52765963390816281467137250937722391354646367186600375321378002742012216332895982983095263885983762")).toString(), pos + 2, this);
  }

  private String calc173(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("32484909356849907358636795504225367396324209224208402780455080680161670407954854607779102568754585")).toString(), 54, this);
  }

  private String calc174(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("15124543743300338601309715220430903013824889180309817576003979937222860139711511070510028428796849")).toString(), 115, this);
  }

  private String calc175(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("213")).toString(), pos + 1, this);
  }

  private String calc176(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("219896990926281491535394265696273931084257301667676653194284056388096363269972557714413037366753171")).toString(), pos + 61, this);
  }

  private String calc177(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("17954127640731398264531311185622598384630907129545185925496132108355206489922609428887136540797981")).toString(), 298, this);
  }

  private String calc178(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("9052798208634818805290322917317490646251808519316220228945099766229514672376490893814383219984075")).toString(), 0, this);
  }

  private String calc179(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("76595066945442719396434454462162329504572881961609746765358896684584392991724551922652540136243176")).toString(), pos + -58, this);
  }

  private String calc180(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("10")).toString(), 181, this);
  }

  private String calc181(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-345095565501498728689811144900788326407838734708242717357688147925406141995858163032457744948024600")).toString(), pos + 61, this);
  }

  private String calc182(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("8")).toString(), pos + -179, this);
  }

  private String calc183(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("249")).toString(), pos + -177, this);
  }

  private String calc184(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-231214159941373381565154126937693020233156185427801123937507226758786212095141088445167626564951742")).toString(), pos + -59, this);
  }

  private String calc185(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("6036484293797524118214696477123119962732168204788163459286669969312814709765272252904636681889927242")).toString(), 186, this);
  }

  private String calc186(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("233")).toString(), pos + 61, this);
  }

  private String calc187(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("222")).toString(), 189, this);
  }

  private String calc188(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("5532029665723885485065237865500741881814450644508100494365763195056767207649457883682043640191286")).toString(), pos + -119, this);
  }

  private String calc189(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("1257040049907781621582717791700847545868173147815487772953386620686399728365870605875412713431685")).toString(), pos + -59, this);
  }

  private String calc190(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-99559936211656516859789160624562880525597011292013544091875604068863437809355001516455630838733116")).toString(), 191, this);
  }

  private String calc191(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("2")).toString(), 252, this);
  }

  private String calc192(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("198192980434250571647164247802283146693350229642060730828676269930440042083783759606435199347354246")).toString(), pos + -179, this);
  }

  private String calc193(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("80")).toString(), 74, this);
  }

  private String calc194(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("213")).toString(), pos + -59, this);
  }

  private String calc195(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("177")).toString(), pos + 1, this);
  }

  private String calc196(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("21596154178232578532681590940863960492241829909789014602551187894074122350023954550688315165312572")).toString(), 257, this);
  }

  private String calc197(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("8")).toString(), pos + -179, this);
  }

  private String calc198(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("55344230674602940104679386759719891261903866157213603066499765986886926789020152986425088068530400")).toString(), 79, this);
  }

  private String calc199(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("195")).toString(), 140, this);
  }

  private String calc200(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("161")).toString(), 201, this);
  }

  private String calc201(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("5")).toString(), 262, this);
  }

  private String calc202(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("86")).toString(), pos + -179, this);
  }

  private String calc203(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("40301381730846142455780828018848894174922348089193590675231644641079753445345696616818765250178668")).toString(), pos + -178, this);
  }

  private String calc204(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("34")).toString(), pos + -59, this);
  }

  private String calc205(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("175")).toString(), pos + 1, this);
  }

  private String calc206(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("170316816114574191516556300684647398564221554477197791265098888227441459134284173605611778110316300")).toString(), pos + 61, this);
  }

  private String calc207(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("63")).toString(), 28, this);
  }

  private String calc208(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("244")).toString(), 31, this);
  }

  private String calc209(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-189502634513289937022727028926780650510985129174793128420550092292210834848685495925109694703828226")).toString(), pos + -59, this);
  }

  private String calc210(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("112")).toString(), 211, this);
  }

  private String calc211(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("112")).toString(), 272, this);
  }

  private String calc212(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("133")).toString(), 33, this);
  }

  private String calc213(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("234")).toString(), pos + -177, this);
  }

  private String calc214(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("56")).toString(), 155, this);
  }

  private String calc215(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("136")).toString(), pos + 1, this);
  }

  private String calc216(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("136")).toString(), pos + 61, this);
  }

  private String calc217(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("172")).toString(), pos + -179, this);
  }

  private String calc218(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("81562675968698883532752822060631240528352853617958343112651020532784969071664439683674044035746369")).toString(), 99, this);
  }

  private String calc219(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("16")).toString(), 160, this);
  }

  private String calc220(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("7")).toString(), pos + 1, this);
  }

  private String calc221(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-262988674002682519932068418152079291663258684138324514811943108188859236693265819678092410434959868")).toString(), pos + 61, this);
  }

  private String calc222(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-94692883416079562164645710088975795510838591279513243247551385160739752250560460733271109170713010")).toString(), pos + -179, this);
  }

  private String calc223(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("10")).toString(), 104, this);
  }

  private String calc224(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("137")).toString(), 165, this);
  }

  private String calc225(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("198")).toString(), pos + 1, this);
  }

  private String calc226(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("198")).toString(), 287, this);
  }

  private String calc227(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("196")).toString(), 48, this);
  }

  private String calc228(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("92708197549662180438572746249117727774055183980626557469361210906711236930973269110695000289940676")).toString(), pos + -119, this);
  }

  private String calc229(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("56")).toString(), 170, this);
  }

  private String calc230(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("178")).toString(), 231, this);
  }

  private String calc231(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("178")).toString(), pos + 61, this);
  }

  private String calc232(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("158")).toString(), 53, this);
  }

  private String calc233(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("86526243020165166739337118103969069780005878549970651504138921042675167662798014710057907334283628")).toString(), pos + -173, this);
  }

  private String calc234(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("213")).toString(), pos + -59, this);
  }

  private String calc235(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("3")).toString(), 236, this);
  }

  private String calc236(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("172")).toString(), 297, this);
  }

  private String calc237(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("116538226509575053804336636723003004515335595102706596626712982595775262022531378826606099169382400")).toString(), 58, this);
  }

  private String calc238(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("12")).toString(), pos + -119, this);
  }

  private String calc239(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("223")).toString(), pos + -59, this);
  }

  private String calc240(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("77")).toString(), 241, this);
  }

  private String calc241(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("170")).toString(), pos + -239, this);
  }

  private String calc242(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("10")).toString(), pos + -179, this);
  }

  private String calc243(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("26839067568104998210251927491572426267627083462296182521504645982709731224951808856769421163661610")).toString(), 124, this);
  }

  private String calc244(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("6036484293797524118214696477123119962732168204788163459286669969312814709765272252904636681889927242")).toString(), pos + -59, this);
  }

  private String calc245(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("28")).toString(), 246, this);
  }

  private String calc246(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("9")).toString(), pos + -239, this);
  }

  private String calc247(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("51")).toString(), pos + -179, this);
  }

  private String calc248(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("72")).toString(), 129, this);
  }

  private String calc249(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("2")).toString(), 190, this);
  }

  private String calc250(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("77")).toString(), pos + -10, this);
  }

  private String calc251(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("210")).toString(), pos + -239, this);
  }

  private String calc252(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("153")).toString(), pos + -179, this);
  }

  private String calc253(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("75")).toString(), 76, this);
  }

  private String calc254(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("177")).toString(), 195, this);
  }

  private String calc255(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("212")).toString(), 256, this);
  }

  private String calc256(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("212")).toString(), 19, this);
  }

  private String calc257(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("19")).toString(), pos + -179, this);
  }

  private String calc258(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("48570931981170300409456123085158251994071895149694941717957841650541581362130408971711761738110990")).toString(), pos + -178, this);
  }

  private String calc259(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("161")).toString(), 200, this);
  }

  private String calc260(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("37410762375370866680039976653448042296793949196909923057953014257398582749095362572179964964370355")).toString(), 143, this);
  }

  private String calc261(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("10")).toString(), pos + -239, this);
  }

  private String calc262(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-660198183862505341511594879946865014928617904887447002688692224594007370769805191573090104219705415")).toString(), pos + -179, this);
  }

  private String calc263(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("2")).toString(), 144, this);
  }

  private String calc264(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("175")).toString(), pos + -59, this);
  }

  private String calc265(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("10")).toString(), 29, this);
  }

  private String calc266(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("23430016315541318261945731461077153720966573969616285158282693046314506111928175458959048371512414")).toString(), 27, this);
  }

  private String calc267(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("101")).toString(), 88, this);
  }

  private String calc268(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("3683752049282886645385432029904285303123667466611114094276997096224226395591544727455249044861679")).toString(), 90, this);
  }

  private String calc269(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("296112992226422000356275579050499352663117351471241199740060633991660037064754658621864664015530157")).toString(), 210, this);
  }

  private String calc270(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("106")).toString(), 271, this);
  }

  private String calc271(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.multiply(new BigInteger("3")).toString(), 32, this);
  }

  private String calc272(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("76")).toString(), pos + -179, this);
  }

  private String calc273(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("34")).toString(), pos + -119, this);
  }

  private String calc274(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("88976132919819010983353319952082975093953955371479624065623742468771068933767410244013102515529821")).toString(), 215, this);
  }

  private String calc275(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("124")).toString(), pos + -233, this);
  }

  private String calc276(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("34128066604326124331965803847344401336642830471915312102098274093038969710919427175309808838864895")).toString(), pos + -239, this);
  }

  private String calc277(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("99383753916674992958446106254526919665066310160743677995007109260382304293773671121461207165487149")).toString(), pos + -179, this);
  }

  private String calc278(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("22884354952696232201029734725053092812039374216790951143104991335366055381805373104312557299356446")).toString(), pos + -178, this);
  }

  private String calc279(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("58")).toString(), pos + -59, this);
  }

  private String calc280(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("6672208811115576616688857243774286006696094495401443807260476190557239949874755065735026934854702")).toString(), 281, this);
  }

  private String calc281(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("94343975004664939459647383320508028123767150049148578236836547980271017105357377081080518423903474")).toString(), pos + -118, this);
  }

  private String calc282(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("7")).toString(), pos + -179, this);
  }

  private String calc283(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.divide(new BigInteger("24809212552352931239055977205039952697511889307793871973075266786529471114738079736086061689295656")).toString(), pos + -114, this);
  }

  private String calc284(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("248")).toString(), pos + -59, this);
  }

  private String calc285(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("121673778552345443351474757425441015750817226644706969402782131290518007975837258173795913207732644")).toString(), 286, this);
  }

  private String calc286(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("81")).toString(), pos + -239, this);
  }

  private String calc287(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("204969622457779499442027465754478289496112813802029557271859544256763290664923964930962042700306623")).toString(), 108, this);
  }

  private String calc288(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("111")).toString(), pos + 5, this);
  }

  private String calc289(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("116")).toString(), pos + -59, this);
  }

  private String calc290(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("198")).toString(), 296, this);
  }

  private String calc291(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("58011293969735045549499083866553758833182508959349683190745491006252006620623507416927891552803083")).toString(), pos + -239, this);
  }

  private String calc292(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.subtract(new BigInteger("58938563511984916402374232162534901569020430979809811305987854794547653708894569350546858211154934")).toString(), 113, this);
  }

  private String calc293(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("111")).toString(), pos + -177, this);
  }

  private String calc294(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.add(new BigInteger("-246012199660056665175476740429056665416380096011674950264737732460651556864867132090288909379516199")).toString(), 235, this);
  }

  private String calc295(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("70759962770835493466364333024431310037489511623663146374630251414915287216371826864889648865299878")).toString(), 57, this);
  }

  private String calc296(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("198")).toString(), pos + -237, this);
  }

  private String calc297(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("172")).toString(), 118, this);
  }

  private String calc298(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("96250678013859121166456402288629597169223991724849972640628753871175000618092852826974023683378275")).toString(), pos + -119, this);
  }

  private String calc299(String input, int pos) {
    BigInteger val = new BigInteger(input);
    return calc(val.xor(new BigInteger("171")).toString(), pos + 1, this);
  }

  private native String calc(String input, int pos, Context context);
}