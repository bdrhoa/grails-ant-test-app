class BootStrap {

	def antUtilsService
	
    def init = { servletContext ->
		
		def planZipFile = "C:\\Users\\Brad\\Desktop\\temp\\itemtest.zip"
		def theZipFile = new File("C:\\Users\\Brad\\Desktop\\temp\\itemtest.zip")
		def workingDirName = "C:\\Users\\Brad\\Desktop\\temp\\temp42\\"
		def workingDirName2 = "C:\\Users\\Brad\\Desktop\\temp\\temp43\\"
		def workingDirName3 = "C:\\Users\\Brad\\Desktop\\temp\\temp44\\"
		def fileNotFound = new File("C:\\Users\\Brad\\Desktop\\temp\\fileNotFound.zip")
		def notAZip = new File("C:\\Users\\Brad\\Desktop\\temp\\Penguins.jpg")
		def notAZipStr = "C:\\Users\\Brad_2\\Desktop\\temp\\Penguins.jpg"
		
		//def unzip(String zipFile,  String destDir)
		antUtilsService.unzip(planZipFile,workingDirName)
		
		//def unzip(String zipFile,  String destDir, String mapperType)
		antUtilsService.unzip(planZipFile,workingDirName2,"flatten")
		
		//def unzip(String zipFile,  String destDir, Boolean overwrite)
		antUtilsService.unzip(planZipFile,workingDirName,true)
		
		//def unzip(String zipFile,  String destDir, String mapperType, Boolean overwrite)		
		antUtilsService.unzip(planZipFile,workingDirName2,"flatten",true)
		
		
		//def zip(String destfile,String basedir)
		antUtilsService.zip("newzip.zip",workingDirName2)
		
		//def zip(String destfile,String basedir,String includes)
		antUtilsService.zip("newzip.zip",workingDirName2,"**/*.*")
		
		//def zip(String destfile,String basedir,String includes,String excludes)
		antUtilsService.zip("newzip.zip",workingDirName2,"**/*.*","")
		
		
		ant.echo message: 'Hello From Ant!'
				
		ant.property(name: 'myProp', value: 'blabla')
		println ant.project.properties.'myProp'
		println ant.project.properties.'java.version'
		
		def props = ant.getProperties()
		props.each {println it}
		
		assert antUtilsService.isValidZip(theZipFile)  == true
		assert antUtilsService.isValidZip(fileNotFound) == false
		assert antUtilsService.isValidZip(notAZip)		== false
		
		try {
			antUtilsService.unzip(notAZipStr,workingDirName)
		} catch (org.grails.plugins.grailsant.UnzipException e) {
			println e.message
			println e.fileName
		}
		
    }
    def destroy = {
    }
}
