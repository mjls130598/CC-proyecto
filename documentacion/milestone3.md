# Actividades relacionadas con Milestone 3

## Elección de contenedor base

Las posibles imágenes base con las que se podría ejecutar este proyecto dentro de un contenedor Docker son las siguientes:

* **Ubuntu**:
  * El tamaño del paquete Docker es de 28.6MB.
  * Es uno de los más utilizados tanto para nubes públicas como nubes OpenStack.
  * Puede ejecutar sus contenedores a escala.
  * Es rápido, seguro y sencillo.
  * Los usuarios que vienen por defecto son root, damon, bin, sys, sync, games, man, lp, mail, news, uucp, proxy, www-data, backup, list, irc, gnats, nobody y _apt.
  * Incluyen múltiples programas auxiliares como adduser, apt, base-files, base-passwd, bash, bsdutils, bzip2, coreutils, dash, debconf, debianutils, diffutils, dpkg, e2fsprogs, fdisk, findutils, gcc-10-base, gpgv, grep, gzip, hostname, init-system-helpers, libacl1, libapt-pkg6.0, libattr1, libaudit-common, libaudit1, libblkid1, libbz2-1.0, libc-bin, libc6, libcap-ng0, libcom-err2, libcrypt1, libdb5.3, libdebconfclient0, libext2fs2, libfdisk1, libffi7, libgcc-s1, libgcrypt20, libgmp10, libgnutls30, libgpg-error0, libhogweed5, libidn2-0, liblz4-1, liblzma5, libmount1, libncurses6, libncursesw6, libnettle7, libp11-kit0, libpam-modules-bin, libpam-modules, libpam-runtime, libpam0g, libpcre2-8-0, libpcre3, libprocps8, libseccomp2, libselinux1, libsemanage-common, libsemanage1, libsepol1, libsmartcols1, libss2, libstdc++6, libsystemd0, libtasn1-6, libtinfo6, libudev1, libunistring2, libuuid1, libzstd1, login, logsave, lsb-base, mawk, mount, ncurses-base, ncurses-bin, passwd, perl-base, procps, sed, sensible-utils, sysvinit-utils, tar, ubuntu-keyring, util-linux y zlib1g.
  * Tiene como variables de entorno HOME, HOSTNAME, LS_COLORS, PATH, PWD, SHLVL y TERM.
  * Fue actualizado hace un mes.

* **BusyBox**:
  * El tamaño de la imagen está entre 1MB y 5MB.
  * Proporciona los siguientes programas: acpid, addgroup, adduser, adjtimex, ar, arp, arping, ash,awk, basename, beep, blkid, brctl, bunzip2, bzcat, bzip2, cal, cat, catv, chat, chattr, chgrp, chmod, chown, chpasswd, chpst, chroot, chrt, chvt, cksum, clear, cmp, comm, cp, cpio, crond, crontab, cryptpw, cut, date, dc, dd, deallocvt, delgroup, deluser, depmod, devmem, df, dhcprelay, diff, dirname, dmesg, dnsd, dnsdomainname, dos2unix, dpkg, du, dumpkmap, dumpleases, echo, ed, egrep, eject, env, envdir, envuidgid, expand, expr, fakeidentd, false, fbset, fbsplash, fdflush, fdformat, fdisk, fgrep, find, findfs, flash_lock, flash_unlock, fold, free, freeramdisk, fsck, fsck.minix, fsync, ftpd, ftpget, ftpput, fuser, getopt, getty, grep, gunzip, gzip, hd, hdparm, head, hexdump, hostid, hostname, httpd, hush, hwclock, id, ifconfig, ifdown, ifenslave, ifplugd, ifup, inetd, init, inotifyd, insmod, install, ionice, ip, ipaddr, ipcalc, ipcrm, ipcs, iplink, iproute, iprule, iptunnel, kbd_mode, kill, killall, killall5, klogd, last, length, less, linux32, linux64, linuxrc, ln, loadfont, loadkmap, logger, login, logname, logread, losetup, lpd, lpq, lpr, ls, lsattr, lsmod, lzmacat, lzop, lzopcat, makemime, man, md5sum, mdev, mesg, microcom, mkdir, mkdosfs, mkfifo, mkfs.minix, mkfs.vfat, mknod, mkpasswd, mkswap, mktemp, modprobe, more, mount, mountpoint, mt, mv, nameif, nc, netstat, nice, nmeter, nohup, nslookup, od, openvt, passwd, patch, pgrep, pidof, ping, ping6, pipe_progress, pivot_root, pkill, popmaildir, printenv, printf, ps, pscan, pwd, raidautorun, rdate, rdev, readlink, readprofile, realpath, reformime, renice, reset, resize, rm, rmdir, rmmod, route, rpm, rpm2cpio, rtcwake, run-parts, runlevel, runsv, runsvdir, rx, script, scriptreplay, sed, sendmail, seq, setarch, setconsole, setfont, setkeycodes, setlogcons, setsid, setuidgid, sh, sha1sum, sha256sum, sha512sum, showkey, slattach, sleep, softlimit, sort, split, start-stop-daemon, stat, strings, stty, su, sulogin, sum, sv, svlogd, swapoff, swapon, switch_root, sync, sysctl, syslogd, tac, tail, tar, taskset, tcpsvd, tee, telnet, telnetd, test, tftp, tftpd, time, timeout, top, touch, tr, traceroute, true, tty, ttysize, udhcpc, udhcpd, udpsvd, umount, uname, uncompress, unexpand, uniq, unix2dos, unlzma, unlzop, unzip, uptime, usleep, uudecode, uuencode, vconfig, vi, vlock, volname, watch, watchdog, wc, wget, which, who,  whoami, xargs, yes, zcat y zcip.
  * Tiene como usuarios root, daemon, bin, sys, sync, mail, www-data, operator y nobody.
  * Las variables de entorno que utiliza son HOME, HOSTNAME, PATH, PWD, SHLVL y TERM.
  * Su última actualización se publicó hace cinco semanas.

* **Alpine**:
  * El tamaño de la imagen es alrededor de 5MB.
  * Los tipos de usuarios que ofrece son: root, bin, daemon, adm, lp, sync, shutdown, halt, mail, news, uucp, operator, man, postmaster, cron, ftp, sshd, at, squid, xfs, games, cyrus, vpopmail, ntp, smmsp, guest y nobody.
  * Las variables de entorno que utiliza son HOME, HOSTNAME, PATH, PWD, SHLVL y TERM.
  * Los programas auxiliares que tiene son: musl, zlib, apk-tools, libssl y libcrypto de openssl, alpine-bselayout, alpine-keys, busybox, scanelf de pax-utils, ca-certificates, libc-dev, libtls-standalone, ssl_client de busybox.
  * Se actualizó hace un mes aproximadamente.

* **CentOS**:
  * El tamaño de la imagen está alrededor de los 200MB.
  * Las variables de entorno que tiene por defecto son HOME, HOSTNAME, LANG, LESSOPEN, PATH, PWD, SHLVL y TERM.
  * Los programas auxiliares que tiene instalado en él acl.x86_64, audit-libs.x86_64, basesystem.noarch, bash.x86_64, bind-export-libs.x86_64, binutils.x86_64, bzip2-libs.x86_64, ca-certificates.noarch, centos-gpg-keys.noarch, centos-release.x86_64, centos-repos.x86_64, chkconfig.x86_64, coreutils-single.x86_64, cpio.x86_64, cracklib.x86_64, crypto-policies.noarch, cryptsetup-libs.x86_64, curl.x86_64, cyrus-sasl-lib.x86_64, dbus.x86_64, dbus-common.noarch, dbus-daemon.x86_64, dbus-libs.x86_64, dbus-tools.x86_64, device-mapper.x86_64, device-mapper-libs.x86_64, dhcp-client.x86_64, dhcp-common.noarch, dhcp-libs.x86_64, dnf.noarch, dnf-data.noarch, dracut.x86_64, dracut-network.x86_64, dracut-squash.x86_64, elfutils-default-yama-scope.noarch, elfutils-libelf.x86_64, elfutils-libs.x86_64, ethtool.x86_64, expat.x86_64, file-libs.x86_64, filesystem.x86_64, findutils.x86_64, gawk.x86_64, gdbm.x86_64, gdbm-libs.x86_64, glib2.x86_64, glibc.x86_64, glibc-common.x86_64, glibc-minimal-langpack.x86_64, gmp.x86_64, gnupg2.x86_64, gnutls.x86_64, gpgme.x86_64, grep.x86_64, gzip.x86_64, hostname.x86_64, ima-evm-utils.x86_64, info.x86_64, ipcalc.x86_64, iproute.x86_64, iptables-libs.x86_64, iputils.x86_64, json-c.x86_64 , kexec-tools.x86_64, keyutils-libs.x86_64, kmod.x86_64, kmod-libs.x86_64, krb5-libs.x86_64, langpacks-en.noarch, less.x86_64, libacl.x86_64, libarchive.x86_64, libassuan.x86_64, libattr.x86_64, libblkid.x86_64, libcap.x86_64, libcap-ng.x86_64, libcom_err.x86_64, libcomps.x86_64, libcurl-minimal.x86_64, libdb.x86_64, libdb-utils.x86_64, libdnf.x86_64, libfdisk.x86_64, libffi.x86_64, libgcc.x86_64, libgcrypt.x86_64, libgpg-error.x86_64, libidn2.x86_64, libkcapi.x86_64, libmnl.x86_64, libmodulemd1.x86_64, libmount.x86_64, libnghttp2.x86_64, libnsl2.x86_64, libpcap.x86_64, libpwquality.x86_64, librepo.x86_64, libreport-filesystem.x86_64, libseccomp.x86_64, libselinux.x86_64, libsemanage.x86_64, libsepol.x86_64, libsigsegv.x86_64 , libsmartcols.x86_64, libsolv.x86_64, libstdc++.x86_64, libtasn1.x86_64, libtirpc.x86_64, libunistring.x86_64, libusbx.x86_64, libutempter.x86_64, libuuid.x86_64, libverto.x86_64, libxcrypt.x86_64, libxml2.x86_64, libyaml.x86_64, libzstd.x86_64, lua-libs.x86_64, lz4-libs.x86_64, lzo.x86_64, mpfr.x86_64, ncurses-base.noarch, ncurses-libs.x86_64,nettle.x86_64, npth.x86_64, openldap.x86_64, openssl-libs.x86_64, p11-kit.x86_64, p11-kit-trust.x86_64, pam.x86_64, pcre.x86_64, pcre2.x86_64, platform-python.x86_64, platform-python-setuptools.noarch, popt.x86_64, procps-ng.x86_64, python3-dnf.noarch, python3-gpg.x86_64, python3-hawkey.x86_64, python3-libcomps.x86_64, python3-libdnf.x86_64, python3-libs.x86_64, python3-pip-wheel.noarch, python3-rpm.x86_64, python3-setuptools-wheel.noarch, readline.x86_64, rootfiles.noarch, rpm.x86_64, rpm-build-libs.x86_64, rpm-libs.x86_64, sed.x86_64, setup.noarch, shadow-utils.x86_64 , snappy.x86_64, sqlite-libs.x86_64, squashfs-tools.x86_64, systemd.x86_64, systemd-libs.x86_64, systemd-pam.x86_64, systemd-udev.x86_64, tar.x86_64, tzdata.noarch, util-linux.x86_64, vim-minimal, xz.x86_64, xz-libs.x86_64, yum.noarch y zlib.x86_64.
  * Los usuarios que se crean por defecto son root, bin, daemon, adm, lp, sync, shutdown, halt, mail, operator, games, ftp, nobody, dbus, systemd-coredump y systemd-resolve.
  * La última actualización se ejecutó hace tres meses.

Entre las comentadas se ha elegido *Ubuntu* como imagen base del contenedor al ofrecer los recursos justos que se pueden necesitar para el proyecto.

## Dockerfile

Primero, se indica la imagen base que se va a usar, en este caso es Ubuntu 18.04.

`FROM ubuntu:18.04`

A continuación, se indica que el directorio donde va a trabajar el contenedor es *sharing*.

`WORKDIR app/test`

Posteriormente, el directorio creado en el paso anterior se indica que va a ser el volumen del contenedor.

`VOLUME app/test`

Después, se copia en el contenedor los archivos que forman parte del proyecto:

`COPY src/SharingNotes .`

Seguidamente, se actualiza el sistema y se instala todo aquello necesario para instalar y ejecutar *sbt*. Una vez instalado *sbt* se borra aquellas herramientas que fueron necesarias para su instalación.

```
RUN  apt-get update && apt-get install -y curl gnupg && \
  echo "deb https://dl.bintray.com/sbt/debian /" | tee -a /etc/apt/sources.list.d/sbt.list && \
  curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add && \
  apt-get update && \
  apt-get install -y sbt openjdk-11-jdk && \
  apt-get remove -y curl gnupg
```

Por último, se ejecutan los tests del proyecto cuando se ejecute el contenedor.

`CMD sbt test`

El fichero donde está escrito la explicación anterior se encuentra en [*Dockerfile*](https://github.com/mjls130598/SharingNotes/blob/master/Dockerfile).

## Subir Dockerfile a DockerHub

Para subir el *Dockerfile* anterior a *DockerHub*, primero hay que crearse una cuenta en él.

Una vez creada la cuenta, nos dirigimos al apartado *Repositories* y, dentro de él, clickeamos sobre el botón que hay en la esquina derecha superior *Create Repository*.

A continuación, se escribe el nombre del repositorio y una breve descripción. En este caso se llama de la misma manera que este repositorio (*sharingnotes*). Se deja como repositorio público y se señala el repositorio de *GitHub* al que debe estar conectado. Por último, se indica dónde se encuentra el archivo *Dockerfile* dentro del repositorio *GitHub* dado.

Los datos comentados anteriormente se refleja en las siguientes imágenes:

![Creando repositorio](https://github.com/mjls130598/SharingNotes/tree/master/documentacion/imagenes/milestone3/dockerHubCreate.png "Creando repositorio en DockerHub")
![Creando repositorio](https://github.com/mjls130598/SharingNotes/tree/master/documentacion/imagenes/milestone3/dockerHubCreate2.png "Creando repositorio en DockerHub")

Por lo tanto, el repositorio creado en *DockerHub* se encuentra en el siguiente [enlace](https://hub.docker.com/repository/docker/mjls130598/sharingnotes/).

En la siguiente imagen, podemos ver que se ha automatizado la actualización del contenedor y que se ha construido el *Dockerfile* del apartado anterior correctamente.

![Automatización](https://github.com/mjls130598/SharingNotes/tree/master/documentacion/imagenes/milestone3/dockerHubAutomated.png "Actualizaciones automáticas en DockerHub")

## Uso de registros alternativos y públicos de contenedores

Hay diversos tipos de registros de contenedores alternativos a *DockerHub*, como *Container Registry* de Google, *Azure Container Registry*, *GitLab Container Registry* y *GitHub Container Registry*. Se decide utilizar *GitHub Container Registry* al estar el proyecto almacenado en un repositorio de GitHub, para que así se pueda acceder al contenedor más fácilmente.

Los pasos que sean seguido para utilizar *GitHub Container Registry*, obtenidos de su [página oficial](https://docs.github.com/en/free-pro-team@latest/packages/managing-container-images-with-github-container-registry/pushing-and-pulling-docker-images), son los siguientes:

1. Crear un token de acceso personal a través de la página oficial de *GitHub*, en el apartado *Settings*, dentro de la sección *Developer settings*. Dentro de la última sección nos dirigimos a *Personal Access Token* y se genera un nuevo token. Para generar el nuevo token para *Docker*, se debe activar los permisos *repo* y *write:packages*. Cuando se haya generado, se copia y se guarda en un archivo llamado *TOKEN.txt* Para realizar este paso se ha seguido la página oficial de *GitHub* sobre los [tokens de acceso personal](https://docs.github.com/es/free-pro-team@latest/github/authenticating-to-github/creating-a-personal-access-token).

2. Una vez obtenido y guardado el token, autenticamos el paquete con *Docker* con la siguiente orden `cat /media/mjesus/MJESUS/TOKEN.txt | sudo docker login ghcr.io -u mjls130598 --password-stdin`.

3. Activar el soporte de mejora de contenedores, dirigiéndose en el menú desplegable de la foto de perfil de la esquina derecha de la ventana a *Feature preview* y, dentro de ella, a *Enable*. Esta información se ha sacado de una página oficial de [*GitHub*](https://docs.github.com/en/free-pro-team@latest/packages/getting-started-with-github-container-registry/enabling-improved-container-support).

4. Cuando se haya autenticado correctamente, se publica el paquete. Para eso escribimos los siguientes comandos en la terminal con los datos obtenidos de la imagen creada en el *Docker* local.

```
sudo docker tag a9b72808c2b5 ghcr.io/mjls130598/sharingnotes/sharingnotes:1.0.0
sudo docker push ghcr.io/mjls130598/sharingnotes/sharingnotes:1.0.0
```
El paquete creado debe aparecer en la página *Packages* como la que se muestra en la siguiente imagen:

![Paquete creado](https://github.com/mjls130598/SharingNotes/tree/master/documentacion/imagenes/milestone3/packages.png "Paquete creado")

Para que este paquete sea público, debemos acceder dentro de él, a *Package Settings* y, en la zona *Danger Zone* clickear sobre *Make public*.

Por último, para que esté conectado con este repositorio, dentro de la página del paquete, se le da a *Connect Repository* y se selecciona el repositorio al que se quiere conectar. Una vez dado, debe aparecer en esa misma página el README del repositorio.

## Avances en el proyecto

Los avances que se han realizado para este milestone son los siguientes:

* Se ha arreglado la seguridad del proyecto en cuanto a quién debe realizar una cierta acción dentro del sistema comprobando la clase del usuario gracias al conjunto de métodos `getClass.getSimpleName`. Este cambio se ve reflejado en el issue [*"Mejorar la seguridad del sistema"*](https://github.com/mjls130598/SharingNotes/issues/34) que corresponde a las historias de usuario [HU6](https://github.com/mjls130598/SharingNotes/issues/16), [HU7](https://github.com/mjls130598/SharingNotes/issues/17), [HU8](https://github.com/mjls130598/SharingNotes/issues/18) y [HU9](https://github.com/mjls130598/SharingNotes/issues/19).

* Corregir la parte de la URL del fichero importado para sólo quedarse con el nombre de éste, es decir, no se incluya la ruta donde el usuario tiene guardado en su dispositivo (tanto Windows u otro dispositivo) el apunte subido. Esta corrección se encuentra detallada en el issue [*"Cambiar el nombre que se guarda cuando se inserta un fichero en memoria"*](https://github.com/mjls130598/SharingNotes/issues/38). Esta parte pertenece a la historia de usuario [HU2](https://github.com/mjls130598/SharingNotes/issues/12).

* Se ha encontrado una [biblioteca de *Lucene*](https://github.com/outr/lucene4s) para *Scala* para realizar la recuperación de información correspondientes con las historias de usuario [HU4](https://github.com/mjls130598/SharingNotes/issues/14) y [HU11](https://github.com/mjls130598/SharingNotes/issues/30). Se ha estado investigando cómo funciona realmente y cómo se puede incorporar al proyecto según los datos que éste vaya a almacenar y a manejar.
