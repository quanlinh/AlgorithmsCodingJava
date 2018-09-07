import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseWordsTest {
    @Test
    void testSimple() {
        ReverseWords reverseWords = new ReverseWords();
        assertEquals(reverseWords.reverseWords("the sky is blue"), "blue is sky the");
        assertEquals(reverseWords.reverseWords(" 1"), "1");
        assertEquals(reverseWords.reverseWords("       1            "), "1");
        assertEquals(reverseWords.reverseWords("\"o jvi?pofznq ' jc?g,danm?dnb,mbzlny edgoaxr rqnlfkwilvsi ztien fgbz!nbk vmrjizqoe.cfm!cvre zzffearumnxze.f. cw!o.getu?fzpw,vfqpzeb bdxk.xa.clfmns b!n?t.dvlvj tgktrz ebykqha?sybph'pcrns ?gu,gxdc!yyl,tlqjn'jjuuvp i!qhdi' ?unmspyk!xaycl?exn'bin\n" +
                "t,xxdiucv tjgpon,xwdmlppcqw py?ew nyvjbhushe!oansz,enqs crpzea'o w!zu.txfuog.t'kxvhvxq? ktbduc.ta.tfvtyeuonvi.ak kr trtbifswyn.so hpkrykropdibhcn?'' ,zxzt.wrxz.dec!vllz veaw'jdsfaw,fau!ammcnos \n" +
                "qwetdkthrnqqjagcd'csje dafnasfntavecrnp nrk tdixikqzkqnudzaq'?r 'hjixzusd!kb edceuiks.br g. .d,ohdxequ.qsmfrqborqbb mvsjakvqqmfmcezlfje tqkcldmmwwhfckxiva ypj,yqtaxnzein.fprh tpfsdudapg?p h!umupiojfacz!. srqk e'sv!isrgebjk.n,ymaochaqh .s?zfvzabcthlheyee?lo?ljg uhwtvy.uemmm?j .vrlivecfvxqokn?\n" +
                "kyvquvconkk 'qtngpv?.yoxrfvelcd?'q zbdj!y!!xsvbvyt vipwd',? lqaad!?z!'wmn.nu uzhgc,ccdv!si.xgzvbga lbvf? cdjtnjbnsrtvjtba py,xllvqtdhe?vkeb!qg ?sc.bnjtwbhuvjwaz\n" +
                "eqy,ydprosyxrqk'!jh'lo\""), "\"eqy,ydprosyxrqk'!jh'lo ?sc.bnjtwbhuvjwaz, py,xllvqtdhe?vkeb!qg cdjtnjbnsrtvjtba lbvf? uzhgc,ccdv!si.xgzvbga lqaad!?z!'wmn.nu vipwd',? zbdj!y!!xsvbvyt 'qtngpv?.yoxrfvelcd?'q kyvquvconkk .vrlivecfvxqokn?, uhwtvy.uemmm?j .s?zfvzabcthlheyee?lo?ljg e'sv!isrgebjk.n,ymaochaqh srqk h!umupiojfacz!. tpfsdudapg?p ypj,yqtaxnzein.fprh tqkcldmmwwhfckxiva mvsjakvqqmfmcezlfje .d,ohdxequ.qsmfrqborqbb g. edceuiks.br 'hjixzusd!kb tdixikqzkqnudzaq'?r nrk dafnasfntavecrnp qwetdkthrnqqjagcd'csje , veaw'jdsfaw,fau!ammcnos ,zxzt.wrxz.dec!vllz hpkrykropdibhcn?'' trtbifswyn.so kr ktbduc.ta.tfvtyeuonvi.ak w!zu.txfuog.t'kxvhvxq? crpzea'o nyvjbhushe!oansz,enqs py?ew tjgpon,xwdmlppcqw t,xxdiucv ?unmspyk!xaycl?exn'bin, i!qhdi' ?gu,gxdc!yyl,tlqjn'jjuuvp ebykqha?sybph'pcrns tgktrz b!n?t.dvlvj bdxk.xa.clfmns cw!o.getu?fzpw,vfqpzeb zzffearumnxze.f. vmrjizqoe.cfm!cvre fgbz!nbk ztien rqnlfkwilvsi edgoaxr jc?g,danm?dnb,mbzlny ' jvi?pofznq o\"");
    }

}