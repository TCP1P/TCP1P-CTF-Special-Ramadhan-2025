password = [
    'qswaefrdthy_gukojplzcxvbmn', 'pkolihu_jyftgrsedwaqmzbxvc', 
    'mlnkbjvhcgxfzdsapqowueyr_t', 'plokijuhygtfrdeswaqmnbvcxz', 
    'qswdefrgthyjukilopmnbzvcx_', 'qswaefrgthyjukilpom_znxbcv', 
    'zqwsedrftgyhuji_kolpxcvbnm', 'qaedwsrf_tgujyhikpomznxbcv', 
    'mxnzbcvqsplokwdij_efuhrgyt', 'plokmnzbxvcijuygtfrdeswa_q', 
    'plmoknijbuhvygctfxrdzeswaq', 'qazwsxedcrfvtgbyhnujmikol_', 
    'wqzsxedcrfvt_gbyhnujmikolp', 'qazwxedcrf_vtgbyhnplmokiju', 
    'okmplijnuhbygvtfcrdxewqaz_', 'ygvtfcrd_xeszqaplmoknijbuh', 
    'ijnkmpluhbygvtfc_rdxeszwqa', 'tyuioplkjhgfdsaqwezxcvb_nm', 
    'mkolpijnuhbygv_tfcrxeszwaq', 'hubijnmkoplygvtfcrdxeszwaq', 
    'swxedcr_fvtgbynujmikolpqaz', 'trqwyuioplkjhgfdsazxcvbn_m', 
    'klopmijn_ubygvtfcrdxeszaqw', 'bvnmczxlaksjdhfgp_qowiruty'
]
alphabet = set("abcdefghijklmnopqrstuvwxyz")
result = ""
for word in password:
    used_chars = set(word.replace("_", ""))  
    missing_chars = list(alphabet - used_chars)  
    missing_chars.sort()  
    if "_" in word:
        result += missing_chars[0]  
print(result)
