/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asset.manajemen.asset.manajemen.controller;

import asset.manajemen.asset.manajemen.iService.DivisiIService;
import asset.manajemen.asset.manajemen.iService.InventoriIService;
import asset.manajemen.asset.manajemen.iService.RekapInventoriDeptIService;
import asset.manajemen.asset.manajemen.iService.RoleIService;
import asset.manajemen.asset.manajemen.iServiceImplement.AksesServiceImp;
import asset.manajemen.asset.manajemen.iServiceImplement.DeptServiceImp;
import asset.manajemen.asset.manajemen.iServiceImplement.DivisiServiceImp;
import asset.manajemen.asset.manajemen.iServiceImplement.InventoriServiceImp;
import asset.manajemen.asset.manajemen.iServiceImplement.RekapInventoriDeptServiceImp;
import asset.manajemen.asset.manajemen.iServiceImplement.RoleServiceImp;
import asset.manajemen.asset.manajemen.model.Departemen;
import asset.manajemen.asset.manajemen.model.Divisi;
import asset.manajemen.asset.manajemen.model.Inventori;
import asset.manajemen.asset.manajemen.model.RekapInventoriDept;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author RRAAAA
 */
@Controller
public class MainController {

    @Autowired
    public AksesServiceImp aksesServiceImp;
    @Autowired
    public DeptServiceImp deptServiceImp;
    @Autowired
    public DivisiServiceImp divisiServiceImp;
    @Autowired
    public InventoriServiceImp inventoriServiceImp;
    @Autowired
    public RekapInventoriDeptServiceImp rekapInventoriDeptServiceImp;
    @Autowired
    public RoleServiceImp roleServiceImp;
    @Autowired
    private JavaMailSender javaMailSender;
    
//    menu departemen
    @GetMapping("/de/delete/{id}")
    public String deleteDept(@PathVariable(value = "id") int id) {
        deptServiceImp.deleteDept(id);
        return "redirect:/de/menudept";
    }

    @GetMapping("/de/menudept")
    public String dept(Model model) {
        model.addAttribute("dept", deptServiceImp.findAllAkses());
        model.addAttribute("divisi", divisiServiceImp.findAllDivisi());
        return "menuDept";
    }

    @PostMapping("/de/savedept")
    public String saveDept(@RequestParam(value = "deptNama") String nama, @RequestParam(value = "divisi") Integer divisi, @RequestParam(value = "deptId") Integer id) {
        Departemen departemen = new Departemen();
        if ("null".equals(id)) {
            departemen = new Departemen(nama, new Divisi(divisi));
        } else {
            departemen = new Departemen(id, nama, new Divisi(divisi));
        }
        deptServiceImp.saveDept(departemen);
        return "redirect:/de/menudept";
    }
    
    @GetMapping("/de/rekapdept")
    public String rekapdept(Model model) {
        model.addAttribute("rekapdept", rekapInventoriDeptServiceImp.findAllRekap());
        model.addAttribute("deptAll", deptServiceImp.findAllAkses());
//        model.addAttribute("rekapFind", rekapInventoriDeptServiceImp.findById(deptId);
        return "rekapDept";
    }

    @GetMapping("/de/findByDept/{deptId}")
    public String findByDept(@PathVariable(value = "deptId") Integer deptId, Model model){
//        model.addAttribute("findRekap", rekapInventoriDeptServiceImp.findById(deptId));
        model.addAttribute("findDept", deptServiceImp.findById(deptId).get());
        model.addAttribute("rekapAll", rekapInventoriDeptServiceImp.findAllRekap());
        return "detail_item";
    }
    
    
    @PostMapping("/de/stokpakai")
    public String stokpakai(
            @RequestParam(value = "rId") Integer id,
            @RequestParam(value = "rIdDept") Departemen deptId,
            @RequestParam(value = "rIdInven") Inventori invenId,
            @RequestParam(value = "rJumKel") int jumKel,
            @RequestParam(value = "rJumDeptMasuk") int rJumDeptMasuk,
            @RequestParam(value = "rJumDeptKeluar") int rJumDeptKeluar,
            @RequestParam(value = "rKet") String ket,
            @RequestParam(value = "rStat") int stat,
            @RequestParam(value = "rTglMasuk") String tglMasuk,
            @RequestParam(value = "stokTerpakai") int jumDeptKel) {
            rJumDeptMasuk = jumKel - jumDeptKel;
            rJumDeptKeluar = rJumDeptKeluar + jumDeptKel;
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = formatter.parse(tglMasuk);
            } catch (ParseException e) {
            }
            RekapInventoriDept rid = new RekapInventoriDept();
            rid = new RekapInventoriDept(id, jumKel, rJumDeptMasuk, jumDeptKel, ket, stat, date, new Date(), deptId, invenId);
            rekapInventoriDeptServiceImp.saveRekap(rid);
            return "redirect:/de/rekapdept";
    }
    
    @GetMapping("/de/laporandept")
    public String laporandept() {
        return "menuLaporanDept";
    }
    
     @GetMapping("/de/laporandeptview")
    public String laporandeptview(Model model) {
        model.addAttribute("rekapdept", rekapInventoriDeptServiceImp.findAllRekap());
        return "menuLaporanDeptView";
    }
    
    @GetMapping("/de/laporandeptview_i")
    public String laporandeptinvenview(Model model) {
        model.addAttribute("inven", inventoriServiceImp.findAllInventori());
        return "menuLaporanDeptView_I";
    }
    
    @GetMapping("/de/laporandeptprint")
    public String laporandeptprint(Model model) {
        model.addAttribute("rekapdept", rekapInventoriDeptServiceImp.findAllRekap());
        return "menuLaporanDeptPrint";
    }
    
    @GetMapping("/de/laporandeptprint_i")
    public String laporandeptinvenprint(Model model) {
        model.addAttribute("inven", inventoriServiceImp.findAllInventori());
        return "menuLaporanDeptPrint_I";
    }

    @GetMapping("/de/utamadept")
    public String utamadept() {
        return "menuUtamaDept";
    }
//    menu departemen

//    menu Inventori
    @GetMapping("/in/menuinven")
    public String inven(Model model) {
        model.addAttribute("inven", inventoriServiceImp.findAllInventori());
        return "menuInven";
    }

    @PostMapping("/in/saveinven")
    public String saveInven(
            @RequestParam(value = "namaBarang") String namaBarang,
            @RequestParam(value = "tglInput") String tglInput,
            @RequestParam(value = "invenId") Integer id,
            @RequestParam(value = "tglUpdate") String tglUpdate,
            @RequestParam(value = "jumlahMasuk") Integer jumlahMasuk,
            @RequestParam(value = "jumlahKeluar") Integer jumlahKeluar
    ) {
        Inventori inventori = new Inventori();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date dateUp = null;
        try {
            date = formatter.parse(tglInput);
            dateUp = formatter.parse(tglUpdate);
        } catch (ParseException e) {
        }
        if (!"".equals(tglUpdate)) {
            inventori = new Inventori(id, namaBarang, date, dateUp, jumlahMasuk, jumlahKeluar);
        } else {
            inventori = new Inventori(id, namaBarang, date, date, 0, 0);
        }
        inventoriServiceImp.saveInven(inventori);
        return "redirect:/in/menuinven";
    }

    @GetMapping("/in/deleteinven/{id}")
    public String deleteInven(@PathVariable(value = "id") int id) {
        inventoriServiceImp.deleteInven(id);
        return "redirect:/in/menuinven";
    }

//    menu Inventori
//    menu Rekap Inventori\
    
    @GetMapping("/in/utamainven")
    public String utamainven(){
        return "menuUtamaInven";
    }
    
    @GetMapping("/in/rekapinven")
    public String rekapinven(Model model) {
        model.addAttribute("inven", inventoriServiceImp.findAllInventori());
        model.addAttribute("dept", deptServiceImp.findAllAkses());
        return "menuRekapStokInventori";
    }

    @PostMapping("/in/kirimrekapinven")
    public String kirimRekapInven(
            @RequestParam(value = "invenId") Integer invenId,
            @RequestParam(value = "invenNama") String invenNama,
            @RequestParam(value = "invenTglInp") String invenInp,
            @RequestParam(value = "invenJumMasuk") int invenJumMasuk,
            @RequestParam(value = "invenJumKeluar") int invenJumKeluar,
            @RequestParam(value = "tglKirim") String tglUpdate,
            @RequestParam(value = "itemKeluar") int itemKeluar,
            @RequestParam(value = "dept") Departemen deptId,
            @RequestParam(value = "keterangan") String keterangan
    ) {
        int jumKel = invenJumKeluar + itemKeluar;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date dateUp = null;
        try {
            date = formatter.parse(invenInp);
            dateUp = formatter.parse(tglUpdate);
        } catch (ParseException e) {
        }
        Inventori inventori = new Inventori();
        inventori = new Inventori(invenId, invenNama, date, dateUp, invenJumMasuk, jumKel);
        inventoriServiceImp.saveInven(inventori);
        RekapInventoriDept rid = new RekapInventoriDept(deptId, new Inventori(invenId), dateUp, dateUp, itemKeluar, itemKeluar, keterangan, 0);
        rekapInventoriDeptServiceImp.saveRekap(rid);
        return "redirect:/in/rekapinven";
    }

    @PostMapping("/in/terimarekapinven")
    public String terimaRekapInven(
            @RequestParam(value = "barangId") Integer barangId,
            @RequestParam(value = "barangNama") String barangNama,
            @RequestParam(value = "tglInput") String tglInput,
            @RequestParam(value = "itemKeluar") int itemKeluar,
            @RequestParam(value = "itemMasuk1") int itemMasuk1,
            @RequestParam(value = "tglTerima") String tglTerima,
            @RequestParam(value = "itemMasuk") int itemMasuk) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        Date dateUp = null;
        try {
            date = formatter.parse(tglInput);
            dateUp = formatter.parse(tglTerima);
        } catch (ParseException e) {
        }
        int jumlah = 0;
        jumlah = itemMasuk1 + itemMasuk;
        Inventori inventori = new Inventori();
        inventori = new Inventori(barangId, barangNama, date, dateUp, jumlah, itemKeluar);
        inventoriServiceImp.saveInven(inventori);
        return "redirect:/in/rekapinven";
    }

    @GetMapping("/in/laporaninven")
    public String laporaninven() {
        return "menuLaporanInven";
    }

    @GetMapping("/in/laporaninvenview")
    public String laporaninvenview(Model model) {
        model.addAttribute("inven", inventoriServiceImp.findAllInventori());
        return "menuLaporanInvenView";
    }
    
    @GetMapping("/in/laporaninvenview_d")
    public String laporaninvendepartview(Model model) {
        model.addAttribute("rekapdept", rekapInventoriDeptServiceImp.findAllRekap());
        model.addAttribute("deptAll", deptServiceImp.findAllAkses());
        return "menuLaporanInvenView_D";
    }
    
    @GetMapping("/in/laporaninvenprint")
    public String laporaninvenprint(Model model) {
        model.addAttribute("inven", inventoriServiceImp.findAllInventori());
        return "menuLaporanInvenPrint";
    }
    
    @GetMapping("/in/laporaninvenprint_d")
    public String laporandinvendepartprint(Model model) {
        model.addAttribute("rekapdept", rekapInventoriDeptServiceImp.findAllRekap());
        return "menuLaporanInvenPrint_D";
    }
    
//    END menu Rekap Inventori
    
//    GET MAP MANAGER
    @GetMapping("/ma/utamamgr")
    public String utamamgr() {
        return "menuUtamaManajer";
    }
    
    @GetMapping("/ma/menumgr")
    public String manager(Model model) {
        model.addAttribute("rekapAll", rekapInventoriDeptServiceImp.findAllRekap());
        return "menuManager";
    }

    @PostMapping("/ma/apprmgr")
    public String apprMgr(
            @RequestParam(value = "rekapId") Integer id,
            @RequestParam(value = "rIdDept") Departemen deptId,
            @RequestParam(value = "rIdInven") Inventori invenId,
            @RequestParam(value = "invenNama") String invenNama,
            @RequestParam(value = "jumlahKeluar") int jumKel,
            @RequestParam(value = "rJumTerpakai") int rJumTerpakai,
            @RequestParam(value = "rKet") String keterangan,
            @RequestParam(value = "rTglMasuk") String tglMasuk,
            @RequestParam(value = "status") String status
    ) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("departemen5819@gmail.com");
        message.setSubject("Pemberitahuan dari Manajer !");
        message.setText("Inventori " + invenNama + " telah di "+status+ "!");
        
        javaMailSender.send(message);
        
        int stat = 0;
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(tglMasuk);
        } catch (ParseException e) {
        }
        if ("Setuju".equals(status)) {
            stat = 1;
        } else if ("Tolak".equals(status)) {
            stat = 2;
        }
        RekapInventoriDept rid = new RekapInventoriDept();
        rid = new RekapInventoriDept(id, jumKel, jumKel, rJumTerpakai, keterangan, stat, date, new Date(), deptId, invenId);
        rekapInventoriDeptServiceImp.saveRekap(rid);
        return "redirect:/ma/menumgr";
    }
    
    @GetMapping("/ma/laporanmgr")
    public String laporanmanajer() {
        return "menuLaporanManajer";
    }
    
    @GetMapping("/ma/laporanmgrview_d")
    public String laporanmgrdeptview(Model model) {
        model.addAttribute("rekapdept", rekapInventoriDeptServiceImp.findAllRekap());
        model.addAttribute("deptAll", deptServiceImp.findAllAkses());
        return "menuLaporanManajerView_D";
    }
    
    @GetMapping("/ma/laporanmgrview_i")
    public String laporanmgrinvenview(Model model) {
        model.addAttribute("inven", inventoriServiceImp.findAllInventori());
        return "menuLaporanManajerView_I";
    }
    
    @GetMapping("/ma/laporaninvenprint_m")
    public String laporaninvenmgrprint(Model model) {
        model.addAttribute("inven", inventoriServiceImp.findAllInventori());
        return "menuLaporanInvenPrint_M";
    }
    
    @GetMapping("/ma/laporandeptprint_m")
    public String laporandeptmgrprint(Model model) {
        model.addAttribute("rekapdept", rekapInventoriDeptServiceImp.findAllRekap());
        return "menuLaporanDeptPrint_M";
    }
//    END GET MAP MANAGER

    @RequestMapping(value = {"/", "", "/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }
}
