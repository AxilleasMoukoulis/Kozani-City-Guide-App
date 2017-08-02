-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Feb 02, 2016 at 01:27 AM
-- Server version: 5.5.46-0ubuntu0.14.04.2
-- PHP Version: 5.5.9-1ubuntu4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `city_guide`
--

-- --------------------------------------------------------

--
-- Table structure for table `Categories`
--

CREATE TABLE IF NOT EXISTS `Categories` (
  `category_id` int(1) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Όνομα κατηγορίας',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `Categories`
--

INSERT INTO `Categories` (`category_id`, `category_name`) VALUES
(1, 'Αξιοθέατα'),
(2, 'Διασκέδαση'),
(3, 'Εστίαση'),
(4, 'Διαμονή');

-- --------------------------------------------------------

--
-- Table structure for table `Points_of_interest`
--

CREATE TABLE IF NOT EXISTS `Points_of_interest` (
  `point_of_interest_id` int(10) NOT NULL AUTO_INCREMENT,
  `point_of_interest_name` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point_of_interest_subcategory_id` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point_of_interest_lantitude` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point_of_interest_longtitude` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point_of_interest_address` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `point_of_interest_description` varchar(2048) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`point_of_interest_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=89 ;

--
-- Dumping data for table `Points_of_interest`
--

INSERT INTO `Points_of_interest` (`point_of_interest_id`, `point_of_interest_name`, `point_of_interest_subcategory_id`, `point_of_interest_lantitude`, `point_of_interest_longtitude`, `point_of_interest_address`, `point_of_interest_description`) VALUES
(1, 'Καμπαναριό της Κοζάνης', '1', '40.300948', '21.7875805', 'Παύλου Μελά 7\nΚοζάνη 501 00', 'Το 1855 οι Κοζανίτες αποφασίζουν να χτίσουν ένα τετράγωνο, ψηλό και επιβλητικό καμπαναριό, εμβαδού 42 τετραγωνικών μέτρων, με 6 ορόφους και 26 μέτρα ύψος. Ψηλότερο από κάθε άλλο κτίριο στην πόλη και με προσανατολισμό τέτοιο ώστε κάθε μία από τις τέσσερις πλευρές του να αντιστοιχεί σε ένα από τα τέσσερα σημεία του ορίζοντα.\n            Το πρώτο μέρος του καμπαναριού χτίστηκε, όπως αναφέρουν επιγραφές στις τέσσερις όψεις του, το 1855 με συνολικό κόστος 62.152 γρόσια και 37 παράδες, χρήματα που συγκεντρώθηκαν αρχικά για την ανέγερση σχολείου και γυμνασίου. Στην κορυφή του τρούλου αντί για σταυρό που απαγορευόταν από τους Τούρκους, έβαλαν ένα μεταλλικό περιστέρι με ανοιχτές φτερούγες, ώστε από μακριά να προσομοιάζει με σταυρό.'),
(2, 'Pinelo', '5', '40.3012670', '21.7884154', 'Μακεδονομάχων 1-9, Κοζάνη 501 00, Ελλάδα', 'Ενα άψογο και σικάτο μαγαζί, μέρος για να απολαύσεις τον υπέροχο καφέ η το cocktail σου με την συντροφιά τις υπέροχης μουσικής και τις καλύτερης εξυπηρέτησης'),
(3, 'Τσέλικας Hotel', '10', '40.3030957', '21.8562753', 'EO kozanis - Larisas, Kozani 501 00, Greece', 'Το Hotel Tselikas 3 αστέρων βρίσκεται στα προάστια της Κοζάνης, σε απόσταση 5χλμ. από το κέντρο της πόλης. Στις εγκαταστάσεις λειτουργούν κουβανέζικο μπαρ, εξωτερική πισίνα, παιδική χαρά και γήπεδο ποδοσφαίρου 5x5. Παρέχονται δωρεάν ιδιωτικός χώρος στάθμευσης και δωρεάν Wi-Fi.\n'),
(4, 'Barcode', '4', '40.3019952', '21.7871547', 'Μουράτη, Κοζάνη 501 00, Ελλάδα', 'Η απαλή μουσική από jazz νότες σε συνδιασμό με την μεγαλύτερη γκάμα εκλεκτής μπύρας κάνουν τις νύχτες σας ρομαντικές ζεστές και αξέχαστες.'),
(5, 'Άγιος Γεώργιος', '2', '40.303794', '21.7954245', 'Εκκλησία Άγιος Γεώργιος, Αίμου Κοζάνη 501 00, Ελλά', 'Ιερός Ναός του Αγίου Γεωργίου υπήρχε στην ίδια με σήμερα θέση από τα τέλη του 18ου-αρχές 19ου αιώνα, όπως φανερώνει επιστολή του Αλή πασά του 1806 που δίνει την άδεια στο Νάνο Τουτουντζή να «φκιάσει» τον ιερό ναό του Αγίου Γεωργίου. Στην άδεια δε διευκρινίζεται αν με το «φκιάσει» εννοείται εκ θεμελίων ανέγερση μίας νέας εκκλησίας ή επιδιόρθωση και επέκταση κάποιας άλλης.'),
(6, 'Ζωοδόχος Πηγή', '2', '40.400053', '22.089116', 'Εθνική Οδός Αλεξάνδρειας Κοζάνης Ελλάδα', 'Είναι η τρίτη παλαιότερη εκκλησία της Κοζάνης μετά τον Άγιο Δημήτριο (1339) και τους Αγίους Αναργύρους (1612).\nΗ εκκλησία της Παναγίας είναι παλαιότερη του 18ου αιώνα.\nΤο παλαιότερο γραπτό στοιχείο που υπάρχει είναι ένα φιρμάνι του 1709 που επιτρέπει την επισκευή της μαζί με τον Ι.Ν. των Αγίων Αναργύρων. Άρα προϋπήρχε του Αγίου Νικολάου (1662) και λειτουργούσε για τις ανάγκες των κτηνοτρόφων και των γεωργών της Κοζάνης.\n'),
(7, 'Μουσείο Σύγχρονης Ιστορίας', '3', '40.302277', '21.7849235', 'Δημοκρατίας 2\nΚοζάνη 501 00', 'Εγκαινιάστηκε την Τετάρτη 20 Σεπτεμβρίου 2006, το Μουσείο Σύγχρονης Τοπικής Ιστορίας που ίδρυσε ο Δήμος Κοζάνης και η Εταιρία Διάσωσης Ιστορικών Αρχείων σε συνεργασία με τις τοπικές αντιστασιακές οργανώσεις. Εδώ και αρκετές δεκαετίες η προηγούμενη γενιά έπαψε να μεταδίδει στην επόμενη τη γνώση και τη στάση της για τον κόσμο. Ένας πολιτισμικός παγκοσμιοποιημένος οδοστρωτήρας πλήττει καίρια την πρόσληψη της ιστορικής γνώσης και επομένως τη δημιουργία της συνείδησης.'),
(8, 'Ιστορικό Λαογραφικό Μουσείο', '3', '40.301226', '21.7846045', 'Ίωνος Δραγούμη 8\nΚοζάνη 501 00', 'Το Ιστορικολαογραφικό Μουσείο Φυσικής Ιστορίας είναι δημιούργημα του Συνδέσμου Γραμμάτων και Τεχνών Νομού Κοζάνης. Οι συλλογές του Μουσείου μεταστεγάστηκαν από την ημέρα της ιδρύσεώς του τέσσερις φορές σε διάφορα μισθωμένα κτίρια. Η κατάσταση αυτή δεν μπορούσε να συνεχιστεί γι’αυτό ο Σύνδεσμος μερίμνησε και ανήγειρε ιδιόκτητο κτίριο, κατάλληλο για το σκοπό αυτό. Σε οικόπεδο που παραχώρησε ομόφωνα το Δημοτικό Συμβούλιο Κοζάνης στην οδό Ίωνος Δραγούμη όπου ήταν τα παλιά λουτρά, με δωρεές ιδιωτών, οργανισμών και συλλόγων και την οικονομική αρωγή της Πολιτείας, ο Σύνδεσμος ανήγειρε με αυτεπιστασία στην περίοδο 1980–1983 τετραώροφο κτίριο με υπόστεγο και υπόγειους βοηθητικούς χώρους.'),
(9, 'Αρχοντικό Βούρκα', '3', '40.301183', '21.7870955', 'Πλατεία Νίκης 11\nΚοζάνη 501 00', 'Το αρχοντικό Γρ. Βούρκα είναι κτίσμα του 18ου αι., το οποίο παρουσιάζει ενδιαφέρον από αρχιτεκτονικής κυρίως άποψης και έχει χαρακτηρισθεί ως ιστορικό μνημείο.\n Διασώζει τον περίβολο και την αυλή του και αποτελεί χαρακτηριστικό δείγμα της αστικής μακεδονικής αρχιτεκτονικής.\nΣτο εσωτερικό του κτηρίου υπάρχουν ενδιαφέρουσες ξύλινες διακοσμημένες οροφές και μουσάντρες.'),
(10, 'Οικία Γεώργιου Λασσάνη', '1', '40.299006', '21.7893985', 'Ολύμπού 2\nΚοζάνη 501 00', 'Ο Γεώργιος Λασσάνης ήταν λόγιος και πολιτικός από την Κοζάνη, ανέπτυξε δραστηριότητα ως συγγραφέας, δραματουργός, δάσκαλος, ενώ παράλληλα συμμετείχε στην επανάσταση του 1821. Γεννήθηκε το 1793 και πέθανε το 1870. Ήταν γιος γνωστού Κοζανίτη εμπόρου και έμεινε ορφανός από πατέρα σε μικρή ηλικία'),
(11, 'Βαλταδώρειο Γυμνάσιο Κοζάνης', '1', '40.300864', '21.7854835', 'Μπούσιου 1\nΚοζάνη 501 00', ' Το Βαλταδώρειο Γυμνάσιο Κοζάνης χτίστηκε το 1899. Ήταν μια δωρεά των αδερφών Βασίλειου και Λάμπρου Βαλταδώρου. Το 1900 οργανώνεται και λειτουργεί ως πλήρες εξατάξιο Γυμνάσιο με πρώτo Γυμνασιάρχη τον Παναγιώτη Λιούφη και δέχεται μετά από επιτυχείς εισιτήριες εξετάσεις μαθητές που τέλειωναν τις Αστικές σχολές αρρένων και μαθήτριες που τελείωναν το Παρθεναγωγείο. Στο ισόγειο λειτουργούσε η Ά αστική σχολή και στον πρώτο όροφο το Γυμνάσιο.\n            Έτσι άρχισε η πορεία ενός ιστορικού Γυμνασίου που μόρφωσε χιλιάδες παιδιά της Κοζάνης και της γύρω περιοχής. Το 1936-1937 το Μικτό Γυμνάσιο Κοζάνης γίνεται οκτατάξιο, χωρίζεται σε αμιγές Γυμνάσιο Αρρένων που μένει στο Βαλταδώρειο και σε Γυμνάσιο Θηλέων. '),
(12, 'Γέφυρα Summer Club', '6', '40.2995569', '21.8042082', 'Επαρ.Οδ. Κοζάνης - Πετρανών 15, Κοζάνη 501 00, Ελλ', 'Summer club, drinks, fun, best music & more.'),
(13, 'D.A.D.A. ', '6', '40.3017129', '21.7859853', 'Πλ. Τιαλίου 1-5, Κοζάνη 501 00, Ελλάδα', 'Ας μάθουμε από πού προέρχεται το όνομα του Club "D.a.d.a." Ο όρος Ντανταϊσμός ή Νταντά (Dada) είναι ένα καλλιτεχνικό κίνημα που αναπτύχθηκε μετά τον Πρώτο Παγκόσμιο Πόλεμο στις εικαστικές τέχνες καθώς και στη λογοτεχνία (κυρίως στην ποίηση), το θέατρο και την γραφιστική. Μεταξύ άλλων, το κίνημα ήταν και μια διαμαρτυρία ενάντια στη βαρβαρότητα του πολέμου και αυτού που οι Ντανταϊστές πίστευαν ότι ήταν μια καταπιεστική διανοητική αγκύλωση, τόσο στην τέχνη όσο και στην καθημερινότητα. Ο Ντανταϊσμός χαρακτηρίζεται από εσκεμμένο παραλογισμό και απόρριψη των κυρίαρχων ιδανικών της τέχνης.'),
(14, 'MIKEL', '4', '40.3014593', '21.7882544', 'Π. Μελά 4, Κοζάνη 501 00, Ελλάδα', 'Ο Λευτέρης Κυριακάκης ξεκίνησε την επαγγελματική του ενασχόληση με τον καφέ το 1996 ως υπάλληλος καφετέριας στη Λάρισα. Είναι γιος δωδεκαμελούς οικογένειας, με άλλα εννιά αδέλφια. Στα χρόνια που ακολούθησαν έκανε κάποια επιχειρηματικά βήματα πάντα με την σκέψη να δημιουργήσει κάποτε μια δική του αλυσίδα καφέ. Με εφόδιο την εμπειρία του, στα 29 του άνοιξε το πρώτο MIKEL στη Λάρισα.\r\n\r\nΗ ανταπόκριση και η εμπιστοσύνη των καταναλωτών τον ώθησαν να επεκτείνει σταδιακά το εγχείρημά του και σε άλλες πόλεις, με δεύτερο σταθμό το Βόλο. Η επιλογή του δικαιώθηκε. Σήμερα τα MIKEL διαθέτουν ένα δίκτυο 118 καταστημάτων σε όλη την Ελλάδα και αναπτύσσονται διαρκώς με σταθερό στόχο τη δημιουργία καλαίσθητων και φιλόξενων χώρων για την απόλαυση εξαιρετικής ποιότητας καφέ σε προσιτή τιμή.'),
(15, 'Nivel Tres ', '4', '40.3012097', '21.7876644', 'Πλ. Νίκης 11, Κοζάνη 501 00, Ελλάδα', 'Λιτός, απέριττος αλλά και με εμφανείς εγκαταστάσεις λειτουργίας στην πρωταρχική του μορφή αλλά και με πινελιές από την Mid Century σας υποδέχεται για να σας ανεβάσει σε άλλο “επίπεδο”.'),
(16, 'MOOI underbar', '6', '40.3016925', '21.7852879', 'Φόρη 3, Κοζάνη 501 00, Ελλάδα', 'Το είδαμε και αυτό και…μας άρεσε! Σφηνάκια ή….κοκτέιλ με βάση…μελομακάρονο σέρβιρε στην περίοδο των γιορτών το Club «Mooi» στην πόλη της Κοζάνης!\r\n\r\n20150101_065144Ο bartender Παύλος φρόντισε και γι’ αυτό, δίνοντας μια άκρως…πρωτότυπη γεύση στους θαμώνες του «Mooi»!!!'),
(17, 'Boulevard', '5', '40.3005060', '21.7997772', 'ΕΟ Αλεξάνδρειας Κοζάνης 1-5, Κοζάνη 501 00, Ελλάδα', 'Ένας χώρος στην Κοζάνη που κλέβει τις εντυπώσεις!\r\n\r\nΖητήσαμε από τους ιδιοκτήτες Βαγγέλη Παπαγεωργόπουλο, Σάββα Ασαλουμίδη, Στράτο Αποστολίδη και τον Chef του μαγαζιού Γιάννη Γιαννίτσα να μας αφηγηθούν την πετυχημένη συνταγή του Boulevard. Μία συνταγή γεμάτη εικόνες, έντονα αρώματα, φρέσκα υλικά και όραμα.\r\n\r\nΠοια ανάγκη σας οδήγησε στη δημιουργία του Boulevard;\r\n\r\nΕκτός από αυτή της δημιουργίας ήταν σίγουρα η ανάγκη να κάνουμε κάτι διαφορετικό κάτι που θα τάραζε τα νερά αυτής της πόλης.'),
(18, 'Άγιος Νικόλας', '2', '40.300827', '21.787493', 'Πανδώρας 1\nΚοζάνη 501 00', 'Το κτηριακό συγκρότημα της ενορίας του Αγίου Νικολάου αποτελείται εκτός από τον κυρίως ναό, το καμπαναριό, τον Ιερό Ναό Αγίου Νικολάου, από το γραφείο των ιερέων, τους αποθηκευτικούς χώρους και την έκθεση χριστιανικού βιβλίου, που όλα βρίσκονται μέσα στο περίβολο του Αγίου Νικολάου. Ο ρυθμός του ναού, είναι τρίκλιτη βασιλική καμαροσκέπαστη με δίρριχτη στέγη με πλάκες και κεραμίδια.\n'),
(19, 'Garderoba', '5', '40.3017580', '21.7873425', 'Κοβενταρών 1-3, Κοζάνη 501 00, Ελλάδα', 'Το Espresso Wine Bar Restaurant Garderoba άνοιξε τις πόρτες του και σας υποδέχεται στον πλήρως ανακαινισμένο χώρο του!  Επιλέξτε από τη wine list μας το αγαπημένο σας κρασί ή απολαύστε το ποτό σας και στον πάνω όροφο δοκιμάστε τις πρωτότυπες γεύσεις που ετοιμάσαμε για εσάς και συνοδεύστε τες με ιδιαίτερα κοκτέιλ!'),
(20, 'Τρυποκάρυδος', '7', '40.3016475', '21.7870689', 'Μουράτη 1-5, Κοζάνη 501 00, Ελλάδα', 'Το Beer Bar Restaurant ΤΡΥΠΟΚΑΡΥΔΟΣ λειτουργεί από τον Μάρτιο του 2002 σε ένα ξεχωριστό, ζεστό και φιλικό χώρο. Αποτελεί μια εναλλακτική πρόταση διασκέδασης που συνδυάζει ποτό, φαγητό και μουσική. Προσφέρει μεγάλη ποικιλία σε μπύρες και κρασιά, συνδυάζοντάς τα με ξεχωριστές γαστρονομικές προτάσεις βασισμένες στις γεύσεις της περιοχής μας. Τα πιάτα μας ετοιμάζονται από προσεγμένα φρέσκα υλικά αρίστης ποιότητος. Ένας ξεχωριστός τρόπος διασκέδασης που απευθύνεται σε όλους.'),
(21, 'Strada', '7', '40.3015861', '21.7870635', 'Μουράτη 1-5, Κοζάνη 501 00, Ελλάδα', 'Καλώς ήλθατε στην επίσημη σελίδα του Facebook για το Strada Restaurant Wine & Cocktails. \r\nΕίμαστε ένα εστιατόριο σύγχρονου στυλ που προσφέρει φαγητό, ποτά, δροσιστικά coctails, και κρασιά, σε ένα περιβάλλον υψηλής αισθητικής και χαλάρωσης.'),
(22, 'Tip Top', '7', '40.3009397', '21.7884798', 'Π. Μελά, Κοζάνη 501 00, Ελλάδα', 'Το φιλικό περιβάλλον, το πολύ καλό φαγητό, η άψογη εξυπηρέτηση και οι προσιτές τιμές, θα μετατρέψουν τη βραδινή σας έξοδο σε μια αξέχαστη εμπειρία.'),
(23, 'Το Κοτέτσι', '9', '40.3010788', '21.7868275', 'Δρίζη 1-5, Κοζάνη 501 00, Ελλάδα', 'Όλα στα κάρβουνα!\r\nΔείτε τις προσφορές μας!\r\n\r\nΔείτε τις προσφορές μας:\r\n• Ολόκληρο κοτόπουλο σούβλας ΜΟΝΟ 7 Ευρώ\r\n• Λεμονάτο κοτόπουλο σχάρας στα κάρβουνα με πατάτες ΜΟΝΟ 10 Ευρώ'),
(24, 'Ψαροταβέρνα Πέλαγος', '8', '40.2996673', '21.7873532', 'Κων/νου Μητροπολίτη 2-6, Κοζάνη 501 00, Ελλάδα', 'Ανακαλύψετε ένα μέρος ζεστό, φιλόξενο και αισθανθείτε σαν να είστε στο σπίτι σας – στην ψαροταβέρνα «Πέλαγος» θα βρείτε τις καλύτερες γεύσεις μαγειρεμένες με πολύ μεράκι, όπως και υψηλής ποιότητας εξυπηρέτηση.'),
(25, 'Μυροβόλος', '8', '40.3003424', '21.7871279', 'Ξενοφών Τριανταφυλίδη 2-4, Κοζάνη 501 00, Ελλάδα', 'ΤΩΡΑ!!\r\nΠΕΜΠΤΗ-ΠΑΡΑΣΚΕΥΗ-ΣΑΒΒΑΤΟ :ΚΟΚΟΡΕΤΣΙ\r\nΚΥΡΙΑΚΗ:ΑΡΝΙ\r\nΠΑΝΤΑ, ΟΛΑ ΣΤΑ ΚΑΡΒΟΥΝΑ!!'),
(26, 'Το Κουτουκι', '8', '40.2999333', '21.7996807', 'Επαρ.Οδ. Κοζάνης - Πετρανών 2-8, Κοζάνη 501 00, Ελ', 'Δέχεται κρατήσεις, Εξυπηρέτηση και χωρίς κράτηση, Ιδανικό για ομάδες, Ιδανικό για παιδιά, Φαγητό σε πακέτο, Κέιτερινγκ, Σερβιτόροι και Τραπεζάκια έξω'),
(27, 'Πέρπιρας', '9', '40.3025025', '21.7869992', 'Φαρμάκη 6-8, Κοζάνη 501 00, Ελλάδα', 'Ενα ομορφο κ ζεστο μαγαζι στο κεντρο της πολης σε παραδοσιακο στυλ. Ωραια μεζεδακια για ουζακι η κρασακι.Νοστιμα κρεατικα κ σαλατες , συνοδευτικα υπεροχα!'),
(28, 'Τζίτζικας Και Μέρμηγκας', '9', '40.3005960', '21.7865056', 'Εστίας 1, Κοζάνη 501 00, Ελλάδα', 'Τα εστιατόρια που σε βάθος χρόνου έχουν αποδείξει την επιτυχία τους είναι εκείνα που αντιμετωπίζουν με ειλικρίνεια τον πελάτη. Λαμπρό παράδειγμα είναι το γνωστό μαγαζί Τζίτζικας και Μέρμηγκας. Στέκι αγαπημένο των απανταχού πεινασμένων θνητών στην πλατεία Παπαδιαμάντη, στα Άνω Πατήσια, το εστιατόριο αυτό προσφέρει ποιοτικό, καθημερινό φαγητό. Φιλική κι ευχάριστη η ατμόσφαιρά του, με μοντέρνο στυλ και μπόλικη νεανική διάθεση. Ζητάς τίποτα καλύτερο; Άλλωστε, γι’ αυτό και το έχουν αγκαλιάσει οι περίοικοι, είναι το δικό τους μαγαζί. Η κουζίνα και το σέρβις αποπνέουν φροντίδα κι ένα σπιτικό καλωσόρισμα που το εισπράττεις με το που θα πάρεις θέση στα τραπεζάκια του. '),
(29, 'Αλιάκμων Hotel', '10', '40.2999660', '21.7910332', 'Νικολάου Δελιαλή 2-8, Kozani 501 00, Greece', 'Το Aliakmon Hotel βρίσκεται σε απόσταση 200μ. από το κέντρο της Κοζάνης. Πρόκειται για ένα καλαίσθητο ξενοδοχείο, κοντά σε σημεία ενδιαφέροντος, καταστήματα και εστιατόρια. Προσφέρει σνακ μπαρ, δωρεάν Wi-Fi σε όλους τους χώρους και δωρεάν ιδιωτικό χώρο στάθμευσης.\n'),
(30, 'Ermionio Hotel', '10', '40.3012547', '21.7876590', 'Πλ. Νίκης 11-13, Κοζάνη 501 00, Ελλάδα', '  Το ERMIONIO HOTEL, αναγεννημένο μέσα από τις στάχτες του, σας προσκαλεί σ'' έναν κόσμο αισθητικής, ξεχωριστής άνεσης και εκλεπτυσμένης πολυτέλειας στην πόλη της Κοζάνης. Σας ενθαρρύνουμε να διερευνήσετε την ιστοσελίδα μας και να επωφεληθείτε πλήρως από τα διαθέσιμα στοιχεία. Παρακαλούμε επικοινωνήσετε μαζί μας και θα είμαστε στην πάρα πολύ ευχάριστη θέση να βοηθήσουμε στα όποια από τα ερωτήματά σας.\r\n\r\nΜια νέα πρόταση φιλοξενίας γεννιέται ...');

-- --------------------------------------------------------

--
-- Table structure for table `Subcategories`
--

CREATE TABLE IF NOT EXISTS `Subcategories` (
  `subcategory_id` int(1) NOT NULL AUTO_INCREMENT,
  `subcategory_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT 'Όνομα Υποκατηγορίας (πχ. Μουσεία)',
  `subcategory_parent_id` int(1) DEFAULT NULL COMMENT 'Όνομα κατηγορίας υποκατηγορίας',
  PRIMARY KEY (`subcategory_id`),
  UNIQUE KEY `subcategory_name` (`subcategory_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `Subcategories`
--

INSERT INTO `Subcategories` (`subcategory_id`, `subcategory_name`, `subcategory_parent_id`) VALUES
(1, 'Ιστορικά Κτήρια', 1),
(2, 'Εκκλησίες', 1),
(3, 'Μουσεία', 1),
(4, 'Καφετέριες', 2),
(5, 'Μπαρ', 2),
(6, 'Κλαμπ', 2),
(7, 'Εστιατόρια', 3),
(8, 'Ταβέρνες', 3),
(9, 'Μεζεδοπωλεία', 3),
(10, 'Ξενοδοχεία', 4);

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_password` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`id`, `user_name`, `user_password`) VALUES
(1, 'city_guide', 'city_guide_2016');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;