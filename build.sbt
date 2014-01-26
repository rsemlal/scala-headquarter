organization in ThisBuild := "scala-headquarter"

version in ThisBuild := "1.0"

scalacOptions in ThisBuild += "-deprecation"

scalacOptions in ThisBuild += "-feature"

scalacOptions in ThisBuild += "-unchecked"

EclipseKeys.createSrc in ThisBuild := EclipseCreateSrc.Default + EclipseCreateSrc.Resource + EclipseCreateSrc.Managed

EclipseKeys.withSource in ThisBuild := true